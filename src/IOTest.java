import java.io.*;
import java.util.*;

public class IOTest{
    public static void main(String[] args){
        String input = "/Users/andy/Desktop/XQUERY/xquery-processor-master/src/main/java/test";
        String output = "/Users/andy/Desktop/XQUERY/xquery-processor-master/src/main/java/output";
        File queryFile = new File(input);
        byte[] queryBuf = new byte[4096];
        try{
            FileInputStream r = new FileInputStream(queryFile);
            int num = r.read(queryBuf);
            String query = (new String(queryBuf)).trim();
            System.out.println("---------Query--------\n" + num + "\n"+ query);
            
            File resultFile = new File(output);
            FileOutputStream outputStream = new FileOutputStream(resultFile);
            outputStream.write(query.getBytes());
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}