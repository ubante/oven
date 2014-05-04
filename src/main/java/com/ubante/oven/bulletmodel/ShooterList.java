package com.ubante.oven.bulletmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 4/7/2014.
 */
public class ShooterList {
    List<Shooter> shooters = new ArrayList<Shooter>();
    String name;
    List<Photo> bulletPhotos;
    int countdownDuration = 5; // seconds

    ShooterList(String name) { this.name = name; }

    ShooterList() { this("defaultshooterlistname"); }

    void join(Shooter s) {
        shooters.add(s);
    }

    void leave(Shooter s) {
        shooters.remove(s);
    }

    List<Shooter> getShooters() { return shooters; }

    /**
     * Only the master shooter can initiate this.
     */
    void shootBulletPhoto() {
        // Need the countdown here.

        // Do ping to make sure shooters are still available

        List<Photo> photoList = new ArrayList<Photo>();
        for (Shooter s : getShooters()) {
            s.shoot();
            Photo p = s.getLastPhoto();
            photoList.add(p);
        }
        bulletPhotos = photoList;
    }

    void printBulletPhotos() {
        for (Photo p : bulletPhotos) {
            p.print();
        }
    }

    public int size() {
        return shooters.size();
    }

    void printStatus() {
        System.out.println("ShooterList: "+name);
        System.out.printf("Size: %d\n",shooters.size());
        System.out.printf("Members: ");
        for (Shooter s : shooters) {
            System.out.printf("%s ",s.humanName);
        }
        System.out.println();

    }

    public void getShooterStringList() {

    }

    /**
     * Test main.
     * @param args
     */
    public static void main(String[] args) {
        ShooterList pl = new ShooterList();
        System.out.println("Initial size: "+pl.size());

        Shooter annie = new Shooter();
        annie.joinShooterList(pl);
        System.out.println("After annie size: "+pl.size());
        pl.join(new Shooter("b"));
        pl.join(new Shooter("c"));
        System.out.println("After b and c size: "+pl.size());

    }
}
