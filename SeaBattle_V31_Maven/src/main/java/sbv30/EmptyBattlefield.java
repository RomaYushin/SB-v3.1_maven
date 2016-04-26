/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbv30;

import java.util.Map;

/**
 *
 * @author Roman
 */
public class EmptyBattlefield {
    
    public static Map<String, Integer> createOfBattlefield(Map<String, Integer> battlefield) {

        //Map<String, Integer> battlefield = new HashMap<String, Integer>();

        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                battlefield.put(s, 0);
            }
        }
        return battlefield;
    }
}
