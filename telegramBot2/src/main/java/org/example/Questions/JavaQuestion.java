package org.example.Questions;

public class JavaQuestion extends AbstractQuestions{

    public JavaQuestion(){
        super("Сколько примитивов есть в Java?");
    }

    public boolean checkAnswer(String answer){
        return answer.equals("8");
    }
}
