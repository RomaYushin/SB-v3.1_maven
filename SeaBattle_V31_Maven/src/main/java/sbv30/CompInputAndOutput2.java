/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbv30;

import java.util.ArrayList;

/**
 *
 * @author Roman
 */
public class CompInputAndOutput2 {
    /**
     *
     */
    
    private static ArrayList<String> compInputWound;
    
    public static ArrayList<String> getCompInputWound() {
        //compInputWound = new ArrayList<>();
        if (compInputWound == null) {
            compInputWound = new ArrayList<>();
        }
        return compInputWound;
    }

    public static void setCompInputWound(ArrayList<String> compInputWound) {
        CompInputAndOutput2.compInputWound = compInputWound;
    }
    
    public static void clearCompInputWound(){
        CompInputAndOutput2.getCompInputWound();
        CompInputAndOutput2.compInputWound.clear();
    }
    
}
