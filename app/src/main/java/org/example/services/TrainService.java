package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;

import java.beans.ConstructorProperties;
import java.io.File;
import java.util.List;

public class TrainService {
    private List<Train> trainList;
    ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_FILE_PATH = "app/src/main/java/org/example/localDb/trains.json";

    public TrainService() throws Exception {

        File trains = new File(TRAIN_FILE_PATH);
        trainList =objectMapper.readValue(trains, new TypeReference<List<Train>>(){});
    }

    public List<Train> searchTrains(String source, String dest) {
        // This method should implement the logic to search for trains based on source and destination.
        // For now, it returns null as a placeholder.
        return null;
    }
}
