import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MovieFileIO {

    //gem fil til en fil
    public static void saveMoviesToFile(String fileName, List <Movie> movies) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("movies.txt"))){
            for (Movie movie: movies) {
                //skriv filmdata til filen (titel,genre og rating)
                writer.write(movie.getTitle() + ":" + movie.getGenre() + ":" + movie.getRating());
                writer.newLine(); //hver film skrives på ny linje
            }
            System.out.println("Movies have been saved to the file: "); //bekræftelse
        } catch (IOException e){
            e.printStackTrace(); //håndtering af fejl under skrivning
        }
    }

    //metode til at læse film fra filen
    public static List<Movie> loadMoviesFromFile(String filename){
        List<Movie> movies = new ArrayList<>(); //liste til at gemme filmene

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) { //læs hver linje i filen
                String[] movieData = line.split(":"); //del linjen op i film data
                if (movieData.length == 4) { //tjek om linjen indeholder de tre oplysninger
                    String title = movieData[0];
                    int year = Integer.parseInt(movieData[1]);
                    String genre = movieData[2];
                    double rating = Double.parseDouble(movieData[3]);
                    movies.add(new Movie(title, year, genre, rating)); //opretter movie objekt og tilføjer til listen
                }
            }
        }catch (IOException e){
            e.printStackTrace(); //håndtering af fejl under læsning
        }
        return movies; //returnerer listen med filmene
    }
}
