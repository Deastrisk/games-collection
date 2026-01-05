import java.util.Map;

public class Game {
    private final SettingsData settings = new SettingsData();

    public Map<PageTypes, Page> pages = Map.ofEntries(
        Map.entry(PageTypes.TITLE_SCREEN, TitleScreen()),
        Map.entry(PageTypes.PLAY, Play(settings)),
        Map.entry(PageTypes.SETTINGS, Settings(settings))
    );

    public Game() {
        
    }
}
