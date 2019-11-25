/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_5;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Student
 */
public class RandomVarTest {

    public static void main(String[] args) {
        String X_name = "MPG";
        ArrayList allValue = getXValue("dataset/AutoSurvey.csv", X_name);
        RandomVar randomVar = new RandomVar(X_name, allValue.toArray());

        System.out.println(randomVar.getXValue());
        System.out.println(randomVar.getProb());
        randomVar.displayLineChart();
    }

    private static ArrayList getXValue(String fileName, String X_name) {
        JSONArray jsonObjects = null;
        try {
            jsonObjects = CSVToJSON(fileName, X_name);
        } catch (IOException e) {
            System.out.println(e);
        }
        ArrayList values = new ArrayList();
        for (Object object : jsonObjects) {
            if (object instanceof JSONObject) {
                JSONObject item = (JSONObject) object;
                String value = item.get(X_name).toString();
                values.add(value);
                System.out.println(value);
            }
        }
        return values;
    }

    @SuppressWarnings("Unchecked")
    private static JSONArray CSVToJSON(String filePath, String... headers) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVParser csvParser = new CSVParser(reader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
        );
        // Store converted records as a list
        JSONArray records = new JSONArray();

        for (CSVRecord recordLine : csvParser) {
            // Create new object to store data as JSON format
            JSONObject objectRecord = new JSONObject();

            // Access values using selected header names
            for (String header : headers) {
                objectRecord.put(header, recordLine.get(header));
            }
            records.add(objectRecord);
        }
        csvParser.close();
        return records;
    }
}
