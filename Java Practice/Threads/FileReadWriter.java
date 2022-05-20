package Threads;
import java.io.*;
import java.util.Scanner;

public class FileReadWriter {

    private String filePath;

    public FileReadWriter(String filePath){
        this.filePath = filePath;
    }

    public void readFile() throws IOException {
        File file = new File(filePath);
        if(file.exists()){
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                String nextLine = scnr.nextLine();
                System.out.println(nextLine);
            }
        }else{
            throw new FileNotFoundException();
        }
    }

    public int countLines() throws IOException {
        int countLines = 0;
        File file = new File(filePath);
        if(file.exists()){
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                String nextLine = scnr.nextLine();
                System.out.println(nextLine);
                countLines++;
            }
            return countLines;
        }else{
            throw new FileNotFoundException();
        }
    }


    public boolean appendToFile(String writeToFile) throws IOException {
        File file = new File(filePath);
        if(file.exists()) {
            FileWriter fileWriter = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            try {
                fileWriter = new FileWriter(filePath, true);

                bw = new BufferedWriter(fileWriter);
                pw = new PrintWriter(bw);
                pw.println(writeToFile);
                return true;
            }finally {
                pw.flush();
                pw.close();
                bw.close();
                fileWriter.close();
            }
        }else{
            throw new FileNotFoundException();
        }
    }

    public boolean writeFile(String writeToFile) throws IOException{
        File file = new File(filePath);
        if(file.exists()) {
            FileWriter fileWriter = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            try {
                fileWriter = new FileWriter(filePath);

                bw = new BufferedWriter(fileWriter);
                pw = new PrintWriter(bw);
                pw.println(writeToFile);
                return true;
            }finally {
                pw.flush();
                pw.close();
                bw.close();
                fileWriter.close();
            }
        }else{
            throw new FileNotFoundException();
        }

    }
}
