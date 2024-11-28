public class Movie {
    private String title;
    private int year;
    private String genre;
    private double rating;

    //kontruktør
    public Movie(String title, int year, String genre, double rating) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    //gettere
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }


    @Override
    public String toString() {
        return title + "(" + year + ", " + genre + ", " + rating + ")";
    }

    //viser filmens info
    public void showInfo() {
        System.out.println("Title:" + title);
        System.out.println("Genre:" + genre);
        System.out.println("Rating:" + rating);
        System.out.println("Year: " + year);
    }
    //display en besked til brugeren at filmen kører

    public void play() {
        System.out.println(title + " is now playing");

    }
}