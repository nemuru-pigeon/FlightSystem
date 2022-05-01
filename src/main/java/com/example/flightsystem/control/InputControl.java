package com.example.flightsystem.control;

import com.example.flightsystem.control.impl.InputControlImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputControl implements InputControlImpl {
    @Override
    public Map<String, String> readIdCard() {
        Map<String, String> passengerInf = new HashMap<>();
        String content = null; // content used to read the content in id.txt

        /* presuppose id.txt save the information passed by ID card reader
           id.txt format: id, surname, given name, gender */
        String path = "/src/main/resources/com/example/flightsystem/input_files/id.txt";
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((content = bufferedReader.readLine()) != null) {
                String[] array=str.split(",");   //假设每行数据是以逗号分隔，id是第一个位置
                if(array.length>0 && id.equals(array[0])) {
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
