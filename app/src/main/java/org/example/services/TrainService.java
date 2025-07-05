package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Train;

import java.beans.ConstructorProperties;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
    private List<Train> trainList;
    ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_FILE_PATH = "app/src/main/java/org/example/localDb/trains.json";

    public TrainService() throws IOException
    {

        File trains = new File(TRAIN_FILE_PATH);
        trainList =objectMapper.readValue(trains, new TypeReference<List<Train>>(){});
    }

    public List<Train> searchTrains(String source, String dest) {
        return trainList.stream().filter(train->validTrain(train, source, dest)).collect(Collectors.toList());
    }

    private boolean validTrain(Train train, String source, String dest) {
        List<String> stations = train.getStation();
        int sourceIndex = stations.indexOf(source);
        int destIndex = stations.indexOf(dest);
        // Check if source and destination are valid and in the correct order
        return sourceIndex != -1 && destIndex != -1 && sourceIndex < destIndex;// explain this line

    }
}
