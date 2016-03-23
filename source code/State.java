
import java.util.*;

public class State implements Comparable<State> {
	private static final int N=8;
	public Queen[] state;
	private ArrayList<State> neighbours;
	private int hn;


	public State(){
		state = new Queen[N];
		neighbours = new ArrayList<State>();
	}


	public State(State n){
		state = new Queen[N];
		neighbours = new ArrayList<State>();
		for(int i=0; i<N; i++)
			state[i] = new Queen(n.state[i].getRow(), n.state[i].getColumn());
		hn=0;
	}


	public ArrayList<State> generateNeighbours(State startState){
		int count=0;

		if(startState==null)
			System.out.println("warning");
		else{
			//System.out.println("hellooo!!!");
		}

		for(int i=0; i<N; i++){
			for(int j=1; j<N; j++){
				neighbours.add(count, new State(startState));
				neighbours.get(count).state[i].moveDown(j);
				neighbours.get(count).computingHFunction();

				count++;
			}
		}

		return neighbours;
	}

	public State getRandomNeighbour(State startState){
		Random gen = new Random();

		int col = gen.nextInt(N);
		int d = gen.nextInt(N-1)+1;

		State neighbour = new State(startState);
		neighbour.state[col].moveDown(d);
		neighbour.computingHFunction();

		return neighbour;
	}


	public int computingHFunction(){

		for(int i=0; i<N-1; i++){
			for(int j=i+1; j<N; j++){
				if(state[i].mythreat(state[j])){
					hn++;
				}
			}
		}

		return hn;
	}




	public int getHeuristic(){

		return hn;
	}

	public int compareTo(State n){
		if(this.hn < n.getHeuristic())
			return -1;
		else if(this.hn > n.getHeuristic())
			return 1;
		else
			return 0;
	}

	public void setState(Queen[] s){
		for(int i=0; i<N; i++){
			state[i]= new Queen(s[i].getRow(), s[i].getColumn());
		}
	}



	public Queen[] getState(){
		return state;
	}


	public String toString(){
		String result="";
		String[][] board = new String[N][N];


		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				board[i][j]="X ";


		for(int i=0; i<N; i++){
			board[state[i].getRow()][state[i].getColumn()]="Q ";
		}


		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				result+=board[i][j];
			}
			result+="\n";
		}

		return result;
	}
}
