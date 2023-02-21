package indi.latch.algorithm.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: InsertionSortDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/9
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        List<Integer> origNumbers = Stream.of(5, 9, 8, 0, 1, 10, 4, 2).collect(Collectors.toList());

        System.out.println("排序前：" + origNumbers);
        insertionSort(origNumbers);
        System.out.println("排序后：" + origNumbers);
    }

    private static void insertionSort(List<Integer> origNumbers) {
        //5, 9, 8, 0, 1, 10, 4, 2
        for (int i = 1; i <= origNumbers.size() - 1; i++) {
            int j = i;
            int k = i;
            int val = origNumbers.get(i);

            for (j = i - 1; j >= 0; j--) {
                if (val > origNumbers.get(j)) {
                    break;
                }
            }

            if (j != i - 1) {
                for (k = i; k > j + 1; k--) {
                    origNumbers.set(k, origNumbers.get(k - 1));
                }
            }
            origNumbers.set(k, val);
        }
    }
}
