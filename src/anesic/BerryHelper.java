package anesic;

import java.util.Comparator;
import java.util.List;

public class BerryHelper {
    private List<Berry> berries;

    public BerryHelper(List<Berry> berries) {
        this.berries = berries;
    }

    public int getShortestTimeForGrowingBerry() {
        return berries.stream().min(Comparator.comparingInt(Berry::getGrowthTime)).get().getGrowthTime();
    }

    public Berry getLargestBerryToGrowInShortestTime() {
        int shortestTime = getShortestTimeForGrowingBerry();
        return berries.stream()
                .filter(berry -> berry.getGrowthTime() == shortestTime)
                .max(Comparator.comparingInt(Berry::getSize)).get();
    }


}
