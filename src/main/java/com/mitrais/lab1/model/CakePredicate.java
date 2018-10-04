package com.mitrais.lab1.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CakePredicate {

    public static Predicate<Cake> isOrderCake() {
        return p -> p instanceof OrderCake;
    }

    public static Predicate<Cake> isReadyMakeCake(){
        return p -> p instanceof  ReadyMadeCake;
    }

    public static List<Cake> filterCakes (List<Cake> employees,
                                          Predicate<Cake> predicate)
    {
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Cake>toList());
    }
}
