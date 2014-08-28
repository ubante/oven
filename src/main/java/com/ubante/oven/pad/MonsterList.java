package com.ubante.oven.pad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubante on 6/14/14.
 */
public class MonsterList {
    List<Monster> list = new ArrayList<>();

    MonsterList() {}

    void add(Monster m) {
        list.add(m);
    }

    List<Monster> getList() {
        return list;
    }

    int getSize() {
        return list.size();
    }
}
