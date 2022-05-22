package com.paolotalks.utils;

import java.util.Arrays;
import java.util.OptionalInt;

public class MathUtils {
    private MathUtils(){}

    public static int min(int... arr){
        return Arrays.stream(arr).min().orElseThrow();
    }

    public static int max(int... arr){
        return Arrays.stream(arr).max().orElseThrow();
    }
}
