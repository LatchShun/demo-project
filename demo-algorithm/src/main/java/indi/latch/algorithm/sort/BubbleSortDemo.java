package indi.latch.algorithm.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: BubbleSortDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/9
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        List<Integer> origNumbers = Stream.of(5, 9, 8, 0, 1, 10, 4, 2).collect(Collectors.toList());

        System.out.println("排序前：" + origNumbers);
        bubbleSort(origNumbers);
        System.out.println("排序后：" + origNumbers);
    }

    private static void bubbleSort(List<Integer> origNumbers) {
        int size = origNumbers.size();
        for (int i = 0; i <= size - 2; i++) {
            for (int j = 0; j <= (size - 2) - i; j++) {
                int valJ = origNumbers.get(j);
                int valJplus = origNumbers.get(j + 1);

                if (valJ > valJplus) {
                    origNumbers.set(j, valJplus);
                    origNumbers.set(j + 1, valJ);
                }
            }
        }
    }
}
