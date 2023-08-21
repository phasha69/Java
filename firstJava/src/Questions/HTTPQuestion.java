package Questions;

public class HTTPQuestion extends AbstractQuestions {

    public HTTPQuestion(){
        super("Какие методы HTTP-запросов вам известны? Перечислите их через запятую");
    }
    public boolean checkAnswer(String answer)
    {
        answer = answer.toUpperCase();
        return answer.contains("GET") &&
                answer.contains("POST") &&
                answer.contains("PUT") &&
                answer.contains("PATCH") &&
                answer.contains("DELETE");
    }
}
