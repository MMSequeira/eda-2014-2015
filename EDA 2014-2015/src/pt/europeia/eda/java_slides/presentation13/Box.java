package pt.europeia.eda.java_slides.presentation13;

public class Box {

    private final Position topLeftCornerPosition;
    private final Size size;

    public Box(final Position topLeftCornerPosition, final Size size) {
        this.topLeftCornerPosition = topLeftCornerPosition;
        this.size = size;
    }

    public final Position getTopLeftCornerPosition() {
        return topLeftCornerPosition;
    }

    public final Size getSize() {
        return size;
    }

    // …

}
