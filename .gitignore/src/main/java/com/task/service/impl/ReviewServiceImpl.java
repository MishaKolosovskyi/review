package com.task.service.impl;

import com.task.model.Review;
import com.task.repository.ReviewRepository;
import com.task.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<String> getMostActiveUsers(int number) {
       return reviewRepository.getMostActiveUsers(number);
    }

    @Override
    public List<String> getMostCommentedFood(int number) {
       return reviewRepository.getMostCommentedFood(number);
    }

    @Override
    public List<String> getMostUsedWords(int number) {
        return reviewRepository.getText();
    }

    public void save(Review review){
        reviewRepository.save(review);
    }
}
