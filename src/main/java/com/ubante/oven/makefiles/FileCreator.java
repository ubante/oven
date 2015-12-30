package com.ubante.oven.makefiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

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
        resetOutputFilename();
        outputFilename = String.format("%s-%s", outputFilename, suffix);
    }

    String getContent() {
        return "ajwl3fjal2jdalk2j3f4lka2fj4lkajw34flkawj3fl4ajwf4lawj34lfjalw3jaw34gawjl3kfj4al3wk4\n";
    }

    /**
     * See http://www.roseindia.net/java/beginners/java-write-to-file.shtml
     * and http://www.javacodex.com/Files/Write-To-A-File
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
        resetOutputFilename("RandomAccessFile");
        System.out.println("Writing with RandomAccessFile to: "+outputFilename);

        File file = new File(outputFilename);
        RandomAccessFile randomAccessFile = null;

        try {
            randomAccessFile = new RandomAccessFile(file,"rw");
//            randomAccessFile.writeChars(content); // this adds non-printable characters
            randomAccessFile.writeBytes(content);
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
        resetOutputFilename("NIO");
        System.out.println("Writing with NIO to: "+outputFilename);

        try {
            Files.write(Paths.get(outputFilename), content.getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * From http://www.javacodex.com/Files/Write-To-A-File-Using-A-PrintWriter
     *
     * Note that this adds a trailing newline.
     */
    void writeWithPrintWriter() {
        resetOutputFilename("PrinterWriter");
        System.out.println("Writing with PrintWriter to: "+outputFilename);

        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            pw.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileCreator fc = new FileCreator("/Users/ubante/tmp", "Darwin");

        System.out.println("Files will be written to the temp directory with a basename of: \n" +
                fc.outputFileBasename + "\n");

        fc.writeWithFile();
        fc.writeWithIOStreams();
        fc.writeWithRandomAccessFile();
        fc.writeWithNIO();
        fc.writeWithPrintWriter();

    }

}
