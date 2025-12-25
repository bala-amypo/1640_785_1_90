package com.example.demo.util;

import java.util.*;

public class TextSimilarityUtil {

    public static double similarity(String a, String b) {
        if (a == null || b == null || a.isBlank() || b.isBlank()) return 0.0;
        a = a.toLowerCase();
        b = b.toLowerCase();

        Set<String> sa = new HashSet<>(Arrays.asList(a.split("\\s+")));
        Set<String> sb = new HashSet<>(Arrays.asList(b.split("\\s+")));

        Set<String> inter = new HashSet<>(sa);
        inter.retainAll(sb);

        Set<String> union = new HashSet<>(sa);
        union.addAll(sb);

        if (union.isEmpty()) return 0.0;
        return (double) inter.size() / union.size();
    }
}
