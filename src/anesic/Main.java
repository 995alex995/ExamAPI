package anesic;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        System.out.println("Fetching berries, please wait");
        PokeAPI.getInstance().downloadBerries(new ApiResult<List<Berry>>() {
            @Override
            public void onSuccess(List<Berry> result) {
                System.out.println("Berries fetched\n"
                		+ "Finding largest you can grow in shortest time \n");
                BerryHelper berryHelper = new BerryHelper(result);
                Berry berry = berryHelper.getLargestBerryToGrowInShortestTime();
                System.out.println("Largest berry you can grow in shortest time is: " + berry.getName());
                System.out.println("Berry Info:\n" + berry.toString());
            }

            @Override
            public void onError(Exception e) {
                System.out.println("We couldn't fetch berries, see stacktrace for more information\n");
            }
        });
    }


}
