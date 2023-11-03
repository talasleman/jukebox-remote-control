package jukeboxremotecontrol.model;

import java.util.List;

public class Jukebox {
    private String id;
    private String model;
    private List<Component> components;

    public Jukebox() {
    }

    public Jukebox(String id, String model, List<Component> components) {
        this.id = id;
        this.model = model;
        this.components = components;
    }

    public static class Component {
        private String name;

        public Component() {
        }

        public Component(String name) {
            this.name = name;
        }
    }

}
