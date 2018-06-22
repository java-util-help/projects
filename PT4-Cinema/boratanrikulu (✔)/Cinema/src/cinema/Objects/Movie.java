/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.Objects;

public class Movie {

	private int id;
	private String title;
	private String genre;
	private String duration;
	private double rating;
	private String director;
	private String actors;
	private String date;
	private String time;
	private String urlPoster;
	private String summary;
	
	/* constructors */
	public Movie(int id, String title, String genre, String duration, double rating, String director, String actors, String date, String time, String urlPoster, String summary) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.director = director;
		this.actors = actors;
		this.date = date;
		this.time = time;
		this.urlPoster = urlPoster;
		this.summary = summary;
	}
	public Movie(String title, String genre, String duration, double rating, String director, String actors, String date, String urlPoster, String summary) {
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.director = director;
		this.actors = actors;
		this.date = date;
		this.urlPoster = urlPoster;
		this.summary = summary;
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
	public String getDuration() {
		return duration;
	}
	public double getRating() {
		return rating;
	}
	public String getDirector() {
		return director;
	}
	public String getActors() {
		return actors;
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
	public String getSummary() {
		return summary;
	}
	
	/* toString */
	public String toString() {
		return getTitle() + getGenre() + getRating() + getDirector() + getActors();
	}
}