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
import sbv30.PreparationGamer;

/**
 *
 * @author Roman
 */
public class PrintUsedBattlefieldGamer extends SimpleTagSupport {

    private Map<String, Integer> usedBattlefieldGamer;
    private Map<String, Integer> battlefieldGamer;

    public Map<String, Integer> getUsedBattlefieldGamer() {
        return usedBattlefieldGamer;
    }

    public void setUsedBattlefieldGamer(Map<String, Integer> usedBattlefieldGamer) {
        this.usedBattlefieldGamer = usedBattlefieldGamer;
    }

    public Map<String, Integer> getBattlefieldGamer() {
        return battlefieldGamer;
    }

    public void setBattlefieldGamer(Map<String, Integer> battlefieldGamer) {
        this.battlefieldGamer = battlefieldGamer;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String valueOfCaseGamer = null;
        boolean hit = CompInputAndOutput.isCompHit();
        boolean winner = CompInputAndOutput.isWinner();
        //System.out.println(" winner  in PrintUsedBattlefieldGamer" + winner );
        battlefieldGamer = PreparationGamer.getBattlefieldGamer();

        //System.out.println("battlefieldGamer  from class  PrintUsedBattlefieldGamer:    " + battlefieldGamer);
        //System.out.println("usedBattlefieldGamer  from class  PrintUsedBattlefieldGamer:    " + usedBattlefieldGamer);

        JspWriter jspOut = getJspContext().getOut();
        /*
        if (hit) {
            jspOut.println("<table id=\"isCompHitTrue\">");
        } else {
            jspOut.println("<table id=\"isCompHitFalse\">");
        }
        */
        
        
        if (hit) {
            jspOut.println("<div id = \"nextMoveBG\" name = \"comp\">");
        } else {
            jspOut.println("<div id = \"nextMoveBG\" name = \"gamer\">");
        }
        jspOut.println("</div>");
        
        if (winner) {
            jspOut.println("<table id = \"compWin\">");
        } else {
            jspOut.println("<table>");
        }
        
        //jspOut.println("<table>");
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

        for (int i = 1; i <= 10; i++) {
            jspOut.println("<tr><td class = \"left-column\">" + i + "</td>");
            for (int j = 65; j <= 74; j++) {
                valueOfCaseGamer = Character.toString((char) j) + i;

                // если компьютер еще не стрелял по этой координате то if в противном случае else
                if (usedBattlefieldGamer.get(valueOfCaseGamer) == 0) {
                    if (battlefieldGamer.get(valueOfCaseGamer) > 100) {
                        jspOut.println("<td class = \"yesShip\"id =" + valueOfCaseGamer + "></td>");
                        continue;
                    } else if ((battlefieldGamer.get(valueOfCaseGamer) < 100 & battlefieldGamer.get(valueOfCaseGamer) > 10) | battlefieldGamer.get(valueOfCaseGamer) == 0) {
                        jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                        continue;
                    }
                } else {
                    if (usedBattlefieldGamer.get(valueOfCaseGamer) > 100) {
                        jspOut.println("<td class = \"yesShip\"id =" + valueOfCaseGamer + "><img src=\"images/cross_15x15.png\"></td>");
                        continue;
                    } else if (usedBattlefieldGamer.get(valueOfCaseGamer) < 100 && usedBattlefieldGamer.get(valueOfCaseGamer) > 10) {
                        jspOut.println("<td class = \"yesLimit\"id =" + valueOfCaseGamer + "><img src=\"images/point_7x7.png\"></td>");
                    } else if (usedBattlefieldGamer.get(valueOfCaseGamer) == 1) {
                        jspOut.println("<td class = \"yesLimit\" id =" + valueOfCaseGamer + "><img src=\"images/point_7x7.png\"></td>");
                    }
                }                
            }
            jspOut.println("</tr>");
        }
        jspOut.println("</table>");  
    }

}

// <img src='../images/cross_15x15.png'>

/*
        if (!usedBattlefieldGamer.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                jspOut.println("<tr><td class = \"left-column\">" + i + "/<td>");
                for (int j = 65; j <= 74; j++) {
                    valueOfCaseGamer = Character.toString((char) j) + i;
                    if (usedBattlefieldGamer.get(valueOfCaseGamer) > 100) {
                        jspOut.println("<td class = \"yesShip\" id =" + valueOfCaseGamer + "></td>");
                    } else if (usedBattlefieldGamer.get(valueOfCaseGamer) < 100 & usedBattlefieldGamer.get(valueOfCaseGamer) > 10) {
                        jspOut.println("<td class = \"yesLimit\" id =" + valueOfCaseGamer + "></td>");
                    } else if (usedBattlefieldGamer.get(valueOfCaseGamer) == 0) {
                        jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                    }
                }
                jspOut.println("</tr>");
            }
        } else {
            //System.out.println(" PrintUsedBattlefieldGamer ");

            for (int i = 1; i <= 10; i++) {
                jspOut.println("<tr><td class = \"left-column\">" + i + "</td>");
                for (int j = 65; j <= 74; j++) {
                    valueOfCaseGamer = Character.toString((char) j) + i;
                    jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                }
                jspOut.println("</tr>");
            }           
        }


*****************************************************************************************************************************************************************



if (battlefieldGamer.get(valueOfCaseGamer) > 100
                        && usedBattlefieldGamer.get(valueOfCaseGamer) > 100) {
                    jspOut.println("<td class = \"yesShip\"id =" + valueOfCaseGamer + "><img src=\"images/cross_15x15.png\"></td>");
                    continue;
                } else if (battlefieldGamer.get(valueOfCaseGamer) > 100) {
                    jspOut.println("<td class = \"yesShip\"id =" + valueOfCaseGamer + "></td>");
                    continue;
                } else if ((usedBattlefieldGamer.get(valueOfCaseGamer) < 100 && usedBattlefieldGamer.get(valueOfCaseGamer) > 10)
                        & (battlefieldGamer.get(valueOfCaseGamer) < 100 && battlefieldGamer.get(valueOfCaseGamer) > 10)) {
                    jspOut.println("<td class = \"yesLimit\"id =" + valueOfCaseGamer + "><img src=\"images/point_7x7.png\"></td>");
                    continue;
                } else if (battlefieldGamer.get(valueOfCaseGamer) < 100 & battlefieldGamer.get(valueOfCaseGamer) > 10) {
                    jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                    continue;
                } else if (usedBattlefieldGamer.get(valueOfCaseGamer) == 0 && battlefieldGamer.get(valueOfCaseGamer) == 0) {
                    jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                    continue;
                } else if (battlefieldGamer.get(valueOfCaseGamer) == 0) {
                    jspOut.println("<td id =" + valueOfCaseGamer + "></td>");
                    continue;
                }*/
