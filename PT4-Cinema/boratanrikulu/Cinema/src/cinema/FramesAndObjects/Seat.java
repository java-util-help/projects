/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.FramesAndObjects;

public class Seat {

	enum Status {
		VACANT(),
		TAKEN(),
		SELECTED();
	}
	public Status status;

	/* constructor */
	public Seat() {
		this.status = Status.VACANT;
	}
	
	/* setter */
	public void setStatus(Status status) {
		this.status = status;
	}

	/* getter */
	public Status getStatus() {
		return status;
	}
}