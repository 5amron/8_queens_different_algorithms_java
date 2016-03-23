public class RandomRestart {
	private SteepestDescent myhillClimber1;
	private int StatesGenerated;
	private State start;

	public RandomRestart(Queen[] startBoard){
		myhillClimber1 = new SteepestDescent(startBoard);
		StatesGenerated = 0;
	}
	

	public State randomRestart(){
		State currentState = myhillClimber1.myStartState();
		myStartState1(currentState);
		int heuristic = currentState.getHeuristic();
				
		while(heuristic!=0){
			State nextState = myhillClimber1.SteepestDescent();
			StatesGenerated+=myhillClimber1.statesGened();
			heuristic = nextState.getHeuristic();
			
			if(heuristic!=0){ //restart
				myhillClimber1 = new SteepestDescent();
			}else
				currentState = nextState;
		}
		return currentState;
	}

	public void myStartState1(State n){
		start = n;
	}

	public State myStartState(){
		return start;
	}

	public int statesGened(){
		return StatesGenerated;
	}
}
