package common.features.comapreinterface;

import java.util.Comparator;

public class YearComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return Integer.compare(o1.releaseYear, o2.releaseYear);
    }
}
