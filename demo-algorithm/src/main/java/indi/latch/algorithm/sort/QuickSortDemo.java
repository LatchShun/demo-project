package indi.latch.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: QuickSortDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/8
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        List<Integer> originalNumbers = Stream.of(5, 8, 9, 2, 3, 6, 10, 15, 0)
                .collect(Collectors.toList());
        quickSort(originalNumbers, 0, originalNumbers.size() - 1);
        System.out.println(originalNumbers);
    }

    private static void quickSort(List<Integer> origNumbers, int left, int right) {
        if (left > right) {
            return;
        }

        int pivotVal = origNumbers.get(left);

        int i = left;
        int j = right;
        while (i < j) {
            while ((i < j) && (origNumbers.get(j) > pivotVal)) {
                j--;
            }
            if (i < j) {
                origNumbers.set(i, origNumbers.get(j));
                origNumbers.set(j, pivotVal);
                i++;
            }

            while ((i < j) && (origNumbers.get(i) < pivotVal)) {
                i++;
            }
            if (i < j) {
                origNumbers.set(j, origNumbers.get(i));
                origNumbers.set(i, pivotVal);
                j--;
            }
        }

        quickSort(origNumbers, left, i - 1);
        quickSort(origNumbers, i + 1, right);
    }
}
