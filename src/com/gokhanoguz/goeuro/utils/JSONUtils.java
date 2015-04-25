package com.gokhanoguz.goeuro.utils;

import com.gokhanoguz.goeuro.model.Suggestion;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.*;

/**
 * Created with IntelliJ IDEA.
 * User: gokhan
 * Date: 24.04.2015
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public class JSONUtils {

    public static ArrayList<Suggestion> convertJsonToSuggestion(String jsonString) throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Suggestion> suggestionArrayList = mapper.readValue(jsonString, new TypeReference<ArrayList<Suggestion>>(){});
        return  suggestionArrayList;
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String readJsonStringFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }
}
