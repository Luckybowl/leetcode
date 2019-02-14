package com.ctrip.tour.wireless.bookinggateway.service.business.bestone;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author pchenc
 * Created on 2019/2/14
 */
@Data
public class Person1 {
    private String name;

    private BigDecimal age;

    Person1(String name, BigDecimal age) {
        this.name = name;
        this.age = age;
    }
}
