package com.example.flight_system.control;

import com.example.flight_system.control.impl.InputControlImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputControl implements InputControlImpl {
    /**
     * simulate the delivery of the ID information from the card reader
     * @return whether the delivery is successful
     */
    @Override
    public Map<String, String> readIdCard() {
        Map<String, String> passengerInf = new HashMap<>();
        String content; // content used to read the content in id.txt

        /* presuppose id.txt save the information passed by ID card reader
           id.txt format: id, surname, given name, gender */
        String path = "src/main/resources/com/example/flight_system/input_files/id.txt";
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((content = bufferedReader.readLine()) != null) {
                String[] contents = content.split(",");
                passengerInf.put("id", contents[0]);
                passengerInf.put("givenName", contents[1]);
                passengerInf.put("surname", contents[2]);
                passengerInf.put("gender", contents[3]);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return passengerInf;
    }
}
