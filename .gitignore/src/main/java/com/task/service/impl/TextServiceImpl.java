package com.task.service.impl;

import com.task.service.TextService;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TextServiceImpl implements TextService {

    @Override
    public List<String> getMostUsedWords(int limit, List<String> words) {
        List<String> mostUsedWords = new ArrayList<>();
        List<String> splitWords = new ArrayList<>();
        for (String word : words) {
            splitWords.addAll(Arrays.asList(wordCheck(word).split(" ")));
        }
        Map<String, Long> map = splitWords.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .forEachOrdered(e -> mostUsedWords.add(e.getKey()));
        return mostUsedWords;
    }

    private String wordCheck(String word) {
        return word.toLowerCase()
                .replaceAll("[^a-zA-Z ]", "")
                .trim()
                .replaceAll("\\s{2,}", " ");
    }
}
