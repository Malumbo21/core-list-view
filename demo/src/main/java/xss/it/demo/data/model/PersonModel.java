package xss.it.demo.data.model;

import org.json.JSONArray;
import org.json.JSONObject;
import xss.it.demo.Demo;
import xss.it.demo.data.entity.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XDSSWAR
 * Created on 06/27/2024
 */
public class PersonModel {
    /**
     * Reads a file from the resources and returns its content as a string.
     * @param fileName the name of the file to read
     * @return the content of the file as a string, or null if an error occurs
     */
    public static String readFileFromResources(String fileName) {
        try (InputStream inputStream = Demo.class.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Converts a JSON array string into a list of Person objects.
     * @param jsonArrayString the JSON array string to convert
     * @return the list of Person objects
     */
    public static List<Person> fromJsonArray(String jsonArrayString) {
        List<Person> personList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonArrayString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            Person person = new Person(
                    o.optString("name", ""),
                    o.optString("email", ""),
                    o.optString("city", ""),
                    o.optString("mac", ""),
                    o.optString("timestamp", ""),
                    o.optString("creditcard", "")
            );
            personList.add(person);
        }

        return personList;
    }


}
