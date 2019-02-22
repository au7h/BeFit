package com.nowinski.kamil.befit.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOperations {
    public static String readFromFile(String filePath, Context context) {

        String ret = "";

        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static void createDir(String path){
        File folder = new File(path);
        if(!folder.exists()){
            try{
                folder.mkdir();
            } catch (Exception e){
                Log.d("createDir() - Error", e.toString());
            }
        }
    }

    public static void createFile(String path, String fileName, String text){
        File file = new File(path+"/"+fileName+".txt");
        FileOutputStream fOut;
        OutputStreamWriter myOutWriter;
        try{
            fOut = new FileOutputStream(file);
            myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(text);
            myOutWriter.close();
            fOut.close();
        } catch (Exception e){
            Log.d("createFile() - Error", e.toString());
        }
    }
}
