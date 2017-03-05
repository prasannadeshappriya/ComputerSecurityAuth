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
public class SearchEngine {
    //Search User for given HandMeasurements
    private final HandMeasurements handMeasurements;
    
    public SearchEngine(HandMeasurements measurements) {
        this.handMeasurements = measurements;
    }
    
    public User getUser(){
        //if user exist for given handmeasurements this will return the user model
        //else null will be returned
        
        //get all stored users
        ArrayList<User> arrStoredUserArr = TextFileReader.getStoredUserArray();
        
        //get threshold value
        double thresold = TextFileReader.getThresholdValue();
        
        //if file does not contain any users, return null
        if(arrStoredUserArr.isEmpty()){return null;}
        
        //Variables for return
        User retUser = null;
        Double retConfidence = 0.0;
        
        for(User user:arrStoredUserArr){
            double confidence = calculateConfidence(user.getHandMeasurements());
            
            //print the confidence value
            System.out.println("User :- " + user.getFull_name() + 
                                ", Confidence Value :- " + Double.toString(confidence) + 
                                ", Threshold Value :- " + Double.toString(thresold));
            
            if(confidence>=thresold){
                if(retUser==null){
                    retUser=user;
                    retConfidence=confidence;
                }else{
                    if(retConfidence<confidence){
                        retUser=user;
                        retConfidence=confidence;
                    }
                }
            }
        }
        
        return retUser;
    }
    
    private double calculateConfidence(HandMeasurements measurements){
        // Algorithm for calculate confidence
        // ratio = (input values)/(stored values)
        // get the sum of ratios and find the confidence by calculating the average
        
        //get the stored values
        ArrayList<Double> arrStoredUserFingerLength = measurements.getFingerLengthArray();
        ArrayList<Double> arrStoredUserFingerWidth = measurements.getFingerWidthArray();
        
        //get the input values
        ArrayList<Double> arrInputFingerLength = handMeasurements.getFingerLengthArray();
        ArrayList<Double> arrInputFingerWidth = handMeasurements.getFingerWidthArray();
        
        double ratioSum = 0.0;
        double measumentCount = arrInputFingerLength.size() + arrInputFingerWidth.size();
        
        for(int i=0; i<arrStoredUserFingerLength.size();i++){
            ratioSum+=calculateRatio(
                    arrStoredUserFingerLength.get(i),
                    arrInputFingerLength.get(i)
            );
        }
        
        for(int i=0; i<arrStoredUserFingerWidth.size();i++){
            ratioSum+=calculateRatio(
                    arrStoredUserFingerWidth.get(i),
                    arrInputFingerWidth.get(i)
            );
        }
        
        return (Double.isNaN(ratioSum)) ? 0.0 : (ratioSum/measumentCount);
    }
    
    private double calculateRatio(double storedValue, double inputValue){
        //calculate the ratio (ratio < 1)
        return ((storedValue/inputValue)>1) ? 
                (inputValue/storedValue) : 
                (storedValue/inputValue);
    }
    
    
}
