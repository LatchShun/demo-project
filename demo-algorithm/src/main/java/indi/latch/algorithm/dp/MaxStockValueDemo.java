package indi.latch.algorithm.dp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Title: MaxStockValueDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/15
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class MaxStockValueDemo {

    public static void main(String[] args) {
        List<Integer> stockValueList = Stream.of(1, 3, 5, 8, 2, 19)
                .collect(Collectors.toList());
        int maxStockDiff = stockValueList.get(1) - stockValueList.get(0);
        int minStockValue = Math.min(stockValueList.get(0), stockValueList.get(1));

        for (int i = 1; i < stockValueList.size(); i++) {
            maxStockDiff = Math.max(stockValueList.get(i) - minStockValue, maxStockDiff);
            minStockValue = Math.min(minStockValue, stockValueList.get(i));
        }

        System.out.println("MAX_STOCK_DIFF= " + maxStockDiff);
    }
}
