package indi.latch.algorithm.leet;

/**
 * Title: IntegerReverseDemo
 * Description:
 * Copyright: 数禾科技 Copyright(c) 2023/2/20
 * Encoding: UNIX UTF-8
 *
 * @author 徐林
 */
public class IntegerReverseDemo {
    private static final int MAX_VAL = (int)Math.pow(2, 31) - 1;
    private static final int MIN_VAL = -(int)Math.pow(2, 31);

    public static void main(String[] args) {
        IntegerReverseDemo integerReverseDemo = new IntegerReverseDemo();
        System.out.println(integerReverseDemo.reverse(1534236469));
        System.out.println(integerReverseDemo.reverse(123));
    }

    public int reverse(int x) {
        if (x > MAX_VAL || x < MIN_VAL) {
            return 0;
        }

        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result > MAX_VAL || result < MIN_VAL ? 0 : (int)result;
    }

}
