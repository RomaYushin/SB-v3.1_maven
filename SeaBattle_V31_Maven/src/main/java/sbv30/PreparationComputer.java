/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbv30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roman
 */
public class PreparationComputer {
    
    private static Map<String, Integer> battlefieldComp;
    
    private static Map<String, Integer> usedBattlefieldComp;   

    private PreparationComputer() {
    }
    
    public static synchronized  Map<String, Integer> getBattlefieldComp() {
        if (battlefieldComp== null) {
            battlefieldComp = new HashMap <String, Integer> ();
        }
        return battlefieldComp; 
    }
    
    public static synchronized  Map<String, Integer> getUsedBattlefieldComp() {
        if (usedBattlefieldComp == null) {
            usedBattlefieldComp = new HashMap <String, Integer> ();
        }
        return usedBattlefieldComp; 
    }
    
    public static Map<String, Integer> preparationBattlefieldComp (Map<String, Integer> battlefieldComp) {
        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ КОМПЬЮТЕРА  ------------------------------
        // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции
        battlefieldComp = EmptyBattlefield.createOfBattlefield(battlefieldComp);
        //System.out.println("Поле игры ИГРОКА сформировано.");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Comp = new Deck4(new int[]{451, 452, 453, 454}, 45);
        battlefieldComp = deck4Comp.genCoordDeck4(battlefieldComp); // установка координат корабля
        battlefieldComp = deck4Comp.genLimitCoordDeck4(battlefieldComp); // установка координат границы корабля
        //System.out.println("Информационное сообщение: 4-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Comp = new Deck3(new int[]{351, 352, 353}, 35, 1);
        deck3_1Comp.genCoordDeck3(battlefieldComp);
        deck3_1Comp.genLimitCoordDeck3(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck3 deck3_2Comp = new Deck3(new int[]{361, 362, 363}, 36, 2);
        deck3_2Comp.genCoordDeck3(battlefieldComp);
        deck3_2Comp.genLimitCoordDeck3(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Comp = new Deck2(new int[]{251, 252}, 25, 1);
        deck2_1Comp.genCoordDeck2(battlefieldComp);
        deck2_1Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_2Comp = new Deck2(new int[]{261, 262}, 26, 2);
        deck2_2Comp.genCoordDeck2(battlefieldComp);
        deck2_2Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_3Comp = new Deck2(new int[]{271, 272}, 27, 3);
        deck2_3Comp.genCoordDeck2(battlefieldComp);
        deck2_3Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: третий 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Comp = new Deck1(new int[]{151}, 15, 1);
        deck1_1Comp.genCoordDeck1(battlefieldComp);
        deck1_1Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_2Comp = new Deck1(new int[]{161}, 16, 2);
        deck1_2Comp.genCoordDeck1(battlefieldComp);
        deck1_2Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_3Comp = new Deck1(new int[]{171}, 17, 3);
        deck1_3Comp.genCoordDeck1(battlefieldComp);
        deck1_3Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: третий 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_4Comp = new Deck1(new int[]{181}, 18, 4);
        deck1_4Comp.genCoordDeck1(battlefieldComp);
        deck1_4Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");
        System.out.println("   !!! КОРАБЛИ КОМПЬЮТЕРА РАССТАВЛЕНЫ !!!   ");

        return battlefieldComp;
    }
   
}
