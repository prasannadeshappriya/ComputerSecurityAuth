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
public class HandMeasurements {
    private ArrayList<Double> arrFingerLength = new ArrayList<>();
    private ArrayList<Double> arrFingerWidth = new ArrayList<>();
    
    //---------Array Order -------------
    //-----> Thumb Length	
    //-----> Index Finger Length	
    //-----> Middle Finger Length 
    //-----> Ring Finger Length	
    //-----> Pinkie Finger length
   
    public HandMeasurements(ArrayList<Double> arrFingerLength,
                            ArrayList<Double> arrFingerWidth) {
        this.arrFingerLength = arrFingerLength;
        this.arrFingerWidth = arrFingerWidth;
    }
    
    ArrayList<Double> getFingerLengthArray(){
        return arrFingerLength;
    }
    
    ArrayList<Double> getFingerWidthArray(){
        return arrFingerWidth;
    }
}
