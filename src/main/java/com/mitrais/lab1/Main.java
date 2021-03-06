package com.mitrais.lab1;

import com.mitrais.lab1.model.Cake;
import com.mitrais.lab1.model.CakePredicate;
import com.mitrais.lab1.model.OrderCake;
import com.mitrais.lab1.model.ReadyMadeCake;
import com.sun.javafx.image.BytePixelSetter;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by jchacana on 9/30/18.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("This is my Main class");
        List<Cake> cakeList, typesofCake;
        Cake[] cakes;

        /*Scanner s =  new Scanner(System.in);
        cakes = new Cake[nCake];
        String name;
        Double rate, weight, quantity;
        int nCake=4;
        for (int i=0;i<cakes.length;i++){
            System.out.println(String.format("Cake %d ", i+1));
            System.out.print("Input Name : ");
            name = s.nextLine();
            System.out.print("Input Rate : ");
            rate = s.nextDouble();
            s.nextLine();

            if (i<cakes.length/2){
                System.out.print("Input Weight : ");
                weight = s.nextDouble();
                cakes[i] = new OrderCake(name,rate,weight);
            }else{
                System.out.print("Input Quantity : ");
                quantity = s.nextDouble();
                cakes[i]= new ReadyMadeCake(name,rate,quantity);
            }
            name = s.nextLine();
        }*/

        //Init array
        cakes = new Cake[]{
                new OrderCake("A",12, 9.0),
                new OrderCake("B",10, 8.0),
                new OrderCake("C",15, 7.0),
                new OrderCake("D",14, 7.0),
                new OrderCake("E",17, 6.0),
                new OrderCake("F",19, 4.0),
                new OrderCake("G",11, 9.0),
                new OrderCake("H",14, 5.0),
                new OrderCake("I",12, 8.0),
                new OrderCake("J",16, 6.0),
                new ReadyMadeCake("K",9, 9.0),
                new ReadyMadeCake("L",13, 9.0),
                new ReadyMadeCake("M",17, 4.0),
                new ReadyMadeCake("N",12, 7.0),
                new ReadyMadeCake("O",18, 4.0),
                new ReadyMadeCake("P",14, 8.0),
                new ReadyMadeCake("Q",16, 6.0),
                new ReadyMadeCake("R",13, 8.0),
                new ReadyMadeCake("S",19, 4.0),
                new ReadyMadeCake("T",14, 8.0)
        };

        cakeList = Arrays.asList(cakes);

        //sort by calc prize
        cakeList.sort(Comparator.comparingDouble(c-> c.calcPrice()));
        displayAllCakes("All Cakes",cakeList);
        System.out.println(String.format("The highest price is Cake %s = %f", cakeList.get(cakeList.size()-1).getName(), cakeList.get(cakeList.size()-1).calcPrice()));


        typesofCake= CakePredicate.filterCakes(cakeList, CakePredicate.isOrderCake());
        displayAllCakes("Order Cake",typesofCake);

        typesofCake = CakePredicate.filterCakes(cakeList, CakePredicate.isReadyMakeCake());
        displayAllCakes("Ready Make Cake",typesofCake);
    }

    private static void displayAllCakes(String title, List<Cake> cakes) {
        System.out.println("\n"+title);
        System.out.println(String.format("Name\tRate\t\tW/Q\t\t\tPrice"));
        System.out.println("----------------------------------------------");
        for (Cake c:cakes
        ) {
            if (c instanceof OrderCake)
                System.out.println(String.format("Cake %s\t%f\t%f\t%f", c.getName(), c.getRate(), (((OrderCake) c).getWeight()),c.calcPrice()));
            else
                System.out.println(String.format("Cake %s\t%f\t%f\t%f", c.getName(), c.getRate(), (((ReadyMadeCake) c).getQuantity()),c.calcPrice()));
        }

        System.out.println(String.format("Total price is %f",cakes.stream().mapToDouble(p -> p.calcPrice()).sum()));

    }
}
