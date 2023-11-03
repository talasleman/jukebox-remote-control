package jukeboxremotecontrol.model;

import java.util.List;

public class Jukebox {
    private String id;
    private String model;
    private List<Component> components;

    // No-arg constructor
    public Jukebox() {
    }

    // All-arg constructor
    public Jukebox(String id, String model, List<Component> components) {
        this.id = id;
        this.model = model;
        this.components = components;
    }

    // Getters and setters for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and setters for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getters and setters for components
    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    // Inner Component class with getters and setters
    public static class Component {
        private String name;

        // No-arg constructor
        public Component() {
        }

        // All-arg constructor
        public Component(String name) {
            this.name = name;
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name
        public void setName(String name) {
            this.name = name;
        }
    }
}
