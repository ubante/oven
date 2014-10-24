package com.ubante.oven.forruby;

/**
 * Created by ubante on 10/21/14.
 */
public class PropertyLikeResponder {
    private String _name = "myname";
    private String _weight = "9001";

    public String getName() {
        return _name;
    }

    public String getWeight() {
        return _weight;
    }

    PropertyLikeResponder() {}

    String send(String property) {

        if (property.equals("name")) {
            return getName();
        }

        if (property.equals("weight")) {
            return getWeight();
        }

        return null;
    }

    public static void main(String[] args) {
        PropertyLikeResponder prop = new PropertyLikeResponder();

        String name = prop.send("name");
        System.out.println("Sent 'name' and got " + name);
    }
}
