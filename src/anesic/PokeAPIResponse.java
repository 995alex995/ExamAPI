package anesic;

import java.util.List;

public class PokeAPIResponse {

    private int count;
    private List<Berry> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Berry> getResult() {
        return results;
    }

    public void setResult(List<Berry> result) {
        this.results = result;
    }

}
