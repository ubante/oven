package com.ubante.oven.makefiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Random;
import java.util.Set;

/**
 * Created by J on 5/5/2014.
 */
public class FileCreator {
    String outputDirectory;
    String outputFileBasename;
    String outputFilename;
    Random r = new Random();
    String content = getContent();

    FileCreator(String dir) {
        this.outputDirectory = dir;

        outputFileBasename = String.format("%s\\outputfile_%s",outputDirectory,
                Integer.toString(r.nextInt(90000)+10000));
    }

    void chooseOutputFilename() {
//        Calendar takenTime = Calendar.getInstance();
        outputFilename = String.format("%s-%s",outputFileBasename,
                Integer.toString(r.nextInt(90000)+10000));
    }

    String getContent() {
        return "ajwl3fjal2jdalk2j3f4lka2fj4lkajw34flkawj3fl4ajwf4lawj34lfjalw3jaw34gawjl3kfj4al3wk4\n";
    }

    void writeWithFile() {
        chooseOutputFilename();
        System.out.println("Writing with File to: "+outputFilename);

        File file = new File(outputFilename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void writeWithIOStreams() {
        chooseOutputFilename();
        System.out.println("Writing with I/O Streams to: "+outputFilename);

        File file = new File(outputFilename); // file should exist
        OutputStream stream = null;

        try {
            stream = new FileOutputStream(outputFilename);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void writeWithRandomAccessFile() {
        chooseOutputFilename();
        System.out.println("Writing with RandomAccessFile to: "+outputFilename);

        // This does not actually create a file
        File file = new File(outputFilename);
        RandomAccessFile randomAccessFile =null;

        try {
            randomAccessFile = new RandomAccessFile(file,"rw");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(3);
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void writeWithNIO() {
        chooseOutputFilename();
        System.out.println("Writing with NIO to: "+outputFilename);

        try {
            Path path = Files.createFile(Paths.get(outputFilename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void writeWithPosix() {
        chooseOutputFilename();
        System.out.println("Writing with POSIX to: "+outputFilename);

//        Set perms = PosixFilePermissions.fromString("rw-r--r--");
        Set perms = null;
        FileAttribute<Set<PosixFilePermission>> fileAttrs = PosixFilePermissions.asFileAttribute(perms);

        try {
            Path path = Files.createFile(Paths.get(outputFilename),fileAttrs);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String tempDir = "C:\\Users\\J\\Desktop\\tmp";

        FileCreator fc = new FileCreator(tempDir);

        System.out.println("Files will be written to directory: " + fc.outputFileBasename + "\n");

        fc.writeWithFile();
        fc.writeWithIOStreams();
        fc.writeWithRandomAccessFile();
        fc.writeWithNIO();
        fc.writeWithPosix();

    }

}
