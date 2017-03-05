/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class TextFileReader {
    static void init(){
        //check for settings.txt (it contains the user define threshold value)
        File f = new File("settings.txt");
        try {
            if(!f.exists()){
                //file does not exist
                FileWriter writer = new FileWriter("settings.txt", true);
                writer.write("0.95");
                //writer.write("\r\n");   // write new line
                //writer.write("Good Bye!");
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());;
        }
        
    }
    
    static void store(User user){
        try {
            FileWriter writer = new FileWriter("user.txt", true);
            writer.write(user.getFull_name());
            writer.write("\r\n");   // write new line
            writer.close();
            writer = new FileWriter(user.getFull_name().replace(" ", "").replace(".", "") + ".txt", true);
            ArrayList<Double> arrFingerLength = user.getHandMeasurements().getFingerLengthArray();
            for(double value : arrFingerLength){
                writer.write(Double.toString(value));
                writer.write("\r\n");   // write new line
            }
            ArrayList<Double> arrFingerWidth = user.getHandMeasurements().getFingerWidthArray();
            for(double value : arrFingerWidth){
                writer.write(Double.toString(value));
                writer.write("\r\n");   // write new line
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private static ArrayList<String> getUserNames(){
        File f = new File("user.txt");
        ArrayList<String> ret = new ArrayList<>();
        try {
            if(f.exists()){
                FileReader reader = new FileReader("user.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    ret.add(line);
                }
                reader.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ret;
    }
    
    static ArrayList<User> getStoredUserArray(){
        ArrayList<String> userNamesArr = getUserNames();
        ArrayList<User> userArr = new ArrayList<>();
        
        if(!userNamesArr.isEmpty()){
            for(int i=0;i<userNamesArr.size();i++){
                ArrayList<Double> fingerLengthArr = new ArrayList<>();
                ArrayList<Double> fingerWidthArr = new ArrayList<>();
                File f = new File(userNamesArr.get(i).replace(" ", "").replace(".", "") +".txt");
                if(f.exists()){
                    try{
                        FileReader reader = new FileReader(userNamesArr.get(i).replace(" ", "").replace(".", "") +".txt");
                        BufferedReader bufferedReader = new BufferedReader(reader);

                        String line;
                        int count=1;
                        while ((line = bufferedReader.readLine()) != null) {
                            if(count<=5){
                                fingerLengthArr.add(Double.parseDouble(line));
                            }else{
                                fingerWidthArr.add(Double.parseDouble(line));
                            }
                            count++;
                        }
                        reader.close();
                        userArr.add(
                                new User(
                                        new HandMeasurements(fingerLengthArr, fingerWidthArr),
                                        userNamesArr.get(i)
                                )
                        );
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
            return userArr;
        }else{
            return null;
        }
    }
    
    static double getThresholdValue(){
        //Get the threshold value from the settings file
        //Read the file
        try{
            FileReader reader = new FileReader("settings.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            ArrayList<String> arrInput = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrInput.add(line);
            }
            reader.close();

            return Double.parseDouble(arrInput.get(0));
        }catch(Exception e){
            System.out.println("Exception :- " + e.toString());
        }
        return 0.0;
    }
}
