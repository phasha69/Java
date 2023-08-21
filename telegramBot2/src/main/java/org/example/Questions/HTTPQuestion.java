package org.example.Questions;

import java.util.Arrays;
import java.util.List;

public class HTTPQuestion extends AbstractQuestions {

    public HTTPQuestion() {
        super("Какие методы HTTP-запросов вам известны? Перечислите их через запятую");
    }

    public boolean checkAnswer(String answer) {
        answer = answer.toUpperCase();
        String[] SQ = {"GET", "PUT", "POST", "PATCH", "DELETE"};
        String[] answerArray = answer.split("[,.\\s]+");
        return Arrays.deepEquals(SQ, answerArray);
    }
}
