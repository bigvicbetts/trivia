package com.bettsinc.trivia.mapping;

public interface Mapper<ReturnT, SourceT> {

    ReturnT map(SourceT source);
}
