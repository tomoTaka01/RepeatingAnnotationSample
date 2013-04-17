package com.my.test;

import java.util.List;

@Review(ReviewerName = "Mr. D", ReviewDate = "2013/04/15")
public class Sample {
    @NonNull String str;
    @NonNull List<String> list;
//    List<@NonNull String> list2;  注釈型はこの種類の宣言に使用できません

    public static void main(String... args) {
        Sample sample = new Sample();
        sample.methodA();
        sample.methodB();
    }
    @Review(ReviewerName = "Mr.A", ReviewDate = "2013/04/01")
    @Review(ReviewerName = "Mr.C", ReviewDate = "2013/04/14")
    void methodA() {
        System.out.println("method A");
    }

    @Review(ReviewerName = "Mr.B", ReviewDate = "2013/04/01")
    void methodB() {
        System.out.println("method B");
    }
}
