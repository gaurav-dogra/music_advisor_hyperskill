package advisor;

public abstract class SpotifyPlayerAction {

    public static SpotifyPlayerAction create(String input) {
        switch (input) {
            case "new":
                return new FetchNewReleases();
            case "featured":
                return new FetchFeatured();
            case "categories":
                return new FetchCategories();
            case "playlists mood":
                return new FetchMoodPlaylist();
            case "auth":
                return new Auth();
            default:
                throw new SpotifyException();
        }
    }

    public abstract void act();

}
