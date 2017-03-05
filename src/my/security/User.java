/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.security;

/**
 *
 * @author prasanna
 */
public class User {
    //user model
    private final HandMeasurements handMeasurements;
    private final String full_name;

    public User(HandMeasurements handMeasurements, String full_name) {
        this.handMeasurements = handMeasurements;
        this.full_name = full_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public HandMeasurements getHandMeasurements() {
        return handMeasurements;
    }
    
}
