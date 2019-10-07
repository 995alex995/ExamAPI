package anesic;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PokeAPI {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private static final String BERRY_PATH = "berry";
    private static final String OFFSET_AND_LIMIT_QUERY = "?offset=0&limit=";
    private static PokeAPI INSTANCE;
    private Gson gson;

    private PokeAPI() {
        gson = new Gson();
    }

    public static PokeAPI getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PokeAPI();
        }
        return INSTANCE;
    }

    public void downloadBerries(ApiResult<List<Berry>> callback) {
        try {
            callback.onSuccess(getBerriesWithAllInformation());
        } catch (IOException e) {
            e.printStackTrace();
            callback.onError(e);
        }
    }

    private String makeRequest(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "nesto");
        InputStream inputStream = connection.getInputStream();
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    private int getMaxNumberOfBerries() throws IOException {
        URL url = new URL(BASE_URL + BERRY_PATH);
        String apiStringResponse = makeRequest(url);
        PokeAPIResponse apiResponse = gson.fromJson(apiStringResponse, PokeAPIResponse.class);
        return apiResponse.getCount();
    }


    private List<Berry> getBerriesWithShortInfo(int limit) throws IOException {
        URL url = new URL(BASE_URL + BERRY_PATH + OFFSET_AND_LIMIT_QUERY + limit);
        String apiStringResponse = makeRequest(url);
        PokeAPIResponse apiResponse = gson.fromJson(apiStringResponse, PokeAPIResponse.class);
        return apiResponse.getResult();
    }


    private Berry getSingleBerry(String berryUrl) throws IOException {
        URL url = new URL(berryUrl);
        String apiStringResponse = makeRequest(url);
        return gson.fromJson(apiStringResponse, Berry.class);
    }

    private List<Berry> getBerriesWithAllInformation() throws IOException {
        List<Berry> berries = new ArrayList<>();
        int maxNumberOfBerries = getMaxNumberOfBerries();
        List<Berry> berryWithUrl = getBerriesWithShortInfo(maxNumberOfBerries);
        for (Berry berry : berryWithUrl) {
            berries.add(getSingleBerry(berry.getUrl()));
        }
        return berries;
    }

}
