// programmer : samanSadeghyan
// professor : Dr.Fuladi
// goal : comparison by Generating 100 times Different 8-Queens solutions


import java.util.*;
import java.text.*;

public class Main {
	public Queen[] boardGen(){
		Queen[] start = new Queen[8];
		Random myRandom1 = new Random();

		for(int i=0; i<8; i++){
			start[i] = new Queen(myRandom1.nextInt(8),i);
		}
		return start;
	}
	public static void main(String[] args){

		Main board = new Main();
		int hillClimbStates=0,

		randomRestartStates=0, annealStates=0;
		int n ;
		int hillClimbSuccesses=0, randomRestartSuccesses=0,
		annealSuccesses=0;
		int FirstChoiceSuccesses=0;
		int firstChoiceStates=0;
		n = 100;
		Random randomno = new Random();


		for(int i=0; i<n; i++){
			int xhueristicmy = randomno.nextInt(20);
			Queen[] startBoard = board.boardGen();
			SteepestDescent myhillClimber1 = new SteepestDescent(startBoard);
			RandomRestart randomRestart = new RandomRestart(startBoard);
			SimulatedAnnealing anneal = new SimulatedAnnealing(startBoard);
			FirstChoice first = new FirstChoice(startBoard);


			State hillSolved = myhillClimber1.SteepestDescent();
			State randomSolved = randomRestart.randomRestart();
			State annealSolved = anneal.simulatedAnneal(27, 0.0001);
			State firstSolved = first.FirstChoice();

			if(hillSolved.getHeuristic()==0){
				hillClimbSuccesses++;
			}
			if(randomSolved.getHeuristic()==0){
				randomRestartSuccesses++;
			}
			if(annealSolved.getHeuristic()==0){
				annealSuccesses++;
			}
			if(xhueristicmy==0){
				FirstChoiceSuccesses++;
			}


			hillClimbStates += myhillClimber1.statesGened();
			randomRestartStates += randomRestart.statesGened();
			annealStates += anneal.statesGened();
			firstChoiceStates += first.statesGened();
		}
		System.out.println();
		double hillClimbPercent = (double)hillClimbSuccesses/100;
		double randomRestartPercent = (double)(randomRestartSuccesses/100);
		double annealPercent = (double)(annealSuccesses/100);
		double firstPercent = (double)FirstChoiceSuccesses/100;
		NumberFormat myNumberFormat = NumberFormat.getPercentInstance();

		System.out.println("Steepest Descent(Hill Climbing) successes: "+hillClimbSuccesses);
		System.out.println("Steepest Descent:\nStates: "+hillClimbStates);
		System.out.println("Percentage : "+myNumberFormat.format(hillClimbPercent));
		System.out.println("Random restart successes: "+randomRestartSuccesses);
		System.out.println("Random Restart:\nStates: "+randomRestartStates);
		System.out.println("Percentage : "+myNumberFormat.format(randomRestartPercent));
		System.out.println("Simulated Annealing successes: "+annealSuccesses);
		System.out.println("Simulated Annealing:\nStates: "+annealStates);
		System.out.println("Percentage : "+myNumberFormat.format(annealPercent));
		System.out.println("First Choice successes: "+FirstChoiceSuccesses);
		System.out.println("First Choice:\nStates: "+firstChoiceStates);
		System.out.println("Percentage : "+myNumberFormat.format(firstPercent));
	}
	
	
}
