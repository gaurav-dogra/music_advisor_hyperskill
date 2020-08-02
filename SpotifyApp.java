package advisor;

import java.util.Scanner;

public class SpotifyApp {
    public static final String OPTION_TEXT =
            "\nnew" +
            "\nfeatured" +
            "\ncategories" +
            "\nplaylists Mood" +
            "\nexit" +
            "\n> ";

    public void init() {
        System.out.println(OPTION_TEXT);
        while(userInput()) {
            System.out.println(OPTION_TEXT);
        }

    }

    private boolean userInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        if(input.equals("exit")) {
            System.out.println("---GOODBYE!---");
            return false;
        }

        try {
            SpotifyPlayerAction player = SpotifyPlayerAction.create(input);
            player.act();
        } catch (SpotifyException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
