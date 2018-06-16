/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Objects;

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
	
	/* isIts */
	public boolean isVacant() {
		return status.equals(Status.VACANT);
	}
	public boolean isTaken() {
		return status.equals(Status.TAKEN);
	}
	public boolean isSelected() {
		return status.equals(Status.SELECTED);
	}
	
	/* setters */
	public void setStatusVacant() {
		this.status = Status.VACANT;
	}
	public void setStatusTaken() {
		this.status = Status.TAKEN;
	}
	public void setStatusSeleted() {
		this.status = Status.SELECTED;
	}

	/* getter */
	public Status getStatus() {
		return status;
	}
}