package com.my.test;
import java.lang.annotation.*;

@Repeatable(ReviewContainer.class)
public @interface Review {
    String ReviewerName();
    String ReviewDate();
}
