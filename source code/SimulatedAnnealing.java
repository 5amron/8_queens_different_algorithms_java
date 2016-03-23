import java.util.*;

public class SimulatedAnnealing {
	private final static int N=8;
	int StatesGenerated;
	private Queen[] startState;
	private State start;
	

	public SimulatedAnnealing(Queen[] s){
		StatesGenerated = 0;
		start = new State();
		startState = new Queen[N];
		
		for(int i=0; i<N; i++){
			startState[i] = new Queen(s[i].getRow(), s[i].getColumn());
		}
		start.setState(startState);
		start.computingHFunction();
	}

	public void startState(){
		start = new State();
		startState = new Queen[N];
		Random gen = new Random();
		
		for(int i=0; i<N; i++){
			startState[i] = new Queen(gen.nextInt(N), i);
		}
		start.setState(startState);
		start.computingHFunction();
	}
	

	public State simulatedAnneal(double iniT, double step){
		State currentState = start;
		double temperature = iniT;
		double val = step;
		double myProbability;
		int delta;
		double determine;
		
		State nextState = new State();
		
		while(currentState.getHeuristic()!=0 && temperature > 0){

			nextState = currentState.getRandomNeighbour(currentState);
			StatesGenerated++;
			
			if(nextState.getHeuristic()==0)
				return nextState;
			
			delta = currentState.getHeuristic() - nextState.getHeuristic();
			
			if(delta > 0){
				currentState = nextState;
			}else{ 
				myProbability = Math.exp(delta/temperature);

				determine = Math.random();
				
				if(determine <= myProbability){
					currentState = nextState;
				}
			}
			temperature = temperature - val;
		}
		
		return currentState;
	}
	public State myStartState(){
		return start;
	}
	public int statesGened(){
		return StatesGenerated;
	}

	
}
