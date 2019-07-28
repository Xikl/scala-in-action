package com.ximo.scala.programingscala.chapter06;

import java.util.stream.LongStream;

/**
 * @author xikl
 * @date 2019/7/28
 */
public class JavaFactorial {

    /**
     * 0的阶乘也是1
     * 这里忽略负数的情况
     *
     * @param n
     * @return
     */
    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long result = 1;

        for (long j = 2; j <= n; j++) {
            result *= j;
        }
        return result;
    }

    public static void main(String[] args) {
        LongStream.rangeClosed(1, 10)
                .map(JavaFactorial::factorial)
                .forEach(System.out::println);

    }

    /**
     * 不太好的递归
     *
     * @param n
     * @return
     */
    public static long factorialRec(long n) {
        if (n == 0) {
            return 1;
        }

        return n * factorialRec(n - 1);
    }


    /**
     * 尾递归优化
     *
     * @param n
     * @return
     */
    public static long bestFactorialRec(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        return bestFactorialRec(n, 1);
    }

    public static long bestFactorialRec(long n, long acc) {
        if (n == 0) {
            return acc;
        }

        return bestFactorialRec(n - 1, n * acc);
    }

}
