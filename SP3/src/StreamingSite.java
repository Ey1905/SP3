import java.util.ArrayList;

public class StreamingSite {
    private String titleName;
    private ArrayList<User> users;
    private ArrayList<Movie> movies;

    //konstruktør
    public StreamingSite(String titleName, ArrayList<User> users, ArrayList<Movie> movies) {
        this.titleName = titleName;
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    //Tilføj bruger
    public void addUser(User user){
        users.add(user);
    }

    //tilføj film
    public void addMovie(Movie movie){
        movies.add(movie);
    }

    //fjerner film fra user watchlist
    public void removeMovie(Movie movie){
        movies.remove(movie);
    }

    public void searchAndShowMovieByTitle(String title){
        for(Movie movie : movies){
            if(movie.getTitle().equalsIgnoreCase(title)){
                movie.showInfo();
                return;
            }
        }
        System.out.println("Movie with title '" + title + "'not found. ");
    }
}
