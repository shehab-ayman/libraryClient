/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

/**
 *
 * @author Shehab
 */
public class temprature {
    
    ResponseBody test;
    
    public float getResult() {
        return test.TEMPERATURE;
    }
    
    class ResponseBody {
        float TEMPERATURE;
    }
    
}
