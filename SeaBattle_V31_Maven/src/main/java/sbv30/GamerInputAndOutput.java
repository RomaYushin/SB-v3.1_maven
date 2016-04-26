/*
 * %W% %E% Yushin Roman (Юшин Роман)
 *
 * Copyright (c) since 2015 free programm.
 *
 *  Это программное обеспечение находиться в свободном доступе и любой может им воспользоваться. Разработчик
 *  данного программного обеспечения -  Юшин Роман, начинающий Java программист (yushin.khpi@gmail.com).
 *  Данное программное обеспечение разработано с целью самообучения.
 */
package sbv30;

import java.io.IOException;
import java.util.Map;

/**
 * Gamer - игрок Описание класса: данный класс предназначен для выполнения хода
 * игрока, передаче хода компьютеру в случае промаха или передаче хода классу
 * EndGame в случае победы игрока. В классе есть методы gamerMove,
 * gamerDeck1SinkOrWound.
 *
 * @version 2.5 06 April 2016
 * @author Roman Yushin (Роман Юшин)
 */
public class GamerInputAndOutput {

    /**
     * static private Map <String, Integer> limitCoordDeck1 - вспомогательня
     * коллекция в ключах (key) которой храняться координаты границ однопалубных
     * кораблей. В значениях (value) храняться соответствующие числа. После
     * того, как топиться однопалубный корабль, вызывается метод генерации
     * границ однопалубного корабля, чтобы полученные значения могли внести в
     * коллекцию коллекцию уже открытых (использованных) координат Map
     * usedBattlefieldGamer. Данная коллекция перезаписывается при каждом новом
     * потоплении однопалубного корабля.
     */
    static Map<String, Integer> limitCoordDeck1;

    /**
     * static private Map <String, Integer> limitCoordDeck2 - см комментарий к
     * коллекции limitCoordDeck1, отличие только в том, что это относиться к
     * двухпалубным кораблям.
     */
    static Map<String, Integer> limitCoordDeck2;

    /**
     * static private Map <String, Integer> limitCoordDeck3 - см комментарий к
     * коллекции limitCoordDeck1, отличие только в том, что это относиться к
     * трехпалубным кораблям.
     */
    static Map<String, Integer> limitCoordDeck3;

    /**
     * static private Map <String, Integer> limitCoordDeck4 - см комментарий к
     * коллекции limitCoordDeck1, отличие только в том, что это относиться к
     * четырехпалубному кораблю.
     */
    static Map<String, Integer> limitCoordDeck4;

    /**
     * int valueOfBattlefieldComp - хранит в себе число, характерезующее
     * координату, по которой "стрельнул" корабль Компьютер генерирует случайную
     * координату, например B3. Как узнать находиться ли там корабль, либо
     * компьютер промахнулся. Для этого смотрим, какое же число находиться в
     * коллекции battlefieldGamer (value) по координате B3. Там 411. Вот это
     * число мы заносим в данную переменную. Дополнительную информацию можно
     * получить в описании класса Main.
     */
    static int valueOfBattlefieldComp;

    /**
     * String gamerInput - переменная, хранящая в себе координу, которую ввел
     * игрок. Например A1, F5, J6...
     */
    //static String gamerInput = null;
    /**
     * int limitDeck1 - вспомогательная переменная, хранящая в себе число -
     * границу однопалубного корабля. Используется в качестве аргумента метода
     * compDeck1SinkOrWound.
     */
    static int limitDeck1;

    /**
     * int serialNumberOfDeck1 - переменная, хранящая в себе число - порядковый
     * номер однопалубного корабля. Т.к. однопалубных кораблей - четыре.
     */
    static int serialNumberOfDeck1;

    /**
     * int counter - счетчик количества сделанных ходов игрока. После того, как
     * все корабли будут потоплены будет выведено данное число на экран.
     */
    static int counter;
    
    /**
     * boolean gamerHit - переменная, которая определяет попадание игрока.
     * false - мимо, не попал, что означает передачу хода компьютеру
     * true - попал, что означает продолжение стрельбы игроком
     */
    private static boolean gamerHit;
    
    private static boolean winner;
    
    private static boolean alreadyShoot;

    public static boolean isGamerHit() {
        return gamerHit;
    }

    public static boolean isWinner() {
        return winner;
    }

    public static boolean isAlreadyShoot() {
        return alreadyShoot;
    }   

    public static void setGamerHit(boolean gamerHit) {
        GamerInputAndOutput.gamerHit = gamerHit;
    }

    public static void setWinner(boolean winner) {
        GamerInputAndOutput.winner = winner;
    }  

