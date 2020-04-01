package com.task.service.impl;

import com.task.service.TextService;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TextServiceImpl implements TextService {

    @Override
    public List<String> getMostUsedWords(int limit, List<String> sentences) {
        List<String> mostUsedWords = new ArrayList<>();
        List<String> words = updateSentences(sentences);
        Map<String, Long> map = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .forEachOrdered(e -> mostUsedWords.add(e.getKey()));
        return mostUsedWords;
    }

    private List<String> updateSentences(List<String> sentences) {
        List<String> list = new ArrayList<>();
        sentences.forEach(sentence -> {
            String[] words = sentence.toLowerCase()
                    .replaceAll("[^a-zA-Z ]", "")
                    .trim()
                    .replaceAll("\\s{2,}", " ")
                    .split(" ");
            Collections.addAll(list, words);
        });
        return list;
    }
}
