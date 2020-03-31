package com.task.service;

import java.util.List;

public interface TextService {
    List<String> getMostUsedWords(int limit, List<String> words);
}
