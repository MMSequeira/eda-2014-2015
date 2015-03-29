package pt.europeia.eda.javaslides.presentation11;

public enum CardinalDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String prettyName() {
        return name().charAt(0) + name().substring(1).toLowerCase();      
    }
}
