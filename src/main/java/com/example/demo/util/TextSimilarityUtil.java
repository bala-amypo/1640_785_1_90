package com.example.demo.util;

import java.util.*;
import java.util.stream.Collectors;

public class TextSimilarityUtil {

    public static double similarity(String a, String b) {
        if (a == null || b == null) return 0.0;
        String sa = a.trim().toLowerCase();
        String sb = b.trim().toLowerCase();
        if (sa.isEmpty() || sb.isEmpty()) return 0.0;

        Set<String> setA = Arrays.stream(sa.split("\\s+"))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toSet());
        Set<String> setB = Arrays.stream(sb.split("\\s+"))
                .filter(s -> !s.isBlank())
                .collect(Collectors.toSet());
        if (setA.isEmpty() || setB.isEmpty()) return 0.0;

        Set<String> inter = new HashSet<>(setA);
        inter.retainAll(setB);
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);
        return union.isEmpty() ? 0.0 : (double) inter.size() / union.size();
    }
}
