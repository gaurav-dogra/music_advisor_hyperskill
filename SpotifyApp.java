package advisor;

import java.util.Scanner;


public class SpotifyApp {
    private boolean auth = false;
    private Scanner scanner = new Scanner(System.in);

    public static final String OPTION_TEXT =
            "\nnew" +
                    "\nfeatured" +
                    "\ncategories" +
                    "\nplaylists Mood" +
                    "\nauth" +
                    "\nexit";

    public void init() {
//        System.out.println(OPTION_TEXT);
        while (userInput()) {
//            System.out.println(OPTION_TEXT);
        }

    }

    private boolean userInput() {

        String input = scanner.next().trim();

        if (input.equals("auth")) {
            auth = true;
        }

//        if (input.equals("exit") && !auth) {
//            printNonAuthMessage();
//            return false;
//        }

        if (input.equals("exit")) {
            System.out.println("---GOODBYE!---");
            return false;
        }


        try {
            SpotifyPlayerAction player = SpotifyPlayerAction.create(input);
            if (auth) {
                player.act();
            } else {
                printNonAuthMessage();
            }
        } catch (SpotifyException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void printNonAuthMessage() {
        System.out.println("Please, provide access for application.");
    }
}
