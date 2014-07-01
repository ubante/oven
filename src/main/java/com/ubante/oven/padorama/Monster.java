package com.ubante.oven.padorama;

/**
 * Created by ubante on 6/14/14.
 */
public class Monster {
    int skillLevelHp = 0;
    String name = "noname";
    boolean isDestroyed;
    Monster eatingMonster;


    Monster() {}

    Monster(int skillLevelHp) {
        this.skillLevelHp = skillLevelHp;
    }

    Monster(String name) {
        this.name = name;
    }

    int fuse(Monster m) {
        skillLevelHp += m.skillLevelHp;
        m.destroy(this);
        return skillLevelHp*1000;
    }

    int fuse(MonsterList mList) {
        for (Monster m : mList.getList()) {
            fuse(m);
        }
        return skillLevelHp*1000;
    }

    void destroy(Monster m) {
        eatingMonster = m;
        isDestroyed = true;
    }

    String getStatus() {
        String status;
        if (isDestroyed) {
            return String.format("%10s was fused into %s",
                    name,eatingMonster.name);
        }
        status = String.format("%10s has skill level %d",
                name,skillLevelHp);
        return status;
    }

    void printStatus() {
        System.out.println(getStatus());
    }

    public static void main(String[] args) {
        System.out.printf("something %6.3f%%\n",
                (1-((float) 20000/(210*1000)))*100);
    }
}
