/**
 * This is a subclass of the SalesItem class
 */
public class AudioCD extends SalesItem {

	//instance variables
	private String label;
	private int playingTime;
	private final double MONTHLYPROMO = 0.05;

	/**
	 * Constructor
	 * @param - label cd label
	 * @param - playingTime audio length
	 * @param - code unique item identifier
	 * @param - quantity count of each
	 * @param - price cost per item
	 */
	public AudioCD(String label, int playingTime, int code, int quantity, double price) {
		super(code, quantity, price);
		this.label = label;
		this.playingTime = playingTime;
	}

	/**
	 * This method returns an AudioCD label
	 * @return label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * This method sets a new label
	 * @param - label on an AudioCD
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * This method returns audio playing time
	 * @return playingTime
	 */
	public int getPlayingTime() {
		return playingTime;
	}

	/**
	 * This method sets the playing time for an AudioCD
	 * @param - playingTime audio length
	 */
	public void setPlayingTime(int playingTime) {
		this.playingTime = playingTime;
	}

	/**
	 * This method applies a 5% reduction to a price of a cd
	 */
	@Override
	public void monthlyPromo() {
		setPrice(getPrice() - (getPrice() * MONTHLYPROMO));
	}

	public double getMONTHLYPROMO() {
		return MONTHLYPROMO;
	}

	/**
	 * This method adds the AudioCD's specific instance variables to the output string
	 * and displays the properties of Book into a nicely formatted String
	 */
	@Override
	public String toString() {
		return super.toString() + String.format("%31s", label) + "\t"
				+ String.format("%1s", playingTime);
	}
}
