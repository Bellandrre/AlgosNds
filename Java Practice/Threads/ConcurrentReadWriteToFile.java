package Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentReadWriteToFile {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock  = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public int getCount(FileReadWriter fileReadWriter) throws Exception{
        try {
            readLock.lock();
            return fileReadWriter.countLines();
        }finally {
            readLock.unlock();
        }
    }

    public void append(FileReadWriter fileReadWriter, int count) throws Exception{
        try {
            writeLock.lock();
            fileReadWriter.appendToFile("Adding line number " + count + " by thread " + Thread.currentThread().getName());
        }finally {
            writeLock.unlock();
        }
    }

    public int getCountNotProtected(FileReadWriter fileReadWriter) throws Exception{
         return fileReadWriter.countLines();
    }

    public boolean appendNotProtected(FileReadWriter fileReadWriter, int count) throws Exception{
        return fileReadWriter.appendToFile("Adding line number " + count + " by thread " + Thread.currentThread().getName());
    }



    public static void main(String[] args) throws InterruptedException {
        ConcurrentReadWriteToFile concurrentReadWriteToFile = new ConcurrentReadWriteToFile();

        class WriteToFile implements Callable<String>{
            int insert_10_lines = 0;
            public String call(){
                try {

                    while(insert_10_lines < 10) {
                        FileReadWriter freadWrite = new FileReadWriter("/home/karthik/codeRepos/AlgosNds/Java Practice/Threads/Files/Watermelon.txt");
                        int countLines = concurrentReadWriteToFile.getCountNotProtected(freadWrite);

                        concurrentReadWriteToFile.appendNotProtected(freadWrite, countLines);

                        if (!concurrentReadWriteToFile.appendNotProtected(freadWrite, countLines)) {
                            System.out.println("There was an error writing to file");
                        }
                        insert_10_lines++;
                    }
                }catch(Exception ex){
                    System.out.println("There was an exception "+ ex);
                }
                return "This batch was successful";
            }
        };

        class WriteIsloatedLock implements Callable<String>{
            int insert_10_lines = 0;
            public String call(){
                try {

                    while(insert_10_lines < 10) {
                        FileReadWriter freadWrite = new FileReadWriter("/home/karthik/codeRepos/AlgosNds/Java Practice/Threads/Files/Watermelon.txt");
                        int countLines = concurrentReadWriteToFile.getCount(freadWrite);

                        concurrentReadWriteToFile.append(freadWrite, countLines);

                        if (concurrentReadWriteToFile.getCount(freadWrite) - countLines == 0) {
                            System.out.println("There was an error writing to file");
                        }
                        insert_10_lines++;
                    }
                }catch(Exception ex){
                    System.out.println("There was an exception "+ ex);
                }
                return "This batch was successful";
            }
        };

        List<Callable<String>> listOfTasks = new ArrayList<>();
        //TODO : Generate valid race condition
        for(int i = 0 ; i < 8; i++){
            listOfTasks.add(new WriteIsloatedLock());
        }
        ExecutorService service = Executors.newFixedThreadPool(8);
        try {
            service.invokeAll(listOfTasks);
        }finally {
            service.shutdown();
        }

    }
}

