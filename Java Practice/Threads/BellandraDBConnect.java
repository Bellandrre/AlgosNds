package Threads;

import java.sql.*;
import java.util.Base64;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BellandraDBConnect {
    private Lock lock = new ReentrantLock(true);
    public enum BellandraDBEntity {
        AUTHOR,
        POSTS
    }
    private static final String connectionString = "jdbc:mysql://bellandradb.mysql.database.azure.com:3306/eastwind?useSSL=true";

    private Connection con;
    private Statement stmt;

    public BellandraDBConnect(){
        try {
            lock.lock();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connectionString, "bellandra", System.getenv("AZUREPASS")); // LOL :P take the pain to figure it out!
            stmt = con.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public int getCount(Enum entity) throws Exception {
        if(entity.equals(BellandraDBEntity.AUTHOR)) {
            ResultSet rs =  stmt.executeQuery("select count(*) from authors");
            rs.next();
            return rs.getInt(1);
        }else if(entity.equals(BellandraDBEntity.POSTS)){
            ResultSet rs = stmt.executeQuery("select count(*) from posts");
            rs.next();
            return rs.getInt(1);
        }
        return 0;
    }
    public ResultSet getAuthors(Integer id) throws Exception{
        return stmt.executeQuery("select * from authors where id="+ id);
    }

    public ResultSet getPosts(Integer id) throws Exception {
        return stmt.executeQuery("select * from posts where id="+ id);
    }

    public void closeConnection() throws Exception{
        con.close();
    }

}
