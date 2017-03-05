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
    ArrayList<Float> arrFingerLength = new ArrayList<>();
    ArrayList<Float> arrFingerWidth = new ArrayList<>();

    public HandMeasurements(ArrayList<Float> arrFingerLength,
                            ArrayList<Float> arrFingerWidth) {
        this.arrFingerLength = arrFingerLength;
        this.arrFingerWidth = arrFingerWidth;
    }
    
    ArrayList<Float> getFingerLengthArray(){
        return arrFingerLength;
    }
    
    ArrayList<Float> getFingerWidthArray(){
        return arrFingerWidth;
    }
}
