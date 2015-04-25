package com.gokhanoguz.goeuro;

import au.com.bytecode.opencsv.CSVWriter;
import com.gokhanoguz.goeuro.model.Suggestion;
import com.gokhanoguz.goeuro.utils.Constants;
import com.gokhanoguz.goeuro.utils.JSONUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: gokhan
 * Date: 24.04.2015
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class App {

    private static final Logger log = Logger.getLogger(App.class);


    public static void main(String[] args) {

        if(args.length != 1){
            log.error("Usage: java -jar GoEuroTest.jar <CITY_NAME>");
        } else {

            try {
                String jsonString = JSONUtils.readJsonStringFromUrl(Constants.API_BASE + args[0]);
                ArrayList<Suggestion> suggestionArrayList = JSONUtils.convertJsonToSuggestion(jsonString);
                writeCvsFile(suggestionArrayList, Constants.FILE_NAME);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeCvsFile(ArrayList<Suggestion> suggestionArrayList, String fileName) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(fileName), '\t');
            String id = "";
            String name = "";
            String type = "";
            String latitude  = "";
            String longtitude = "";
            for(Suggestion suggestion : suggestionArrayList) {

                if(suggestion.get_id() != null) {
                    id = String.valueOf(suggestion.get_id());
                } else {
                    id = "NoID";
                }

                if(suggestion.getName() != null) {
                    name = suggestion.getName();
                }  else {
                    name = "NoName";
                }

                if(suggestion.getType() != null) {
                    type = suggestion.getType();
                }   else {
                    type = "NoType";
                }

                if(suggestion.getGeo_position().getLatitude() != null) {
                    latitude = String.valueOf(suggestion.getGeo_position().getLatitude());
                }   else {
                    latitude = "NoLatitude";
                }

                if (suggestion.getGeo_position().getLongitude() != null) {
                    longtitude = String.valueOf(suggestion.getGeo_position().getLongitude());
                } else {
                    longtitude = "NoLongtitude";
                }

                writer.writeNext(new String[]{id,name,type,latitude,longtitude});
            }

            writer.flush();
            writer.close();
            log.info("Csv File: " + fileName + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
