/**
 * Driver class which tests the Runway class.
 *
 */
public class RunwaySimulationDriver {

	public static void main(String[] args) {	
		/*	
		//Experiment 1: Checking your implementation A
		//int landingTime, int takeoffTime, double landingProb, double takeoffProb, int remainingFuel,  int numberOfRunways, int totalTimeToRunSimulation
		Runway.runwaySimulate(2, 3, 0.45, 0.00000001, 10, 1, 100000);
		System.out.println("---------------------" + "\n");

		//Experiment 1: Checking your implementation B
		//int landingTime, int takeoffTime, double landingProb, double takeoffProb, int remainingFuel,  int numberOfRunways, int totalTimeToRunSimulation
		Runway.runwaySimulate(2, 3, 0.00000001, 0.2, 10, 2, 100000);
		System.out.println("---------------------" + "\n");
		

		//Experiment 2: Arrival rate experiment: arrival rate varies and all other values constant
		//int landingTime, int takeoffTime, double landingProb, double takeoffProb, int remainingFuel,  int numberOfRunways, int totalTimeToRunSimulation
		Runway.runwaySimulate(2, 3, 0.45, 0.2, 10, 1, 100000);
 
		//Experiment 3: Departure rate experiment: departure rate varies and all other values constant
		//int landingTime, int takeoffTime, double landingProb, double takeoffProb, int remainingFuel,  int numberOfRunways, int totalTimeToRunSimulation
		Runway.runwaySimulate(2, 3, 0.35, 0.00000200, 10, 1, 100000);
		*/

		//Experiment 4: Number of runways experiment - what happens to the number of planes taking off and the number of planes departing when there are two runways
		Runway.runwaySimulate(2, 3, 0.35, 0.00000200, 10, 2, 100000);
		System.out.println("---------------------" + "\n");
	}

}
