package jukeboxremotecontrol.model;

import java.util.List;

/**
 * Represents a Jukebox entity with an ID, model, and a list of components.
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    /**
     * Inner class representing a Component of a Jukebox.
     */
    public static class Component {
        private String name;

        public Component() {
        }

        public Component(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
