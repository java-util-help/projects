/**
 * @author boratanrikulu
 * If you have any question about the project, you can contact me at http://boratanrikulu.me/contact
 */

package cinema.DatabaseProcesses.Scrape;

import cinema.DatabaseProcesses.DatabaseConnector;
import cinema.Objects.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateDB {
	
	private Connection connection;
	private ArrayList<Movie> movies;
	private PreparedStatement preparedStatement;

	public UpdateDB(/*Connection connection*/) {
		this.connection = new DatabaseConnector().getConnection();
		this.movies = new IMDb_Scraper().getMovies();
	}
	
	public static void main(String[] args) {
		UpdateDB updateDB = new UpdateDB(/*connection*/);
		updateDB.updateDataBase();
	}
	
	public void updateDataBase() {
		String query = "INSERT INTO movies(title, genre, duration, rating, director, actors, date, time, urlPoster, summary)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		
		for(Movie movie : movies) {
			String[] times = {"10:00", "13:00", "16:00", "21:00"};
			for(String time : times) {
				try {
					preparedStatement = connection.prepareStatement(query);

					preparedStatement.setString(1, movie.getTitle());
					preparedStatement.setString(2, movie.getGenre());
					preparedStatement.setString(3, movie.getDuration());
					preparedStatement.setDouble(4, movie.getRating());
					preparedStatement.setString(5, movie.getDirector());
					preparedStatement.setString(6, movie.getActors());
					preparedStatement.setString(7, movie.getDate());
					preparedStatement.setString(8, time);
					preparedStatement.setString(9, movie.getUrlPoster());
					preparedStatement.setString(10, movie.getSummary());
					
					preparedStatement.executeUpdate();
				} catch (SQLException ex) {
					Logger.getLogger(UpdateDB.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
}