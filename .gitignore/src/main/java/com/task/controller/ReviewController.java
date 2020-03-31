package com.task.controller;

import com.task.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final int mostCommentedFoodLimit = 1000;
    private final int mostActiveUsersLimit = 1000;
    private final int mostUsedWordsLimit = 1000;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/most-active-users/get")
    public List<String> getMostActiveUsers(){
        return reviewService.getMostActiveUsers(mostActiveUsersLimit);
    }

    @GetMapping("/most-commented-food/get")
    public List<String> getMostCommentedFood(){
        return reviewService.getMostCommentedFood(mostCommentedFoodLimit);
    }
}
