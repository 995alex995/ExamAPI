package anesic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

 class PokeAPITest {

    @Test
    void testObtainingBerries() {
        PokeAPI.getInstance().downloadBerries(new ApiResult<List<Berry>>() {
            @Override
            public void onSuccess(List<Berry> result) {
                Assertions.assertNotNull(result);
                int MAX_NUMBER_OF_BERRIES = 64;
                Assertions.assertEquals(MAX_NUMBER_OF_BERRIES,result.size());
            }

            @Override
            public void onError(Exception e) {
            }
        });
    }

    @Test
    void testShortestTimeSuccess(){
        Assertions.assertEquals(1,berryHelperForTest().getShortestTimeForGrowingBerry());
    }

    @Test
    void testShortestTimeFail(){
        Assertions.assertNotEquals(5,berryHelperForTest().getShortestTimeForGrowingBerry());
    }

    @Test
    void testLargestBerryInShortestTimeSuccess(){
        Assertions.assertEquals(10,berryHelperForTest().getLargestBerryToGrowInShortestTime().getSize());
    }

    @Test
    void testLargestBerryInShortestTimeFail(){
        Assertions.assertNotEquals(22,berryHelperForTest().getLargestBerryToGrowInShortestTime().getSize());
    }

    static BerryHelper berryHelperForTest(){
        return new BerryHelper(testingList());
    }

    static List<Berry> testingList(){
        List<Berry> berries  = new ArrayList<>();
        for (int i=1; i <=10; i++){
            Berry berry = new Berry();
            berry.setId(i);
            berry.setName("Berry " + i);
            berry.setGrowthTime(i);
            berry.setSize(i * 10);
            berries.add(berry);
        }
        return berries;
    }

}
