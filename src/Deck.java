import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    Deck(){
        deck = new ArrayList<>();
        for (int i = 2; i < 15; i++){
            for (int j = 1; j < 5; j++){
                deck.add(new Card(i, j));
            }
        }
        //jokers
        deck.add(new Card(0, 0));
        deck.add(new Card(1, 0));
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card deal(){
        return deck.remove(0);
    }
}
