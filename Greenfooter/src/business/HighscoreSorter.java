package business;

import domain.HighscoreItem;
import java.util.Comparator;

public class HighscoreSorter implements Comparator<HighscoreItem> {

    @Override
    public int compare(HighscoreItem t, HighscoreItem t1) {
        if (t.getScore() > t1.getScore()) {
            return -1;
        }

        if (t.getScore() < t1.getScore()) {
            return 1;
        }

        return 0;
    }
}
