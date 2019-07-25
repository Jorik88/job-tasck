package com.example.jobtasck;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestJobTasck {

//    Нужно из value сделать resultString, т.е если в строке мы находим дублирование символа то мы должны их сгрупировать вместе.
    @Test
    public void testGroupLiterals() {
        String value = "gsddfkrthoessh";
//        String resultString = "gsssddfkthhoe";
        String result = groupLiterals(value);
        System.out.println(result);
    }

    private String groupLiterals(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        StringBuilder resultString = new StringBuilder();
        Set<Character> unique = new HashSet<>();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (unique.contains(chars[i])) {
                continue;
            }
            resultString.append(chars[i]);
            unique.add(chars[i]);
            for (int x = i + 1; x < chars.length; x++) {
                if (chars[i] == chars[x]) {
                    resultString.append(chars[x]);
                }
            }
        }
        return resultString.toString();
    }

//    Нужно найти в массиве два числа, сумма которых равна sum.
    @Test
    public void testFindSumOfTwoElements() {
        int[] array = {4, 5, 7, 9, -1, 6};
        int sum  = 8;

        int[] sumOfTwoElements = findSumOfTwoElements(sum, array);
        System.out.println(Arrays.toString(sumOfTwoElements));
    }

//    Нужно написать метод который вернет сумму повторений символов т.е
//    если в строке есть две “r” или три и более “t” это считается за одно повторение,
//    если символ не повторяется мы его не считаем.
    @Test
    public void testCountDuplicates() {
        String input = "rmfgfhkssmesdaa";
        char[] chars = input.toCharArray();
        Set<Character> unique = new HashSet<>();
        for (char value : chars) {
            unique.add(value);
        }
        System.out.println(chars.length - unique.size());
    }

    private int[] findSumOfTwoElements(int sum, int[] array) {
        if (array.length == 0) {
            return null;
        }
        Set<Integer> integers = Arrays.stream(array).boxed().collect(Collectors.toSet());
        for (int value : array) {
            int result = sum - value;
            if ((double)sum / 2 != result && integers.contains(result)) {
                return new int[]{value, result};
            }
        }
        return null;
    }
}
