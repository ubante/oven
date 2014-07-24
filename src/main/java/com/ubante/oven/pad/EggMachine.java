package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * It's an egg machine.
 */
public class EggMachine {
    List<Monster> monsterList = new ArrayList<>();
    int monsterListSize;
    int pullCounter = 0;
    Random r = new Random();

    EggMachine(int monsterListSize) {
        this.monsterListSize = monsterListSize;
        for (int i=0; i<monsterListSize; i++) {
            monsterList.add(new Monster("a"+i));
        }
    }

    void printMonsterList() {
        System.out.println("Here's the list of monsters:");
        for (Monster m : monsterList) {
            System.out.printf("%s, ", m.name);
        }
        System.out.println();
    }

    Monster pull() {
        int index = r.nextInt(monsterListSize);

//        System.out.println("\nUsing index=" + index);

        pullCounter++;

        return monsterList.get(index);
    }

    public static void main(String[] args) {
        EggMachine bem = new EggMachine(5);
        Collection c = new Collection(5);

        bem.printMonsterList();


    }



}
