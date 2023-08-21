package org.example.Questions;

public abstract class AbstractQuestions {
     private final String question;

     public AbstractQuestions(String question){
          this.question = question;
     }
     public String getQuestion(){
          return question;
     }
     public abstract boolean checkAnswer(String answer);
}
