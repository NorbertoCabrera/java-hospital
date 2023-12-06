package com.solvd.javahospitalapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MedicalRecordReader implements AutoCloseable {

    private BufferedReader reader;

    public MedicalRecordReader(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    public String readMedicalRecord () throws IOException {
     StringBuilder medicalRecordContent = new StringBuilder();
     String line;
     while ((line = reader.readLine())!=null){
         medicalRecordContent.append(line).append("\n");
        }
     if (medicalRecordContent.length()==0){
         throw new IOException("Error reading the file, Empty content!!");

     }
     return medicalRecordContent.toString();
    }

    @Override
    public void close () throws IOException{
       if (reader != null){
           reader.close();
       }
    }
}
