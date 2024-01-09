public class Set extends HistoryObject{
    private int set;
    private Player firstCard;
    private Player secondCard;
    private Player thirdCard;
    private Player fourthCard;
    private Player fifthCard;
    private Player sixthCard;
    
    Set(Player playerCalling, int set, Player firstCard, Player secondCard, Player thirdCard, Player fourthCard, Player fifthCard, Player sixthCard){
        super(playerCalling);
        this.set = set;
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
        this.fourthCard = fourthCard;
        this.fifthCard = fifthCard;
        this.sixthCard = sixthCard;
    }
    public int getSet() {
        return set;
    }
    public Player getFirstCard() {
        return firstCard;
    }
    public Player getSecondCard() {
        return secondCard;
    }
    public Player getThirdCard() {
        return thirdCard;
    }
    public Player getFourthCard() {
        return fourthCard;
    }
    public Player getFifthCard() {
        return fifthCard;
    }
    public Player getSixthCard() {
        return sixthCard;
    }
}
