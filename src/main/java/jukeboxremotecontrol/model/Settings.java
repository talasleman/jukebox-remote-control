package jukeboxremotecontrol.model;

import java.util.List;

public class Settings {

    private List<Setting> settings;

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public static class Setting {
        private String id;
        private List<String> requires;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getRequires() {
            return requires;
        }

        public void setRequires(List<String> requires) {
            this.requires = requires;
        }
    }
}
