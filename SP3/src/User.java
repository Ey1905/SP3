import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Movie> watchList;
    private ArrayList<Movie> watchHistory;

    public User(String name, String password) {
        this.username = name;
        this.password = password;
        this.watchList = new ArrayList<>(); //starter en tom watchlist
        this.watchHistory = new ArrayList<>(); //starter en tom watch history
    }

    //getter-setter metode
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Movie> getWatchList() {
        return watchList;
    }

    public ArrayList<Movie> getWatchHistory() {
        return watchHistory;
    }

    //setter metoder
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //For at tilføje film til WatchList
    public void addToWatchList(Movie movie) {
        //if sætningen kontrolere om filmen alleree findes i listen, så den ikke bliver gentaget
        if (!watchList.contains(movie)) {
            watchList.add(movie); //Filmen bliver tilføjet
            //Printer besked til brugeren
        }
    }


    public void addToWatchHistory(Movie movie) {
        watchHistory.add(movie); //tilføjer filmobjekt til watch history
    }


    //Kode for at vise de film der ligger under WatchList
    public void displayWatchList(){
        if (watchList.isEmpty()) { //Bruges for at se om listen er tom
            System.out.println("Your WatchList is empty:"); //Besked til brugeren
        } else {
            System.out.println("Your WatchList:"); //Besked til brugeren
            for (Movie movie : watchList) { //Skal gå igennem den liste med alle film
                System.out.println("- " + movie.getTitle() + " (" + movie.getGenre() + ")");

            }
        }
    }


    //Afspiller en film og tilføjer til watchHistory
    public void playMovie(Movie movie) {
        System.out.println("Now playing " + movie.getTitle() + "..."); //Besked til brugeren
        if (!watchHistory.contains(movie)) {
            watchHistory.add(movie); //Filmen tilføjes til historien
        }
    }


    //Kode for at vise de film der ligger under WatchHistory
    public void displayWatchHistory() {
        if (watchHistory.isEmpty()) { //Bruges for at se om listen er tom
            System.out.println("Your WatchHistory is empty "); //Besked til brugeren
        } else {
            System.out.println("Your WatchHistory: "); //Besked til brugeren
            for (Movie movie : watchHistory) { //Skal gå igennem den liste med alle film
                System.out.println("- " + movie.getTitle() + " (" + movie.getGenre() + ")");
            }
        }
    }


    @Override
    public String toString() {
        return "Username: " + username + ", WatchList: " + watchList + ", watchHistory: " + watchHistory;
    }
}

