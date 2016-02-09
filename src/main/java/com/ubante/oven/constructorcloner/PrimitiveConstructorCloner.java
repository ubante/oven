package com.ubante.oven.constructorcloner;

/**
 * I could override clone() but the constructor approach is supposed to be better.
 *
 * But it only works since number is a primitive.  If it weren't then the cloning constructor would just return a
 * pointer to the cloned class's fields.
 */
public class PrimitiveConstructorCloner {
    int number = 0;

    PrimitiveConstructorCloner(int n) { number=n; }

    PrimitiveConstructorCloner(PrimitiveConstructorCloner c) { number = c.number; }

    void change() { number++; }


    public static void main(String[] args) {
        PrimitiveConstructorCloner c = new PrimitiveConstructorCloner(1);
        System.out.println("c:  " + c.number);
        System.out.println();

        PrimitiveConstructorCloner cc = new PrimitiveConstructorCloner(c);
        System.out.println("cc: " + cc.number);
        System.out.println("c:  " + c.number);
        System.out.println();

        cc.change();
        System.out.println("cc: " + cc.number);
        System.out.println("c:  " + c.number);
        System.out.println();

    }


}
