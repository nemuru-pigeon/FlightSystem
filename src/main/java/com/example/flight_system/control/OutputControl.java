package com.example.flight_system.control;

import com.example.flight_system.control.impl.OutputContolImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class OutputControl implements OutputContolImpl {
    private String path = "src/main/resources/com/example/flight_system/output_files/";

    @Override
    public boolean pay(String cardNum, int vcc2Code, float amount) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");

        File payFile = new File(path + cardNum + "_" + sdf.format(date) + ".txt");
        if (payFile.exists()) {
            System.out.println("Already payed!");
            return false;
        }

        try {
            FileWriter myFile = new FileWriter(payFile);
            BufferedWriter buffer = new BufferedWriter(myFile);
            buffer.write("card number: " + cardNum + "\n");
            buffer.write("VCC2 code: " + vcc2Code + "\n");
            buffer.write("amount of money: " + amount);
            buffer.close();
            myFile.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean printBoardingPass(Map<String, String> passInf) {
        File passFile = new File(path + passInf.get("booking_no") + "_pass.txt");
        if (passFile.exists()) {
            System.out.println("Already printed the boarding pass!");
            return false;
        }

        try {
            FileWriter myFile = new FileWriter(passFile);
            BufferedWriter buffer = new BufferedWriter(myFile);
            for (Map.Entry<String, String> entry : passInf.entrySet()) {
                if (entry.getKey().equals("booking_no")) {
                    continue;
                }
                buffer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            buffer.close();
            myFile.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean printTags(String bookingNo, String id, int num) {
        for (int i=0; i<num; i++) {
            File file = new File(path + bookingNo + "_tag" + (i+1) + ".txt");
            if (file.exists()) {
                System.out.println("Already printed the tags!");
                return false;
            }

            try {
                FileWriter myFile = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(myFile);
                buffer.write(id + "'s carry on baggage tag " + (i+1));
                buffer.close();
                myFile.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean printTickets(String bookingNo, String id, int num) {
        for (int i=0; i<num; i++) {
            File file = new File(path + bookingNo + "_ticket" + (i+1) + ".txt");
            if (file.exists()) {
                System.out.println("Already printed the tickets!");
                return false;
            }

            try {
                FileWriter myFile = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(myFile);
                buffer.write(id + "'s check in baggage ticket " + (i+1) + "\n");

                /* Call the airport backend system to get the number of the assigned bag drop counter.
                   Here we presuppose the number is 37. */
                int dropCounter = 37;
                buffer.write("Please take your check-in baggage to drop counter " + dropCounter + ".");
                buffer.close();
                myFile.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
