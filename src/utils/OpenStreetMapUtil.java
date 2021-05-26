package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;


public class OpenStreetMapUtil {
    private static OpenStreetMapUtil instance = null;
    private final JSONParser jsonParser;

    public OpenStreetMapUtil() {
        jsonParser = new JSONParser();
    }

    public static OpenStreetMapUtil getInstance() {
        if (instance == null) {
            instance = new OpenStreetMapUtil();
        }
        return instance;
    }

    private String getRequest(String url) throws Exception {

        final URL obj = new URL(url);
        final HttpURLConnection connection = (HttpURLConnection)obj.openConnection();

        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            return null;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public Map<String, Double> getCoordinates(String address) {
        Map<String, Double> res;
        StringBuilder query;
        String[] split = address.split(" ");
        String queryResult = null;

        query = new StringBuilder();
        res = new HashMap<String, Double>();

        query.append("https://nominatim.openstreetmap.org/search?q=");

        if (split.length == 0) {
            return null;
        }

        for (int i = 0; i < split.length; i++) {
            query.append(split[i]);
            if (i < (split.length - 1)) {
                query.append("+");
            }
        }
        query.append("&format=json&addressdetails=1");

//        System.out.println("Query:" + query);

        try {
            queryResult = getRequest(query.toString());
        } catch (Exception e) {
            System.out.println("Error when trying to get data with the following query " + query);
        }

        if (queryResult == null) {
            return null;
        }

//        System.out.println(queryResult);
        Object obj = JSONValue.parse(queryResult);
//        System.out.println("obj=" + obj);

        if (obj instanceof JSONArray) {
            JSONArray array = (JSONArray) obj;
            if (array.size() > 0) {
                JSONObject jsonObject = (JSONObject) array.get(0); // luam primul oras din json-ul raspuns

                String lon = (String) jsonObject.get("lon");
                String lat = (String) jsonObject.get("lat");
//                System.out.println("lon=" + lon);
//                System.out.println("lat=" + lat);
                res.put("lon", Double.parseDouble(lon));
                res.put("lat", Double.parseDouble(lat));
            }
        }

        return res;
    }
}

