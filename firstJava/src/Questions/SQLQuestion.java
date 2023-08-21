package Questions;

public class SQLQuestion extends AbstractQuestions{
    public SQLQuestion(){
        super("Сколько типов связей между таблицами существует в реляционных базах данных?");
    }

    public boolean checkAnswer(String answer){
        return answer.equals("3");
    }
}
