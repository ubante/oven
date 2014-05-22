package com.ubante.oven.carswapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 5/21/2014.
 */
public class Swapamatic {

    static void donate(Person giver, Person receiver) {
        receiver.setCar(giver.car);
        giver.loseCar();
    }

    static void display(List<Person> pList) {
        for (Person p : pList) {
            System.out.printf("%15s, %5.0f, %6.0f\n",
                    p.toString(), p.car.value, p.getBalance());
        }
    }

    public static void main(String[] args) {
        List<Person> peeps = new ArrayList<>();
        Car subaru = new Car(15000,"subaru");
        Person cnd = new Person("C");
        cnd.setCar(subaru);
        peeps.add(cnd);

        Car x = new Car(2000,"L");
        Person s = new Person("S");
        s.setCar(x);
        peeps.add(s);

        Car h = new Car(16000,"h");
        Person l = new Person("L");
        l.setCar(h);
        peeps.add(l);

        Car b = new Car(20000,"b");
        Person v = new Person("V");
        v.setCar(b);
        peeps.add(v);

        System.out.println("Before");
        for (Person p : peeps) {
            System.out.printf("%15s, %5.0f\n", p.toString(), p.car.value);
        }

        System.out.println("\nAfter 1");
        donate(cnd,s);
        display(peeps);

        System.out.println("\nAfter 2");
        donate(l,cnd);
        display(peeps);

        System.out.println("\nAfter 3");
        donate(v,l);
        display(peeps);






    }
}
