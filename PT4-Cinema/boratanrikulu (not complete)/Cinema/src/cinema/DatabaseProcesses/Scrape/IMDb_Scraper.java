/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.DatabaseProcesses.Scrape;

import cinema.Objects.Movie;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IMDb_Scraper {
	
	private Document document;
	private Movie movie;
	private ArrayList<Movie> movies;
	private String title;
	private String genre;
	private String duration;
	private double rating;
	private String director;
	private String actors;
	private String date;
	private String urlPoster;
	private String summary;
	private String[] fourDays;
	
	public IMDb_Scraper() {
		try {
			document = Jsoup.connect("https://www.imdb.com/movies-in-theaters/").get();	
			this.movies = new ArrayList<Movie>();
			setFourDays();
			scrape();
		} catch (IOException ex) {
			Logger.getLogger(IMDb_Scraper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/* setter */
	public void setMovie() {
		movie = new Movie(title, genre, duration, rating, director, actors, date, urlPoster, summary);
		
		movies.add(movie);
	}
	
	/* getter */
	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void scrape() {
		clearMovies();
		Elements rows = document.select("div.list.detail.sub-list");

		for(Element element : rows) { // takes the top ten list from the In Theaters page
			if(element.select("h3").text().equals("In Theaters Now - Box Office Top Ten")){
				rows = element.select("div.list_item");
			}
		}

		for(String date : fourDays) {
			for (Element row : rows) { // scrapes informations, creates movie objects, add the objects to an array list
				setTitle(row);
				setGenre(row);
				setDuration(row);
				setRating(row);
				setDirector(row);
				setActors(row);
				setDate(date);
				setUrlPoster(row);
				setSummary(row);

				setMovie();
			}
		}
	}

	/* scrape methods */
	private void setTitle(Element row) {
		title = row.select("h4").text();
	}
	
	private void setGenre(Element row) {
		Elements genres = row.select("p.cert-runtime-genre span[itemprop = genre]");
		if(genres.size() >= 2)
			genre = genres.get(0).text() + ", " + genres.get(1).text();
		else if(genres.size() == 1)
			genre = genres.get(0).text();
		else
			genre = "";
	}
	
	private void setDuration(Element row) {
		duration = row.select("p.cert-runtime-genre time[itemprop = duration]").text();
	}
	
	private void setRating(Element row) {
		rating = Double.valueOf(row.select("div.rating_txt span.value").text());
	}
	
	private void setDirector(Element row) {
		this.director = row.select("div.txt-block span[itemprop = director]").text();
	}
	
	private void setActors(Element row) {
		Elements actors = row.select("div.txt-block span[itemprop = actors]");
		if(actors.size() >= 3)
			this.actors = actors.get(0).text() + ", " + actors.get(1).text() + ", " + actors.get(2).text();
		else if(actors.size() == 2)
			this.actors = actors.get(0).text() + ", " + actors.get(1).text();
		else if(actors.size() == 1)
			this.actors = actors.get(0).text();
		else
			this.actors = "";
	}
	
	private void setUrlPoster(Element row) {
		urlPoster = row.select("img.poster.shadowed").attr("src");
	}
	
	private void setDate(String date) {
		this.date = date.format(date);
	}
	
	private void setSummary(Element row) {
		summary = row.select("div.outline").text();
	}
	
	private void setFourDays() {
		fourDays = new String[4];
		
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
		fourDays[0] = date.format(localDate);
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		fourDays[1] = date.format(localDate);
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		fourDays[2] = date.format(localDate);
		
		localDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth()+1);
		fourDays[3] = date.format(localDate);
	}
	
	public void clearMovies() {
		if(!movies.isEmpty())
			movies.clear();
	}
}