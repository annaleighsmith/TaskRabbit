package com.github.annaleighsmith;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskFileManager {
    private static final String FILE_PATH = AppConfig.FILE_PATH;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Task> readTasksFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File does not exist. Creating a new file.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null; // Or handle the error as per your application's logic
            }
            return new ArrayList<>(); // Return an empty list as the file is newly created
        }

        try {
            return objectMapper.readValue(file, new TypeReference<List<Task>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Or handle the error as per your application's logic
        }
    }

    public static void writeTasksToFile(List<Task> tasks) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}