    /**
     * gamerMove - основной метод для данного класса. В нем делает свой ход
     * игрок, проверяет ноходиться ли по этой координате корабль компьютера,
     * либо игрок промахнулся. В зависимости от этого производяться дальнейшие
     * действия: передача хода компьютеру, либо повторный ход, либо вывод
     * сообщения о победе и передача действий методу EndGame.
     *
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении
     * кораблей игрока
     * @param battlefieldComp - коллекция, хранящая информацию о расположении
     * кораблей компьютера
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах КОМПЬЮТЕРА
     * @param usedBattlefieldComp - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах ИГРОКА
     * @param compInputWound - коллекция, хранящая информацию о раненом корабле.
     * @throws IOException
     */
    public static Map<String, Integer> gamerMove(String id, Map<String, Integer> battlefieldComp, Map<String, Integer> usedBattlefieldComp) {

        counter++;
        alreadyShoot = false;
        
        // проверяем, стрелял ли уже игрок по координате id
        if (usedBattlefieldComp.get(id) > 0) {
            System.out.println("РОМАН, ты уже стрелял по координате " + id);
            gamerHit = true;
            alreadyShoot = true;
            return usedBattlefieldComp;
        }

        // заносим в переменную valueOfBattlefieldComp значение value по введенной игроком координате (key)
        valueOfBattlefieldComp = (int) battlefieldComp.get(id);

        // добавляем новую координату в коллекцию "стреляных" координат.
        usedBattlefieldComp.put(id, valueOfBattlefieldComp);

        // ищем необходимое нам число, и соответствующий этому числу корабль.
        switch (valueOfBattlefieldComp) {
            case 0:
            case 15:
            case 16:
            case 17:
            case 18:
            case 25:
            case 26:
            case 27:
            case 35:
            case 36:
            case 45:
                System.out.println("Роман, МИМО!\n");
                usedBattlefieldComp.put(id, 1);
                gamerHit = false;
                return usedBattlefieldComp;
            case 151:
            case 161:
            case 171:
            case 181:
                switch (valueOfBattlefieldComp) {
                    case 151:
                        limitDeck1 = 15;
                        serialNumberOfDeck1 = 1;
                        break;
                    case 161:
                        limitDeck1 = 16;
                        serialNumberOfDeck1 = 2;
                        break;
                    case 171:
                        limitDeck1 = 17;
                        serialNumberOfDeck1 = 3;
                        break;
                    case 181:
                        limitDeck1 = 18;
                        serialNumberOfDeck1 = 4;
                        break;
                }
                usedBattlefieldComp = gamerDeck1SinkOrWound(usedBattlefieldComp, battlefieldComp, limitDeck1, serialNumberOfDeck1);
                usedBattlefieldComp = getWinner(usedBattlefieldComp);
                gamerHit = true;
                return usedBattlefieldComp;
            case 251:
            case 252:
            case 261:
            case 262:
            case 271:
            case 272:
                switch (valueOfBattlefieldComp) {
                    case 251:
                    case 252:
                        // Проверка потоплен ли корабль или подбит
                        if (usedBattlefieldComp.containsValue(251) && usedBattlefieldComp.containsValue(252)) {
                            System.out.println("РОМАН, ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ!\n");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(25, 1);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck2, 25);
                        } else {
                            System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                        }
                        break;
                    case 261:
                    case 262:
                        if (usedBattlefieldComp.containsValue(261) && usedBattlefieldComp.containsValue(262)) {
                            System.out.println("РОМАН, ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ!\n");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(26, 2);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck2, 26);
                        } else {
                            System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                        }
                        break;
                    case 271:
                    case 272:
                        if (usedBattlefieldComp.containsValue(271) && usedBattlefieldComp.containsValue(272)) {
                            System.out.println("РОМАН, ПОТОПЛЕН  ДВУХПАЛУБНЫЙ КОРАБЛЬ!\n");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(27, 3);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck2, 27);
                        } else {
                            System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                        }
                        break;
                }
                usedBattlefieldComp = getWinner(usedBattlefieldComp);
                gamerHit = true;
                return usedBattlefieldComp;
            case 351:
            case 352:
            case 353:
            case 361:
            case 362:
            case 363:
                switch (valueOfBattlefieldComp) {
                    case 351:
                    case 352:
                    case 353:
                        if (usedBattlefieldComp.containsValue(351) && usedBattlefieldComp.containsValue(352) && usedBattlefieldComp.containsValue(353)) {
                            System.out.println("РОМАН, ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ!\n");
                            // выводим границы корабля на экран
                            Deck3 deck3 = new Deck3(35, 1);
                            limitCoordDeck3 = deck3.genLimitCoordDeck3(battlefieldComp);

                            // добавляем границы корабля в массив usedGamerBattlefield
                            usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck3, 35);
                        } else {
                            System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                        }
                        break;
                    case 361:
                    case 362:
                    case 363:
                        if (usedBattlefieldComp.containsValue(361) && usedBattlefieldComp.containsValue(362) && usedBattlefieldComp.containsValue(363)) {
                            System.out.println("РОМАН, ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ №2!\n");
                            // выводим границы корабля на экран
                            Deck3 deck3 = new Deck3(36, 2);
                            limitCoordDeck3 = deck3.genLimitCoordDeck3(battlefieldComp);

                            // добавляем границы корабля в массив usedGamerBattlefield
                            usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck3, 36);
                        } else {
                            System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                        }
                        break;
                }
                usedBattlefieldComp = getWinner(usedBattlefieldComp);
                gamerHit = true;
                return usedBattlefieldComp;
            case 451:
            case 452:
            case 453:
            case 454:
                if (usedBattlefieldComp.containsValue(451) 
                        && usedBattlefieldComp.containsValue(452)
                        && usedBattlefieldComp.containsValue(453) 
                        && usedBattlefieldComp.containsValue(454)) {

                    System.out.println("РОМАН, ПОТОПЛЕН ЧЕТЫРЕХПАЛУБНЫЙ КОРАБЛЬ!\n");
                    // выводим границы корабля на экран
                    Deck4 deck4 = new Deck4(45);
                    limitCoordDeck4 = deck4.genLimitCoordDeck4(battlefieldComp);

                    // добавляем границы корабля в массив usedBattlefieldComp
                    usedBattlefieldComp = addLimits(usedBattlefieldComp, limitCoordDeck4, 45);

                } else {
                    System.out.println("РОМАН, ПОДБИТ КОРАБЛЬ!\n");
                }
                usedBattlefieldComp = getWinner(usedBattlefieldComp);
                gamerHit = true;
                return usedBattlefieldComp;
            default:
                return usedBattlefieldComp;                
        } // выход из switch (valueOfBattlefielComp)
    } // выход из метода gamerMove

    /**
     * compDeck1SinkOrWound - метод необходимый для: вывода сообщения об
     * потоплении одного из однопалубных кораблей ИГРОКА, вызова метода, который
     * генерирует границы корабля, добавлении этих границ в коллекцию
     * usedBattlefieldGamer, чтобы исключить возможность повторного выстрела по
     * использованной границе корабля.
     *
     * @param usedBattlefieldComp - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах ИГРОКА
     * @param battlefieldComp - коллекция, хранящая информацию о расположении
     * кораблей КОМПЬЮТЕРА
     * @param limitDeck1 - вспомогательная коллекция, хранящая информацию о
     * граничных координатах однопалубных кораблей.
     * @param serialNumberOfDeck1 - порядковый номер однопалубного корабля.
     * @return - метод возвращает дополненную новыми значениями коллекцию
     * usedBattlefieldGamer.
     *
     */
    public static Map gamerDeck1SinkOrWound(Map usedBattlefieldComp, Map battlefieldComp, int limitDeck1, int serialNumberOfDeck1) {

        // выводим сообщение на экран
        System.out.println("РОМАН, ПОТОПЛЕН ОДНОПАЛУБНЫЙ КОРАБЛЬ!\n");
        // выводим границы корабля на экран
        Deck1 deck1 = new Deck1(limitDeck1, serialNumberOfDeck1);
        limitCoordDeck1 = deck1.genLimitCoordDeck1(battlefieldComp);

        // добавляем границы корабля в массив usedBattlefieldComp
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeck1.get(s) == limitDeck1) {
                    usedBattlefieldComp.put(s, limitDeck1);
                }
            }
        } return usedBattlefieldComp;
    }

    private static Map<String, Integer> getWinner(Map<String, Integer> usedBattlefieldComp) {

        // проверка, победил ли игрок или нет
        if (usedBattlefieldComp.containsValue(151)
                && usedBattlefieldComp.containsValue(161)
                && usedBattlefieldComp.containsValue(171)
                && usedBattlefieldComp.containsValue(181)
                && usedBattlefieldComp.containsValue(251)
                && usedBattlefieldComp.containsValue(252)
                && usedBattlefieldComp.containsValue(261)
                && usedBattlefieldComp.containsValue(262)
                && usedBattlefieldComp.containsValue(271)
                && usedBattlefieldComp.containsValue(272)
                && usedBattlefieldComp.containsValue(351)
                && usedBattlefieldComp.containsValue(352)
                && usedBattlefieldComp.containsValue(353)
                && usedBattlefieldComp.containsValue(361)
                && usedBattlefieldComp.containsValue(362)
                && usedBattlefieldComp.containsValue(363)
                && usedBattlefieldComp.containsValue(451)
                && usedBattlefieldComp.containsValue(452)
                && usedBattlefieldComp.containsValue(453)
                && usedBattlefieldComp.containsValue(454)) {
            System.out.println("Игра закончена!");
            winner = true;
        }
        return usedBattlefieldComp;
    }

    private static Map<String, Integer> addLimits (Map<String, Integer> usedBattlefieldComp, Map<String, Integer> limitCoordDeckX, int lcdx) {

        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeckX.get(s) == lcdx) {
                    usedBattlefieldComp.put(s, lcdx);
                }
            }
        } return usedBattlefieldComp;
    }
}
