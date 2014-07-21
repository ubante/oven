package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 7/21/2014.
 */
public class EggMachine {
    List<Monster> monsterList = new ArrayList();

    EggMachine() {}
    
    Monster pull() {
        Monster m = new Monster();

        return m;
    }

    public static void main(String[] args) {
        EggMachine bem = new EggMachine();

        Monster pulled = bem.pull();

    }



}
