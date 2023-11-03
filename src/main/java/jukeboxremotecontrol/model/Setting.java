package jukeboxremotecontrol.model;

import java.util.List;

public class Setting {
    private String id;
    private List<String> requires;

    public Setting() {
    }

    public Setting(String id, List<String> requires) {
        this.id = id;
        this.requires = requires;
    }
}
