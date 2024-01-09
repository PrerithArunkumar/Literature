
import java.util.ArrayList;
public class Game {
    private Player[] players;
    private Deck gameDeck;
    private ArrayList<HistoryObject> history;
    private Player[] firstTeam;
    private Player[] secondTeam;
    private int firstTeamPoints;
    private int secondTeamPoints;
    //What each set contains
    public final Card[][] allSets = new Card[9][6];
    Game(){
        //declaring all sets
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 6; j++){
                allSets[i][j] = new Card((j+2) + (i%2)*7, (i/2 + 1));
            }
        }
        for (int i = 0; i < 4; i++){
            allSets[8][i] = new Card(8, i+1);
        }
        allSets[8][4] = new Card(0, 0);
        allSets[8][4] = new Card(1, 0);
        //creating player array and teams
        players = new Player[6];
        players[0] = new Player1();
        players[1] = new Player2();
        players[2] = new Player3();
        firstTeam = new Player[3];
        firstTeam[0] = players[0];
        firstTeam[1] = players[1];
        firstTeam[2] = players[2];
        players[3] = new Player4();
        players[4] = new Player5();
        players[5] = new Player6();
        secondTeam = new Player[3];
        secondTeam[0] = players[3];
        secondTeam[1] = players[4];
        secondTeam[2] = players[5];
        // creating game deck
        gameDeck = new Deck();
        gameDeck.shuffle();
        //initializing history
        history = new ArrayList<>();
        //dealing
        for (int i = 0; i < 54; i++){
            players[i%6].fillHand(gameDeck.deal());
        }
        //initializing points
        firstTeamPoints = 0;
        secondTeamPoints = 0;
    }
    public String runGame(){
        players[(int) Math.random()*6].start();
        return "Results- Team 1: " + firstTeamPoints + " Team 2: " + secondTeamPoints;
    }
    public void ask(Question question){
        question.getPlayerAnswering().respond(question);
    }
    public void update(QuestionAnswered questionAnswered){
        history.add(questionAnswered);
        if (questionAnswered.isSuccess()){
            questionAnswered.getPlayer().fillHand(questionAnswered.getPlayerAnswering().popCard(questionAnswered.getCardRequesting()));
            questionAnswered.getPlayer().turn(history);
        }else{
            questionAnswered.getPlayerAnswering().turn(history);
        }
    }
    public void callSet(Set set){
        if (set.getFirstCard().hasCard(allSets[set.getSet()][0]) && 
        set.getSecondCard().hasCard(allSets[set.getSet()][1]) &&
        set.getThirdCard().hasCard(allSets[set.getSet()][2]) &&
        set.getFourthCard().hasCard(allSets[set.getSet()][3]) &&
        set.getFifthCard().hasCard(allSets[set.getSet()][4]) &&
        set.getSixthCard().hasCard(allSets[set.getSet()][5])){
            updateSet(new SetAnswered(set, true));
        }else{
            updateSet(new SetAnswered(set, false));
        }
    }
    public void updateSet(SetAnswered setAnswered){
        history.add(setAnswered);
        if (setAnswered.isSuccess()){
            if (firstTeam[0] == setAnswered.getPlayer() || firstTeam[1] == setAnswered.getPlayer() || firstTeam[2] == setAnswered.getPlayer()){
                firstTeamPoints++;
                //end game
                if (firstTeamPoints > 4){
                    System.out.println("Team 1 wins!");
                }else{
                    setAnswered.getPlayer().turn(history);
                }
            }else{
                secondTeamPoints++;
                //end game
                if (secondTeamPoints > 4){
                    System.out.println("Team 2 wins!");
                }else{
                    setAnswered.getPlayer().turn(history);
                }
            }
        }else{
            if (firstTeam[0] == setAnswered.getPlayer() || firstTeam[1] == setAnswered.getPlayer() || firstTeam[2] == setAnswered.getPlayer()){
                secondTeamPoints++;
                //end game
                if (secondTeamPoints > 4){
                    System.out.println("Team 2 wins!");
                }else{
                    setAnswered.getPlayer().turn(history);
                }
            }else{
                firstTeamPoints++;
                //end game
                if (firstTeamPoints > 4){
                    System.out.println("Team 1 wins!");
                }else{
                    setAnswered.getPlayer().turn(history);
                }
            }
        }
    }
    //TESTING ONLY
    public String toString(){
        String result = "";
        for (int i = 0; i < 6; i++){
            result += players[i];
        }
        return result;
    }
}
