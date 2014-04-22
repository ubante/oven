package com.ubante.oven.model.bullet;

/**
 * Created by J on 4/7/2014.
 */
public class Simulator {


    static void printStats(Shooter s) {
        System.out.printf("%s has %d photos\n",s.humanName,s.getGallerySize());
    }

    static void printStats(ShooterList sl) {
        for (Shooter s : sl.getShooters()) {
            printStats(s);
        }
    }

    static void info(String message) {
        System.out.println("\n--------- "+message);
    }


    /**
     * Main main
     * 130x HTC One
     * http://androidspin.com/2013/10/22/watch-snapdragon-create-photo-booth-130-htc-ones-bullet-time/
     *
     * 50x Canon 1Dx with 24-70 f/2.8 II ($400k)
     * https://www.youtube.com/watch?v=WDdxMBq2GW8
     *
     * @param args
     */
    public static void main(String[] args) {
        ShooterList sl = new ShooterList("Circus Shooters");

        info("Make me the mastershooter");
        MasterShooter me = new MasterShooter("Me");
        me.joinShooterList(sl);
        sl.printStatus();

        info("Make Annie");
        Shooter annie = new Shooter("Annie");
        annie.setDevice(new Device());
        annie.shoot();
//        annie.printStatus();

        info("Make Charles and join list");
        Shooter charles = new Shooter("Charles");
        charles.setDevice(new Device("HTC 1000"));
        charles.setLeftSide(annie);
        charles.shoot(2);
        charles.joinShooterList(sl);

        info("List");
        sl.printStatus();

        info("Make Bert and join list");
        Shooter bert = new Shooter("Bert");
        bert.setDevice(new Device("Apple iPad"));
        bert.setLeftSide(annie);
        bert.setRightSide(charles);
        bert.joinShooterList(sl);

        info("List");
        sl.printStatus();

        info("List stats");
        printStats(sl);

        info("Shoot bullet photo and list stats");
        me.startBulletPhoto();
        printStats(sl);

        info("Here are the bullet photos");
        me.printBulletPhotos();

        info("Annie joins list");
        annie.joinShooterList(sl);
        sl.printStatus();
        printStats(sl);

        info("Shoot another bullet photo");
        me.startBulletPhoto();
        printStats(sl);

        info("Here are the bullet photos");
        me.printBulletPhotos();

        info("Doggie, Elephant, Fox, Gorrilla and Hugo join");
        Shooter doggie = new Shooter("Doggie");
        doggie.joinShooterList(sl);
        Shooter elephant = new Shooter("Elephant");
        elephant.joinShooterList(sl);
        Shooter fox = new Shooter("Fox");
        fox.joinShooterList(sl);
        Shooter gorilla = new Shooter("Gorilla");
        gorilla.joinShooterList(sl);
        Shooter hugo = new Shooter("Hugo");
        hugo.joinShooterList(sl);
        sl.printStatus();

        info("Annie leaves");
        annie.leaveShooterList();
        sl.printStatus();

        info("More bullets photos");
        me.startBulletPhoto();
        me.printBulletPhotos();
        printStats(sl);

        info("Bert walks away in disgust");


    }
}
