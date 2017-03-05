/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.security;

import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class FileReader {
    static ArrayList<User> getStoredUserArray(){
        ArrayList<User> arrStoredUser = new ArrayList<>();
        
        // Start reading the file
        ArrayList<Double> arrFingerLength = new ArrayList<>();
        arrFingerLength.add(7.0);
        arrFingerLength.add(7.8);
        arrFingerLength.add(8.6);
        arrFingerLength.add(8.1);
        arrFingerLength.add(7.0);
        
        ArrayList<Double> arrFingerWidth = new ArrayList<>();
        arrFingerWidth.add(2.3);
        arrFingerWidth.add(2.0);
        arrFingerWidth.add(2.2);
        arrFingerWidth.add(2.1);
        arrFingerWidth.add(1.9);
        
        User user = new User(
                new HandMeasurements(arrFingerLength, arrFingerWidth),
                "Prasanna Deshappriya"
        );
        
        arrStoredUser.add(user);
        // Finish reading
        
        return arrStoredUser;
    }
    
    static double getThresholdValue(){
        //Get the threshold value from the settings file
        //Read the file
        return 0.95;
    }
}
