import java.util.*;

public class FirstChoice {
    private final static int N=8;
    private Queen[] startState;
    private State start;
    private int StatesGenerated;


    public FirstChoice(){
        start = new State();
        startState = new Queen[N];
        startState();
        StatesGenerated=0;

    }

    public FirstChoice(Queen[] s){
        start = new State();
        startState = new Queen[N];
        for(int i=0; i<s.length; i++){
            startState[i] = new Queen(s[i].getRow(), s[i].getColumn());
        }
        start.setState(startState);
        start.computingHFunction();

        StatesGenerated=0;
    }

    public void startState(){

        Random gen = new Random();
        for(int i=0; i<N; i++){
            startState[i] = new Queen(gen.nextInt(N), i);
        }
        start.setState(startState);
        start.computingHFunction();

    }

    public State FirstChoice(){
        State currentState = start;

        while(true){
            ArrayList<State> successors = currentState.generateNeighbours(currentState);

            StatesGenerated+=successors.size();

            State nextState = null;
            for(int i=0; i<successors.size(); i++){


                if(successors.get(i).compareTo(currentState) <  0){
                    nextState = successors.get(i);
                }
            }
            if(nextState ==null)
                return currentState;
            currentState = nextState;
        }
    }
    public int statesGened(){
        return StatesGenerated;
    }
    public State myStartState(){
        return start;
    }

}
