package com.task.service;

import com.task.model.Review;
import java.util.List;

public interface ReviewService {
    List<String> getMostActiveUsers(int number);
    List<String> getMostCommentedFood(int number);
    List<String> getMostUsedWords(int number);
    void save(Review review);
}
