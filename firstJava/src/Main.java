import Questions.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        AbstractQuestions[] questions = {new JavaQuestion(), new SQLQuestion(), new HTTPQuestion(), new GitQuestion()};
        for (AbstractQuestions question : questions){
            System.out.println(question.getQuestion());
            System.out.println( question.checkAnswer(new Scanner(System.in).nextLine()) ? "Верно!" : "Не верно(((");
        }
    }
}