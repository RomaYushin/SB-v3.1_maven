/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbv30;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Роман on 15.10.2015.
 * Описания игры "МОРСКОЙ БОЙ".
 * Игры создана по аналогии с игрой "МОРСКОЙ БОЙ" на листке бумаги, в которую, наверное, играли все школьники в детстве.
 * Правила игры аналогичны. В данной версии программы игрок играет только с компьютером и у него нет возможности
 * расставлять корабли по своему усмотрению. За него это делает компьютер. Поле игры выглядит следующим образом:
 *     A  B  C  D  E  F  G  H  I  J
 *  1
 *  2
 *  3
 *  4
 *  5
 *  6
 *  7
 *  8
 *  9
 *  10
 *
 * Реализаци программы. В игре есть две ключевых Map коллекции: battlefieldGamer и battlefieldComp. В качестве ключей
 * в этих коллекциях - координаты кораблей, координаты границ кораблей, координаты пустых клеток, где нет ни кораблей,
 * ни границ кораблей, всего 100 значений. Плюс в нее добавлены вспомогательные ключи для генерации координат границ
 * кораблей. Соответственно коллекция battlefieldGamer хранит значения игрока, а battlefieldComp хранит значения
 * компьютера.
 * В качестве значений (value) используются числа, характерезующие конкретный корабль. Своего рода код. Когда игрок
 * выполняем ход, то введенная им координата есть в коллекции battlefieldComp. Мы проверяем, какое же число (value)
 * находиться под этой координатой. Получаем результат - "МИМО", "Ранил", "Потопил". Если все корабли потоплены,
 * выводиться сообщение о попеде.
 * Все уже использованные "стреляные" игроком координаты вносяться в коллекцию  usedBattlefieldComp. После каждого хода
 * игроком происходит проверка на наличие введенной координаты в этой коллекции. Если условие выполняется, выводиться
 * сообщение об ошибке и предлагается выполнить повторных ход.
 * У компьютера сооответственно это коллекция usedBattlefieldGamer.
 *
 * Данная версия программы выполнена без визуализации, что крайне затрудняет игру. Визуализация будет реализована в
 * будущих версиях игры.
 *
 * Теперь опишу числа, которые храняться в значении value
 * Однопалубные корабли:
 * 111 (151) - первый однопалубный корабль игрока (компьютера)
 * 121 (161) - второй однопалубный корабль игрока (компьютера)
 * 131 (171) - третий однопалубный корабль игрока (компьютера)
 * 141 (181) - четверный однопалубный корабль игрока (компьютера)
 *
 * 11 (15) - граница первого однопалубного корабля игрока (компьютера)
 * 12 (16) - граница второго однопалубного корабля игрока (компьютера)
 * 13 (17) - граница третьего однопалубного корабля игрока (компьютера)
 * 14 (18) - граница четвертого однопалубного корабля игрока (компьютера)
 *
 * Двухпалубные корабли:
 * 211, 212 (251, 252) - первое, второе значение координаты для первого двухпалубного корабля  игрока (компьютера)
 * 221, 222 (261, 262) - первое, второе значение координаты для второго двухпалубного корабля  игрока (компьютера)
 * 231, 232 (271, 272) - первое, второе значение координаты для третьего двухпалубного корабля  игрока (компьютера)
 *
 * 21 (25) - граница первого двухпалубного корабля игрока (компьютера)
 * 22 (26) - граница второго двухпалубного корабля игрока (компьютера)
 * 23 (27) - граница третьего двухпалубного корабля игрока (компьютера)
 *
 * Трехпалубные корабли:
 * 311, 312, 313 (351, 352, 353) - первое, второе, третье значение координаты для первого трехпалубного корабля игрока (компьютера)
 * 321, 322, 323 (361, 362, 363) - первое, второе, третье значение координаты для второго трехпалубного корабля игрока (компьютера)
 *
 * 31 (35) - граница первого трехпалубного корабля игрока (компьютера)
 * 32 (36) - граница второго трехпалубного корабля игрока (компьютера)
 *
 * Четырехпалубные корабли:
 * 411, 412, 413, 414 (451, 452, 453, 454) -
 * первое, второе, третье, четвертое значение координаты для четырехпалубного корабля игрока (компьютера)
 *
 * 41 (45) - граница первого трехпалубного корабля игрока (компьютера)
 *
 * Пустые клетки:
 * 0 - значение, которое показывает, что по данной координате не храняться ни корабли ни граничные значения
 *
 * Вспомогательные ключи для однопалубных кораблей:
 * firstRandomNumberForLetter_deck1
 * randomNumberForNumber_deck1
 * firstCoord_deck1
 *
 * Вспомогательные ключи для двухпалубных кораблей:
 * firstRandomNumberForLetter_deck2
 * firstRandomNumberForNumber_deck2
 * secondRandomNumberForLetter_deck2
 * secondRandomNumberForNumber_deck2
 * randomNumberForNumber_deck2
 * randomNumberForLetter_deck2
 * "positionOfDeck2"
 * "firstCoord_deck2"
 * "secondCoord_deck2"
 *
 * Вспомогательные ключи для трехпалубных кораблей:
 * firstRandomNumberForLetter_deck3
 * firstRandomNumberForNumber_deck3
 * secondRandomNumberForLetter_deck3
 * secondRandomNumberForNumber_deck3
 * thirdRandomNumberForLetter_deck3
 * thirdRandomNumberForNumber_deck3
 * randomNumberForNumber_deck2
 * randomNumberForLetter_deck3
 * "positionOfDeck2"
 * "firstCoord_deck2"
 * "secondCoord_deck2"
 *
 * Вспомогательное ключи для четырехпалубного корабля
 * firstRandomNumberForLetter_4deck
 * firstRandomNumberForNumber_4deck
 * secondRandomNumberForLetter_4deck
 * secondRandomNumberForNumber_4deck
 * thirdRandomNumberForLetter_4deck
 * thirdRandomNumberForNumber_4deck
 * fourthRandomNumberForLetter_4deck
 * fourthRandomNumberForNumber_4deck
 * randomNumberForNumber_4deck
 * randomNumberForLetter_4deck
 * positionOfDeck4
 * firstCoord_4deck
 * secondCoord_4deck
 * thirdCoord_4deck
 * fourthCoord_4deck
 *
 * К классах Deck1, Deck2, Deck3, Deck4 храняться дополнительные комментарии к методам,
 * которые используют приведенные выше значения
 */
