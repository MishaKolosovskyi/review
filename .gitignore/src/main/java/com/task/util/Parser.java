package com.task.util;

import com.task.model.Review;
import com.task.service.ReviewService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Parser {

    private final ReviewService reviewService;

    @Autowired
    public Parser(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        parse("C:\\Users\\PCDOM\\Desktop\\task\\src\\main\\resources\\Reviews.csv");
    }

    public void parse(String path){
        try (Reader reader = Files.newBufferedReader(Paths.get(path));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                String productId = csvRecord.get(1);
                String userId = csvRecord.get(2);
                String profileName = csvRecord.get(3);
                String text = csvRecord.get(9);
                reviewService.save(new Review(productId, userId, profileName, text));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find a csv file");
        }
    }
}
