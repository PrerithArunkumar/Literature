public class QuestionAnswered extends Question {
    private boolean isSuccess;
    
    QuestionAnswered(Question question, boolean isSuccess){
        super(question.getPlayer(), question.getPlayerAnswering(), question.getCardRequesting());
        this.isSuccess = isSuccess;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
}
