/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Objects;

public class Theatre {

	private int seatNumber;
	private Seat[] seats;
	
	/* constructor */
	public Theatre(int seatNumber) {
		this.seatNumber = seatNumber;
		setSeats();
	}
	
	/* setter */
	public void setSeats() {
		seats = new Seat[seatNumber];
		for(int counter = 0; counter < seatNumber; counter++) {
			seats[counter] = new Seat(counter);
		}
	}
	
	/* getter */ 
	public Seat getSeat(int counter) {
		return seats[counter];
	}
}