package com.ubante.oven.forruby;

/**
 * Created by ubante on 10/21/14.
 */
public class RubyTinkerer {

    RubyTinkerer() {}

    void proveObjectiveness(String message) {
        System.out.println("We are inside a method.");
        System.out.println(message);
        return;
    }

    void decipher(String unknownMessage) {
        System.out.println("Recieved unknown message: " + unknownMessage);

        return;
    }

    public static void main(String[] args) {
        RubyTinkerer rt = new RubyTinkerer();
        rt.proveObjectiveness("works");

//        rt.toSomething();
        rt.decipher("toSomething");
    }
}
