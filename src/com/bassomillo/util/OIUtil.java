package com.bassomillo.util;

import com.bassomillo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OIUtil {
    public static void copy(InputStream inputStream, String path){
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(path);
            byte[] buf = new byte[1024*1024];
            int len;
            while ((len=inputStream.read(buf))!=-1){
                outputStream.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
