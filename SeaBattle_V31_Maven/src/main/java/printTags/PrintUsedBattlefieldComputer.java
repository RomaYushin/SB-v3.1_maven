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
import sbv30.CompInputAndOutput;
import sbv30.GamerInputAndOutput;
import sbv30.PreparationComputer;
import sbv30.PreparationGamer;

/**
 *
 * @author Roman
 */
public class PrintUsedBattlefieldComputer extends SimpleTagSupport {

    private Map<String, Integer> usedBattlefieldComp;

    public Map<String, Integer> getUsedBattlefieldComp() {
        return usedBattlefieldComp;
    }

    public void setUsedBattlefieldComp (Map<String, Integer> usedBattlefieldComp) {
        this.usedBattlefieldComp = usedBattlefieldComp;
    }
    

    @Override
    public void doTag() throws JspException, IOException {
        String valueOfCaseGamer = null;
        boolean hit = GamerInputAndOutput.isGamerHit();
        boolean winner = GamerInputAndOutput.isWinner();
        boolean alreadyShoot = GamerInputAndOutput.isAlreadyShoot();
        //System.out.println(" winner in PrintUsedBattlefieldComputer" + winner);
        
        //System.out.println("usedBattlefieldComp  from class  PrintUsedBattlefieldComputer:    " + usedBattlefieldComp);
        
        JspWriter jspOut = getJspContext().getOut();        
        //System.out.println("usedBattlefieldComp:   " + usedBattlefieldComp);        
     
        /*
        if (hit) {
            jspOut.println("<table id=\"isGamerHitTrue\">");
        } else {
            jspOut.println("<table id=\"isGamerHitFalse\">");
        }
        */
        
        if (hit) {
            jspOut.println("<div id = \"nextMoveCG\" name = \"gamer\">");
        } else {
            jspOut.println("<div id = \"nextMoveCG\" name = \"comp\">");
        }
        jspOut.println("</div>");
        
        if (winner) {
            jspOut.println("<table id = \"gamerWin\">");
        } else if (alreadyShoot){
            jspOut.println("<table id = \"alreadyShoot\">");
        } else {
            jspOut.println("<table>");
        }
        
        jspOut.println("<tr>");
        jspOut.println("<th></th>");
        jspOut.println("<th>A</th>");
        jspOut.println("<th>B</th>");
        jspOut.println("<th>C</th>");
        jspOut.println("<th>D</th>");
        jspOut.println("<th>E</th>");
        jspOut.println("<th>F</th>");
        jspOut.println("<th>G</th>");
        jspOut.println("<th>H</th>");
        jspOut.println("<th>I</th>");
        jspOut.println("<th>J</th>");
        jspOut.println("</tr>");
        for (int i = 1; i <= 10; i++) {
                jspOut.println("<tr><td class = \"left-column\">" + i + "</td>");
                for (int j = 65; j <= 74; j++) {
                    valueOfCaseGamer = Character.toString((char) j) + i;
                    if (usedBattlefieldComp.get(valueOfCaseGamer) > 100) {
                        jspOut.println("<td class = \"yesShip\" id =" + valueOfCaseGamer + "><img src=\"images/cross_15x15.png\"></td>");
                    } else if (usedBattlefieldComp.get(valueOfCaseGamer) < 50 & usedBattlefieldComp.get(valueOfCaseGamer) > 10 ) {
                        jspOut.println("<td class = \"yesLimit\" id =" + valueOfCaseGamer + "><img src=\"images/point_7x7.png\"></td>");
                    } else if (usedBattlefieldComp.get(valueOfCaseGamer) == 1) {
                        jspOut.println("<td class = \"yesLimit\" id =" + valueOfCaseGamer + "><img src=\"images/point_7x7.png\"></td>");
                    } else if (usedBattlefieldComp.get(valueOfCaseGamer) == 0) {
                        jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                    }
                }
                jspOut.println("</tr>");
            }
        jspOut.println("</table>");        
    }
}
