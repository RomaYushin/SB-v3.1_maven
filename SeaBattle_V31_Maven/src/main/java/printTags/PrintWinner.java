/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printTags;

import java.io.IOException;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Roman
 */
public class PrintWinner extends SimpleTagSupport {
   
    private Map<String, Integer> usedBattlefieldComp;

    public Map<String, Integer> getUsedBattlefieldComp() {
        return usedBattlefieldComp;
    }

    public void setUsedBattlefieldComp (Map<String, Integer> usedBattlefieldComp) {
        this.usedBattlefieldComp = usedBattlefieldComp;
    }

    @Override
    public void doTag() throws JspException, IOException {
        
        JspWriter jspOut = getJspContext().getOut(); 
        int counter = usedBattlefieldComp.get("A2");
        
        if (usedBattlefieldComp.get("A1") == 2) {
            jspOut.println("<p> TRIUMPH !!! </p> ");  
            jspOut.println("<p> COMPUTER FLEET SUNK BY " + counter + " STROKES! </p> ");
        }
    }
    
    
}
