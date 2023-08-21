package org.example.Questions;

public class GitQuestion extends AbstractQuestions {
    public GitQuestion(){
        super("Какой командой можно просмотреть информацию о том,\n" +
                "кто в файле был автором каждой написаннонй строки кода?");
    }

    public boolean checkAnswer(String answer) {
        return answer.toLowerCase().contains("blame");
    }
}