public class PreparationGamer {
    
    private static Map<String, Integer> battlefieldGamer;
    
    private static Map<String, Integer> usedBattlefieldGamer;

    private PreparationGamer() {
    }
    
    public static synchronized  Map<String, Integer> getBattlefieldGamer() {
        if (battlefieldGamer == null) {
            battlefieldGamer = new HashMap <String, Integer> ();
        }
        return battlefieldGamer; 
    }
    
    public static synchronized  Map<String, Integer> getUsedBattlefieldGamer() {
        if (usedBattlefieldGamer == null) {
            usedBattlefieldGamer = new HashMap <String, Integer> ();
        }
        return usedBattlefieldGamer; 
    }   
    
    public static Map<String, Integer> preparationBattlefieldGamer(Map<String, Integer> battlefieldGamer) {
        // - Приветствие игрока. Дать возможность ввести имя игрока.

        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ ИГРОКА   ------------------------------
        // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции.
        battlefieldGamer = EmptyBattlefield.createOfBattlefield(battlefieldGamer);
        //System.out.println("Поле игры ИГРОКА сформировано.");
        //System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Gamer = new Deck4(new int[]{411, 412, 413, 414}, 41);
        battlefieldGamer = deck4Gamer.genCoordDeck4(battlefieldGamer); // установка координат корабля
        battlefieldGamer = deck4Gamer.genLimitCoordDeck4(battlefieldGamer); // установка координат границы корабля
        //System.out.println("Информационное сообщение: 4-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Gamer = new Deck3(new int[]{311, 312, 313}, 31, 1);
        deck3_1Gamer.genCoordDeck3(battlefieldGamer);
        deck3_1Gamer.genLimitCoordDeck3(battlefieldGamer);
        //System.out.println("Информационное сообщение: первый 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck3 deck3_2Gamer = new Deck3(new int[]{321, 322, 323}, 32, 2);
        deck3_2Gamer.genCoordDeck3(battlefieldGamer);
        deck3_2Gamer.genLimitCoordDeck3(battlefieldGamer);
        //System.out.println("Информационное сообщение: второй 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Gamer = new Deck2(new int[]{211, 212}, 21, 1);
        deck2_1Gamer.genCoordDeck2(battlefieldGamer);
        deck2_1Gamer.genLimitCoordDeck2(battlefieldGamer);
        //System.out.println("Информационное сообщение: первый 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_2Gamer = new Deck2(new int[]{221, 222}, 22, 2);
        deck2_2Gamer.genCoordDeck2(battlefieldGamer);
        deck2_2Gamer.genLimitCoordDeck2(battlefieldGamer);
        //System.out.println("Информационное сообщение: второй 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_3Gamer = new Deck2(new int[]{231, 232}, 23, 3);
        deck2_3Gamer.genCoordDeck2(battlefieldGamer);
        deck2_3Gamer.genLimitCoordDeck2(battlefieldGamer);
        //System.out.println("Информационное сообщение: третий 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Gamer = new Deck1(new int[]{111}, 11, 1);
        deck1_1Gamer.genCoordDeck1(battlefieldGamer);
        deck1_1Gamer.genLimitCoordDeck1(battlefieldGamer);
        //System.out.println("Информационное сообщение: первый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_2Gamer = new Deck1(new int[]{121}, 12, 2);
        deck1_2Gamer.genCoordDeck1(battlefieldGamer);
        deck1_2Gamer.genLimitCoordDeck1(battlefieldGamer);
        //System.out.println("Информационное сообщение: второй 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_3Gamer = new Deck1(new int[]{131}, 13, 3);
        deck1_3Gamer.genCoordDeck1(battlefieldGamer);
        deck1_3Gamer.genLimitCoordDeck1(battlefieldGamer);
        //System.out.println("Информационное сообщение: третий 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_4Gamer = new Deck1(new int[]{141}, 14, 4);
        deck1_4Gamer.genCoordDeck1(battlefieldGamer);
        deck1_4Gamer.genLimitCoordDeck1(battlefieldGamer);
        //System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        //System.out.println("");
        System.out.println("   !!! КОРАБЛИ ИГРОКА РАССТАВЛЕНЫ !!!   ");

        return battlefieldGamer;
    }
}
