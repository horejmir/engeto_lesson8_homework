package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.SchoolClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class SchoolServiceJSON extends SchoolServiceBasic implements SchoolService {

    private final String OUTPUT_FILE_NAME;

    public SchoolServiceJSON(String outputFileName){
        super();
        this.OUTPUT_FILE_NAME = outputFileName;
    }

    public void importFromFile(String inputFileName) {

        Path path = Paths.get(inputFileName);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            Gson gson = gsonBuilder.create();

            List<SchoolClass> importedClasses = gson.fromJson(reader,
                    new TypeToken<List<SchoolClass>>() {
                    }.getType());

            this.classes.addAll(importedClasses);

            System.out.println("School classes ("+ importedClasses.size() +") successfully imported from file: " + inputFileName);

        } catch (IOException e){ System.err.println(e.getLocalizedMessage()); }
    }

    @Override
    public void generateOutput() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME))) {
            writer.write(gson.toJson(this.classes));
            System.out.println("List of school classes ("+ this.classes.size() +") successfully saved to file: " + OUTPUT_FILE_NAME);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
