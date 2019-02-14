package com.ctrip.tour.wireless.bookinggateway.service.business.bestone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author pchenc
 * Created on 2019/2/14
 */
public class SortTest {

    public static void main(String[] args) {

        List<Person1> list = new ArrayList<>();
        list.add(new Person1("a", new BigDecimal(111)));
        list.add(new Person1("b", new BigDecimal(123)));
        list.add(new Person1("c", new BigDecimal(99)));
        list.add(new Person1("d", new BigDecimal(163)));
        System.out.println(list);
        //可以通过这种方式实行排序
        list.sort(Comparator.comparing(Person1::getAge).reversed());
        System.out.println(list);
    }

}
