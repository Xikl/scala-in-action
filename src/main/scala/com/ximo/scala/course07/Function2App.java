package com.ximo.scala.course07;

import java.util.function.Function;

/**
 * @author xikl
 * @date 2019/2/28
 */
public class Function2App {


    public static Function<String, Integer> functionA = String::length;

    public static void main(String[] args) {
        functionA.apply("sss");
    }


}
