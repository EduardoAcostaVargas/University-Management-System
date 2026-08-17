package Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class PersistenceManager {
    private static final String FILE_PATH = "data.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveData(DataStore dataStore){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), dataStore);
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static DataStore loadData() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return mapper.readValue(file, DataStore.class);
            } else {
                System.out.println("No existing data found. Starting fresh.");
                return new DataStore();
            }
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
            return new DataStore();
        }
    }


}
