public class Question extends HistoryObject{
    private Player playerAnswering;
    private Card cardRequesting;
    
    public Player getPlayerAnswering() {
        return playerAnswering;
    }

    public Card getCardRequesting() {
        return cardRequesting;
    }

    Question(Player playerAsking, Player playerAnswering, Card cardRequesting){
        super(playerAsking);
        this.playerAnswering = playerAnswering;
        this.cardRequesting = cardRequesting;
    }
}
