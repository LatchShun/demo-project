package indi.latch.algorithm.leet;

/**
 * Title: StrConvertNDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/20
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class StrConvertNDemo {

    /**
     * class Solution {
     *     public String convert(String s, int numRows) {
     *         if (numRows == 1) return s;
     *         int len = s.length();
     *         StringBuilder sb = new StringBuilder(len);
     *         for (int row = 0; row < numRows; row++) {
     *             int i = row, step = row;
     *             while (i < len) {
     *                 sb.append(s.charAt(i));
     *                 do {
     *                     step = numRows - 1 - step;
     *                 } while (step == 0);
     *                 i += 2 * step;
     *             }
     *         }
     *         return sb.toString();
     *     }
     * }
     */

    public static void main(String[] args) {
        int numRows = 1;
        String s = "AB";
        StrConvertNDemo strConvertNDemo = new StrConvertNDemo();
        System.out.println(strConvertNDemo.convert2(s, numRows));

        s = "0123456789";
        numRows = 3;
        System.out.println(strConvertNDemo.convert2(s, numRows));
    }

    public String convert2(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }

        String[] resultArr = new String[numRows];

        int index = 0;
        int rowIndex = 0;
        boolean flag = true;
        while(index < s.length()) {
            if (resultArr[rowIndex] == null) {
                resultArr[rowIndex] = new String(String.valueOf(s.charAt(rowIndex)));
            } else {
                resultArr[rowIndex] = resultArr[rowIndex].concat(String.valueOf(s.charAt(index)));
            }

            if ((rowIndex + 1) % numRows == 0 || (!flag && rowIndex == 0)) {
                flag = !flag;
            }

            if (flag) {
                rowIndex++;
            } else {
                rowIndex--;
            }

            index++;
        }

        StringBuilder resultBuilder = new StringBuilder(s.length());
        for (String result : resultArr) {
            resultBuilder.append(result);
        }
        return resultBuilder.toString();
    }

    public String convert(String s, int numRows) {
        if (1 == numRows) {
            return s;
        }

        char[][] revertS = getTwoDimensionArray(s, numRows);
        return buildResultFromTwoDimensionArray(revertS, numRows, s.length());
    }

    private char[][] getTwoDimensionArray(String s, int numRows) {
        char[][] revertS = new char[numRows][s.length()];;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                revertS[i][j] = '#';
            }
        }

        boolean flag = true;
        int index = 0;
        int rowIndex = 0;
        int colIndex = 0;
        while (index < s.length()) {
            revertS[rowIndex][colIndex] = s.charAt(index);

            if ((rowIndex + 1) % numRows == 0 || (!flag && rowIndex == 0)) {
                flag = !flag;
            }

            if (flag) {
                rowIndex++;
            } else {
                rowIndex--;
                colIndex++;
            }

            index++;
        }

        return revertS;
    }

    private String buildResultFromTwoDimensionArray(char[][] revertS, int row, int column) {
        String result = "";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String s = String.valueOf(revertS[i][j]);
                if (!"#".equals(s)) {
                    result = result.concat(s);
                }
            }
        }

        return result;
    }
}
