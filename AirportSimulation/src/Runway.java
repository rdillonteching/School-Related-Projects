/** 
 * This assignment simulates a small airport operating one runway.
 * A second runway is open when traffic increases beyond what the one runway can handle.
 *
 */
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

public class Runway {

	private int minutesForLanding; //minutes it takes for a plane to land
	private int minutesForTakeoff; //minutes it takes for a plane to takeoff
	private int serviceTimeLeft = 0; //how much time it takes to service a landing or departing plane

	/**
	 * The constructor initializes default airport vars
	 * @param -- landing - time a plane takes to land
	 * @param -- departure - time a plane takes to takeoff
	 */
	public Runway(int landing, int departure) { //Constructor which handles initializing the 
		//minutes landing/takeoff instance variables
		minutesForLanding = landing;
		minutesForTakeoff = departure;
	}

	/**
	 * This method determines if the runway is occupied by a plane 
	 * @return serviceTimeLeft - time left to complete a plane being serviced 
	 */
	public boolean isBusy()	{ //boolean method which finds out if the airport is busy or not
		return (serviceTimeLeft > 0);
	}

	/**
	 * This method reduces the remaining time in the current cylce by 1 minute
	 */
	public void reduceRemainingTime()	{
		if (serviceTimeLeft > 0)
			serviceTimeLeft--;
	}

	/**
	 * This method takes an input parameter to specify whether the 
	 * service is landing or taking off. Assume landing is type 1 and takeoff is type 0.
	 * @param -- serviceType - is represented as 1 for landing and 0 for takeoff.
	 */
	public void startService(int serviceType)	{
		if (serviceTimeLeft > 0) {	
			throw new IllegalStateException("Runways is already busy");
		}
		if (serviceType == 1) {
			this.serviceTimeLeft = minutesForLanding;
		}else if (serviceType == 0) {
			this.serviceTimeLeft = minutesForTakeoff;
		}		
	}

	/**
	 * This method simulates the runway
	 * @param -- landingTime - time it takes to land
	 * @param -- takeoffTime - time it takes to takeoff
	 * @param -- landingProb - probability of a plane arriving within a minute
	 * @param -- takeoffProb - probability of a plane departing within a minute
	 * @param -- remainingFuel - the fuel in a plane after each minute goes by
	 * @param -- numberOfRunways - total number of runways
	 * @param -- totalTimeToRunSimulation - total time to run the runway simulation
	 */
	public static void runwaySimulate(int landingTime, int takeoffTime, double landingProb, 
			double takeoffProb, int remainingFuel,  int numberOfRunways, int totalTimeToRunSimulation)	{
		
		DecimalFormat dc = dcFormat();
		
		//two queues for landing and taking off planes
		Queue<Integer> arrivalTimes = new LinkedList<Integer>();
		Queue<Integer> departureTimes = new LinkedList<Integer>();

		int next;
		int crashed = 0;

		//simulates the arrival of landing planes and the "arrival" of planes taking off
		BooleanSource arrival = new BooleanSource (landingProb);
		BooleanSource departure = new BooleanSource (takeoffProb);

		//calculate the average wait time for landing and average wait time for taking off.
		Averager avgWaitTimeForLanding = new Averager();
		Averager avgWaitTimeForDeparture = new Averager();

		int currentMinute;

		/*Invariant of the Array:
		1. The number of items in the array is stored in the instance variable numberOfRunways.
		2. for a non-empty array, the items are stored in at the beginning from data[0] and continuing through data[numberOfRunways-1].
		3. For an empty queue, numberOfRunways is zero and allRunways is a reference to an array.
		 */
		//creates runway collection using an array
		Runway[] allRunways = new Runway[numberOfRunways];
		for (int i = 0; i < allRunways.length; i++) {
			allRunways[i] = new Runway(landingTime,takeoffTime);
		}

		System.out.println ("Landing Time: " + landingTime + " mins");
		System.out.println ("Departure Time: " + takeoffTime + " mins");
		System.out.print("Arrival probability: ");
		System.out.println(landingProb);
		System.out.print("Departure probability: ");
		System.out.println(takeoffProb);
		System.out.println("Total simulation minutes: " + totalTimeToRunSimulation);
		System.out.println("============================");

		if (landingTime <= 0 || landingProb < 0 || landingProb > 1 || takeoffTime <= 0 || takeoffProb < 0 || takeoffProb > 1 || totalTimeToRunSimulation < 0)	
			System.out.println("Values out of range");
		for (currentMinute = 0; currentMinute < totalTimeToRunSimulation; currentMinute++)	{
			//Check whether a plane arrived or is taking off
			if (arrival.query()) {
				arrivalTimes.add(currentMinute); //add the time a plane joins the queue
			}
			if (departure.query()) {
				departureTimes.add(currentMinute); //add the time a plane departs the queue
			}
			//Checks if the runway is clear -- plan landing has a priority to use the airport
			for (int i = 0; i < allRunways.length; i++) {
				while ((!allRunways[i].isBusy()) && (!arrivalTimes.isEmpty()))	{
					next = arrivalTimes.remove(); //remove plane from arrival queue - time they arrived
					int waitTime = currentMinute - next; //how long waited
					if (waitTime > remainingFuel) {
						crashed++; //if here we've crashed
					}else {
						avgWaitTimeForLanding.addNumber(waitTime); 
						allRunways[i].startService(1); //starts the arrival service
					}
				}
				//Check if the runway is clear -- all planes have landed or crashed so departure planes can take off
				if ((!allRunways[i].isBusy()) && (!departureTimes.isEmpty())) {
					next = departureTimes.remove();
					int waitTime = currentMinute - next; //how long waited
					avgWaitTimeForDeparture.addNumber(waitTime);
					allRunways[i].startService(0); //starts the departure service when the runway isn't busy and departure queue is not empty
				}
				allRunways[i].reduceRemainingTime(); //reduces remaining time by each minute that goes by
			}
		}

		//Displays summary information about the simulation
		System.out.println("Number of planes that landed during the simulation: " + avgWaitTimeForLanding.howManyNumbers());
		System.out.println("Number of planes that took off during the simulation: " + avgWaitTimeForDeparture.howManyNumbers());
		if (avgWaitTimeForLanding.howManyNumbers() > 0 || avgWaitTimeForDeparture.howManyNumbers() > 0) {
			System.out.println("Average time a plane spent in the landing queue: " + (avgWaitTimeForLanding.howManyNumbers() == 0 ? 0 + " mins" : dc.format(avgWaitTimeForLanding.average()) +  " mins"));
			System.out.println("Average time a plane spent in the takeoff queue: " + (avgWaitTimeForDeparture.howManyNumbers() == 0 ? 0 + " mins" : dc.format(avgWaitTimeForDeparture.average())  + " mins"));
			System.out.println("Number of planes that crashed because they ran out of fuel before they could land: " + crashed);
		}
	}
	
	/**
	 * Method formats average landing and take off times
	 * @return dc
	 */
	private static DecimalFormat dcFormat() {
		String pattern = "###,###.00";
		DecimalFormat dc = new DecimalFormat(pattern);
		return dc;
	}
}
