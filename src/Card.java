public class Card {
    private final int rank;
    private final int suit;
    private final int set;
    
    public boolean isJoker = false;


    // Kinds of sets
    public final static int LOWDIAMONDS = 1;
    public final static int HIGHDIAMONDS = 2;
    public final static int LOWCLUBS = 3;
    public final static int HIGHCLUBS = 4;
    public final static int LOWHEARTS = 5;
    public final static int HIGHHEARTS = 6;
    public final static int LOWSPADES = 7;
    public final static int HIGHSPADES = 8;
    public final static int EIGHTSJOKERS = 9; 
    // Kinds of suits
    public final static int DIAMONDS = 1;
    public final static int CLUBS    = 2;
    public final static int HEARTS   = 3;
    public final static int SPADES   = 4;
    public final static int JOKERS   = 0;
    // Kinds of ranks
    public final static int REDJOKER = 0;
    public final static int BLACKJOKER   = 1;
    public final static int TWO   = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    public final static int FIVE  = 5;
    public final static int SIX   = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE  = 9;
    public final static int TEN   = 10;
    public final static int JACK  = 11;
    public final static int QUEEN = 12;
    public final static int KING  = 13;
    public final static int ACE = 14;

    public Card(int rank, int suit) {
        if (suit == 0){
            isJoker = true;
        }else{
            assert isValidRank(rank);
            assert isValidSuit(suit);
        }
        int set;
        this.rank = rank;
        this.suit = suit;
        switch (suit) {
            case DIAMONDS:
                if (rank < 8){
                    set = LOWDIAMONDS;
                }else if (rank > 8){
                    set = HIGHDIAMONDS;
                }else{
                    set = EIGHTSJOKERS;
                }
            case CLUBS:
                if (rank < 8){
                    set = LOWCLUBS;
                }else if (rank > 8){
                    set = HIGHCLUBS;
                }else{
                    set = EIGHTSJOKERS;
                }
            case HEARTS:
                if (rank < 8){
                    set = LOWHEARTS;
                }else if (rank > 8){
                    set = HIGHHEARTS;
                }else{
                    set = EIGHTSJOKERS;
                }
            case SPADES:
                if (rank < 8){
                    set = LOWSPADES;
                }else if (rank > 8){
                    set = HIGHSPADES;
                }else{
                    set = EIGHTSJOKERS;
                }
            case JOKERS:
                set = EIGHTSJOKERS;
            default:
                set = 0;
        }
        this.set = set;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSet() {
        return set;
    }

    public int getSetNumber(){
        if (set == EIGHTSJOKERS){
            if (suit == JOKERS){
                return rank;
            }
            switch (suit){
                case DIAMONDS:
                    return 2;
                case CLUBS:
                    return 3;
                case HEARTS:
                    return 4;
                case SPADES:
                    return 5;
                default: 
                    return -1;
            }
        }else if (rank < 8){
            return rank - 2;
        }else if (rank > 8){
            return rank - 9;
        }
        return -1;
    }

    public boolean isEightOrJoker(){
        return ((rank == 8) || isJoker);
    } 

    public static boolean isValidRank(int rank) {
        return TWO <= rank && rank <= ACE;
    }

    public static boolean isValidSuit(int suit) {
        return DIAMONDS <= suit && suit <= SPADES;
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case ACE:
            return "Ace";
        case TWO:
            return "Two";
        case THREE:
            return "Three";
        case FOUR:
            return "Four";
        case FIVE:
            return "Five";
        case SIX:
            return "Six";
        case SEVEN:
            return "Seven";
        case EIGHT:
            return "Eight";
        case NINE:
            return "Nine";
        case TEN:
            return "Ten";
        case JACK:
            return "Jack";
        case QUEEN:
            return "Queen";
        case KING:
            return "King";
        case REDJOKER:
            return "Red Joker";
        case BLACKJOKER:
            return "Black Joker";
        default:
            //Handle an illegal argument.  There are generally two
            //ways to handle invalid arguments, throwing an exception
            //(see the section on Handling Exceptions) or return null
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case DIAMONDS:
            return "Diamonds";
        case CLUBS:
            return "Clubs";
        case HEARTS:
            return "Hearts";
        case SPADES:
            return "Spades";
        case JOKERS:
            return "Jokers";
        default:
            return null;
        }    
    }
    public String toString(){
        return rankToString(this.rank) + " of " + suitToString(this.suit);
    }
    public boolean equals(Card other){
        return (this.rank == other.rank && this.suit == other.suit);
    }
}
