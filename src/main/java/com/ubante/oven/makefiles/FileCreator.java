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
 * This will use five different ways to write to a file.
 * Becuase one way is never enough.
 */
public class FileCreator {
    String outputDirectory;
    String outputFileBasename;
    String outputFilename;
    Random r = new Random();
    String content = getContent();
    String os;

    FileCreator(String dir, String os) {
        this.outputDirectory = dir;
        this.os = os;

        if ( os.equals("Darwin") ) {
            outputFileBasename = String.format("%s/outputfile_%s",outputDirectory,
                    Integer.toString(r.nextInt(90000)+10000));
        } else if ( os.equals("Windows") ) {
            outputFileBasename = String.format("%s\\outputfile_%s",outputDirectory,
                    Integer.toString(r.nextInt(90000)+10000));
        } else {
            System.err.println("You did not choose a valid OS [Darwin|Windows].");
            System.err.println("You chose " + os + ".  Exiting.");
            System.exit(1);
        }
    }

    void resetOutputFilename() {
        outputFilename = String.format("%s-%s",outputFileBasename,
                Integer.toString(r.nextInt(90000)+10000));
    }

    void resetOutputFilename(String suffix) {
//        outputFilename = String.format("%s-%s-%s",outputFileBasename,
//                Integer.toString(r.nextInt(90000)+10000), suffix);
        resetOutputFilename();
        outputFilename = String.format("%s-%s", outputFilename, suffix);
    }

    String getContent() {
        return "ajwl3fjal2jdalk2j3f4lka2fj4lkajw34flkawj3fl4ajwf4lawj34lfjalw3jaw34gawjl3kfj4al3wk4\n";
    }

    /**
     * See http://www.roseindia.net/java/beginners/java-write-to-file.shtml
     */
    void writeWithFile() {
        resetOutputFilename("File");
        System.out.println("Writing with File to: "+outputFilename);

        File file = new File(outputFilename);
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void writeWithIOStreams() {
        resetOutputFilename("IOStream");
        System.out.println("Writing with I/O Streams to: "+outputFilename);

        File file = new File(outputFilename); // file should exist
        OutputStream stream = null;

        try {
            stream = new FileOutputStream(outputFilename);
            stream.write(content.getBytes());
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
        resetOutputFilename();
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
        resetOutputFilename();
        System.out.println("Writing with NIO to: "+outputFilename);

        try {
            Path path = Files.createFile(Paths.get(outputFilename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void writeWithPosix() {
        resetOutputFilename();
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
//        FileCreator fc = new FileCreator(tempDir, "fu");
//        FileCreator fc = new FileCreator("C:\\Users\\J\\Desktop\\tmp", "Windows");
        FileCreator fc = new FileCreator("/Users/ubante/tmp", "Darwin");

        System.out.println("Files will be written to the temp directory with a basename of: \n" +
                fc.outputFileBasename + "\n");

        fc.writeWithFile();
        fc.writeWithIOStreams();
        fc.writeWithRandomAccessFile();
        fc.writeWithNIO();
//        fc.writeWithPosix();

    }

}
