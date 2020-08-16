package advisor;

public class FetchCategories extends SpotifyPlayerAction {
    @Override
    public void act() {
        System.out.println("---CATEGORIES---");
        System.out.println("Top Lists\n" +
                "Pop\n" +
                "Mood\n" +
                "Latin");
    }
}
