package advisor;

public class Auth extends SpotifyPlayerAction {
    @Override
    public void act() {
        System.out.print("https://accounts.spotify.com/authorize?client_id=4a6790355b57464dadabd7a7285e6d0f&redirect_uri=http://localhost:8080&response_type=code\n" +
                "---SUCCESS---\n");
    }
}
