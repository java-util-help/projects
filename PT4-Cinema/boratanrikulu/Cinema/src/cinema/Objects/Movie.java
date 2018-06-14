/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Objects;

public class Movie {

	private int id;
	private String title;
	private String genre;
	private double rate;
	private String date;
	private String time;
	private String urlPoster;
	
	/* constructor */
	public Movie(int id, String title, String genre, double rate, String date, String time, String urlPoster) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.rate = rate;
		this.date = date;
		this.time = time;
		this.urlPoster = urlPoster;
	}

	/* getters */
	public int getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public double getRate() {
		return rate;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getUrlPoster() {
		return urlPoster;
	}
	
	/* toString */
	public String toString() {
		return getTitle() + getGenre() + getRate() + getDate() + getTime();
	}
}