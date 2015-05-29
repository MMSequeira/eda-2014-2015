package pt.europeia.eda.piazza.week13;

public interface Sort<Item extends Comparable<? super Item>> {
    void sort(final Item[] values);
}
