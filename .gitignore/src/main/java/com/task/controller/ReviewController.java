package com.task.controller;

import com.task.service.ReviewService;
import com.task.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final TextService textService;

    @Autowired
    public ReviewController(ReviewService reviewService, TextService textService) {
        this.reviewService = reviewService;
        this.textService = textService;
    }

    @GetMapping("/most-active-users/get")
    public List<String> getMostActiveUsers(){
        return reviewService.getMostActiveUsers(100);
    }

    @GetMapping("/most-commented-food/get")
    public List<String> getMostCommentedFood(){
        return reviewService.getMostCommentedFood(100);
    }

    @GetMapping("/most-used-words")
    public List<String> getMostUsedWords(){
        List<String> text = reviewService.getText();
        return textService.getMostUsedWords(10, text);
    }
}
