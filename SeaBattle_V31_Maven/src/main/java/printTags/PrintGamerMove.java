/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTags;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Roman
 */
public class PrintGamerMove extends SimpleTagSupport {
    
    boolean isGamerHit;

    public boolean isIsGamerHit() {
        return isGamerHit;
    }

    public void setIsGamerHit(boolean isGamerHit) {
        this.isGamerHit = isGamerHit;
    }
    
    
    
}
