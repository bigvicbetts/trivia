package com.bettsinc.trivia.dao.rest;

import com.bettsinc.trivia.dao.QuestionRepository;
import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.dao.rest.model.Response;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
public class RestOperationsQuestionRepository implements QuestionRepository {

    private static final String QUESTION_URI = "https://opentdb.com/api.php";
    private final Client client = ClientBuilder.newClient();


    @Override
    public List<QuestionDao> getQuestions(int amount, int category, String difficulty) {

        Response response = client.target(QUESTION_URI)
                .queryParam("amount", amount)
                .queryParam("category", category)
                .queryParam("difficulty", difficulty)
                .queryParam("type", "multiple")
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);

        return response.getQuestions();
    }
}
