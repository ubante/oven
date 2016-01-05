package com.ubante.oven.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Java loves images
 *
 * http://www.mkyong.com/java/how-to-read-an-image-from-file-or-url/
 */
public class ImageLover {
    String kittyUrlString = "http://www.mrwallpaper.com/wallpapers/Cat-Sad-Annoyed.jpg";
    URL kittyUrl;
    File dogFile = new File("src/main/java/com/ubante/oven/images/dog.jpg");
    Image image;

    ImageLover() {
        try {
            kittyUrl = new URL(kittyUrlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("Bad URL");
            System.exit(1);
        }
    }

    void readUrl() {
        System.out.println("Reading the cat from an URL.");
        try {
            image = ImageIO.read(kittyUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFile() {
        System.out.println("Reading the dog from a file.");
        try {
            String current = new File( "." ).getCanonicalPath();
            String currentDir = System.getProperty("user.dir");

            System.out.println("Current dir:" + current + " and " + currentDir);
            image = ImageIO.read(dogFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display() {
        System.out.println("Displaying the animal in a frame.");
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        ImageLover il = new ImageLover();
//        il.readUrl();
        il.readFile();
        il.display();


    }

}
