import java.util.ArrayList;

public class Player {
    protected ArrayList<Card> hand;
    protected int number;
    
    Player(){
        hand = new ArrayList<>();
    }
    public int getNumber() {
        return number;
    }
    public boolean hasCard(Card card){
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).equals(card)){
                return true;
            }
        }
        return false;
    }
    public void fillHand(Card card){
        hand.add(card);
    }
    public Card popCard(Card card){
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).equals(card)){
                return hand.remove(i);
            }
        }
        return null;
    }
    public void start(){
        
    }
    public QuestionAnswered respond(Question question){
        return new QuestionAnswered(question, false);
    }
    public void turn(ArrayList<HistoryObject> history){
        
    }
    //TEST METHOD (do not use in actual game)
    public String toString(){
        String result = "Player " + number + ": " + hand; 
        return result;
    }
}
