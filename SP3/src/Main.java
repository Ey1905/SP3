import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //En scanner til alt input

        //Bruger 1
        String user1 = "Nadine123";
        String pass1 = "password123";

        //Bruger 2
        String user2 = "Ebru1905";
        String pass2 = "password1905";

        //Indtaste brugernavn
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        User currentUser = null; //Beholder brugeren efter login

        if (username.equals(user1)) {
            //Tjekker om det matcher en af de gemte brugere (user1/user2)
            //Login for Nadine
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            if (password.equals(pass1)) {
                System.out.println("Welcome back, Nadine :)");
                currentUser = new User(user1, pass1);
            } else {
                System.out.println("Invalid password ");
            }
        } else if (username.equals(user2)) {
            //Tjekker om det matcher en ad de gemte brugere (user1/user2)
            //Login for Ebru
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            if (password.equals(pass2)) {
                System.out.println("Welcome back, Ebru :)");
                currentUser = new User(user2, pass2);
            } else {
                System.out.println("Invalid password ");
            }
        } else {
            System.out.println("User not found");
        }


        if (currentUser != null) {
            //Tilføjer film
            Movie movie1 = new Movie("The Godfather", 1972, "Crime, Drama", 9.2);
            Movie movie2 = new Movie("The Shawshank Redemption", 1994, "Drama", 9.3);
            Movie movie3 = new Movie("Schindler's List", 1993, "Biography, Drama, History", 8.9);
            Movie movie4 = new Movie("Raging Bull", 1980, "Biography, Drama, Sport", 8.2);
            Movie movie5 = new Movie("Casablanca", 1942, "Drama, Romance, War", 8.5);

            currentUser.addToWatchList(movie1);
            currentUser.addToWatchList(movie2);
            currentUser.addToWatchList(movie3);
            currentUser.addToWatchList(movie4);
            currentUser.addToWatchList(movie5);

            //Efter login kommer man ind til menuen, med forskellige muligheder
            //brugt while-loop fordi menuen skal blive ved med at køre indtil brugeren afslutter (punkt 4.)
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("What would you like to do?");
                System.out.println("1. View WatchList");
                System.out.println("2. Play a Movie");
                System.out.println("3. View WatchHistory");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        currentUser.displayWatchList();
                        break;
                    case 2:
                        System.out.println("Enter the title of the movie to play:");
                        String movieTitle = scanner.nextLine();
                        Movie selectedMovie = null;

                        //For at finde film i WatchList
                        for (Movie movie : currentUser.getWatchList()) {
                            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                                selectedMovie = movie;
                                break;
                            }
                        }

                        if (selectedMovie != null) {
                            currentUser.playMovie(selectedMovie);
                        } else {
                            System.out.println("Movie not found in your WatchList");
                        }
                        break;
                    case 3:
                        currentUser.displayWatchHistory();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again");
                }
            }
        }
    }
}
