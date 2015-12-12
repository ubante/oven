package com.ubante.oven.treemap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 12/8/2015.
 */
public class Simulator {
  String inputFile;
  List<Thing> knownThings = new ArrayList<>();
  Thing root = null;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  Thing findThing(String parentName) {
    for (Thing t : knownThings) {
      if ( t.getName().equals(parentName)) {
        return t;
      }
    }

    // Should never get here
    System.out.println("Lost things");
    System.exit(0);
    return null;
  }

  void processLine(String line) {

    String[] parts = line.split(" ");

    // XXX There's got to be a better way to make a tree
    if ( parts.length == 2) {
      // Handle root case
      Thing t = new Thing(parts[0], Integer.parseInt(parts[1]));
      System.out.println("---- Found the root: " + t.getName());
      knownThings.add(t);
      t.setRoot();
      root = t;
    } else {
      // Otherwise this is a child
      Thing t = new Thing(parts[1], Integer.parseInt(parts[2]));
      t.setParent(findThing(parts[0]));
      knownThings.add(t);
    }
  }

  void readFile() {
    BufferedReader br;

    String line;
    try {
      br = new BufferedReader(new FileReader(inputFile));

      while ((line = br.readLine()) != null) {
        processLine(line);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void print() {
    System.out.println();

    root.printChildren(1);
    System.out.printf(root.toString());
  }

  void run() {
    readFile();
    print();
  }

  void printTreemap() {
    root.printTreeMap();
    System.out.printf("%s, , ,1\n",root.getName());
  }

  public static void main(String[] args) {
    System.out.println("Doing it.");

    Simulator sim = new Simulator();
    sim.setInputFile("src\\main\\java\\com\\ubante\\oven\\treemap\\input.txt");
    sim.run();

    System.out.println("\n\n------------- TREEMAP -------------");
    sim.printTreemap();
  }
}
