/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletController;

import java.util.ArrayList;
import sbv30.GamerInputAndOutput;
import sbv30.CompInputAndOutput;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sbv30.CompInputAndOutput2;
import sbv30.EmptyBattlefield;
import sbv30.PreparationComputer;
import sbv30.PreparationGamer;

/**
 *
 * @author Roman
 */
public class ActionParser {  
        
    static Map <String, Integer> battlefieldGamer;
    static Map <String, Integer> battlefieldComp;
    static Map <String, Integer> usedBattlefieldGamer;
    static Map <String, Integer> usedBattlefieldComp;
    static ArrayList<String> compInputWound;
    
    public static String doParsingByParameter (HttpServletRequest request, HttpServletResponse response) {
        
        String action = request.getParameter("action"); 
        
        if (action == null) {
            return PagesPath.ERROR;
        }
        
        switch (action) {
            case "INDEX":                
                return PagesPath.INDEX;
            case "PREPARATION_VS_COMPUTER":          
                // создание пустого поля игрока
                battlefieldGamer = PreparationGamer.getBattlefieldGamer();
                battlefieldGamer = EmptyBattlefield.createOfBattlefield(battlefieldGamer);
                request.setAttribute("battlefieldGamer", battlefieldGamer);
                
                //создание пустого поля компьютера
                battlefieldComp = PreparationComputer.getBattlefieldComp();
                battlefieldComp = EmptyBattlefield.createOfBattlefield(battlefieldComp);
                request.setAttribute("battlefieldComp", battlefieldComp);
                
                // возвращаем страничку preparation_VS_computer.jsp
                return PagesPath.PREPARATION_VS_COMPUTER;
                
            case "PREPARATION_VS_SECOND_GAMER":    
                // Данного фукционала в версии 3.0 не существует
                return PagesPath.PREPARATION_VS_SECOND_GAMER;
                
            case "ARRANGE_SHIPS_RANDOMLY": 
                // подготовка игрока
                battlefieldGamer = PreparationGamer.preparationBattlefieldGamer(battlefieldGamer);
                GamerInputAndOutput.setGamerHit(true);
                request.setAttribute("battlefieldGamer", battlefieldGamer);  
                
                usedBattlefieldGamer = PreparationGamer.getUsedBattlefieldGamer();
                usedBattlefieldGamer = EmptyBattlefield.createOfBattlefield(usedBattlefieldGamer);    
                request.setAttribute("usedBattlefieldGamer", usedBattlefieldGamer);
                
                // устанавливаем, что победитель не определен
                GamerInputAndOutput.setWinner(false);
         
                // подготовка компьютера                     
                battlefieldComp = PreparationComputer.preparationBattlefieldComp(battlefieldComp);          
                usedBattlefieldComp = PreparationComputer.getUsedBattlefieldComp();
                usedBattlefieldComp = EmptyBattlefield.createOfBattlefield(usedBattlefieldComp);
                request.setAttribute("usedBattlefieldComp", usedBattlefieldComp);
                
                // удаляем содержимое коллекции сompInputWound
                CompInputAndOutput2.clearCompInputWound();
                
                // устанавливаем, что победитель не определен
                CompInputAndOutput.setWinner(false);
                
                // возвращаем страничку preparation_VS_computer.jsp
                return PagesPath.ARRANGE_SHIPS_RANDOMLY;  
                
            case "GAME":
                // добавляем коллекции в атрибуты сервлета
                request.setAttribute("battlefieldGamer", battlefieldGamer);
                request.setAttribute("usedBattlefieldGamer", usedBattlefieldGamer);
                request.setAttribute("battlefieldComp", battlefieldComp);
                request.setAttribute("usedBattlefieldComp", usedBattlefieldComp);
                
                // возвращаем страничку game.jsp
                return PagesPath.GAME;
                
            case "GAMER_MOVE":
                String id = request.getParameter("id");
                System.out.println("Роман сделал свой ход (id):  " + id);                
                        
                usedBattlefieldComp = GamerInputAndOutput.gamerMove(id, battlefieldComp, usedBattlefieldComp);
                request.setAttribute("usedBattlefieldComp", usedBattlefieldComp);
                return PagesPath.COMPUTER_BATTLEFIELD;
            case "COMP_MOVE":                
                compInputWound = CompInputAndOutput2.getCompInputWound();
                switch (compInputWound.size()) {
                    case 0:
                        usedBattlefieldGamer = CompInputAndOutput.compMoveRandom(battlefieldGamer, usedBattlefieldGamer, compInputWound);
                        break;
                    case 2:
                        usedBattlefieldGamer = CompInputAndOutput.compMoveAfterFirstHit(battlefieldGamer, usedBattlefieldGamer, compInputWound);
                        break;
                    case 3:
                        usedBattlefieldGamer = CompInputAndOutput.compMoveAfterSecondHit(battlefieldGamer, usedBattlefieldGamer, compInputWound);
                        break;
                    case 4:
                        usedBattlefieldGamer = CompInputAndOutput.compMoveAfterThirdHit(battlefieldGamer, usedBattlefieldGamer, compInputWound);
                        break;
                }             
                
                request.setAttribute("usedBattlefieldGamer", usedBattlefieldGamer);
                return PagesPath.GAMER_BATTLEFIELD;
        }        
        return PagesPath.ERROR;
    }    
}
