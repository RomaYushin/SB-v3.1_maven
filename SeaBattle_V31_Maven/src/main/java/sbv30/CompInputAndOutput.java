package sbv30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * CompInputAndOutput - ход компьютера (генерация случайной координаты
 * компьютера) Описание класса: данный класс предназначен для выполнения хода
 * компьютера.
 *
 * @version 3.0 07 April 2016
 * @author Roman Yushin (Роман Юшин)
 */
public class CompInputAndOutput {

    /**
     * static private Map <String, Integer> limitCoordDeck1 (limitCoordDeck2,
     * limitCoordDeck3, limitCoordDeck4) - вспомогательные коллекции в ключах
     * (key) которой храняться координаты границ однопалубных (двухпалубных,
     * трехпалубных, четырехпалубных ) кораблей соответственно. В значениях
     * (value) храняться соответствующие числа. После того, как топиться
     * корабль, вызывается метод генерации границ соответствующего корабля,
     * чтобы полученные значения могли внести в коллекцию уже открытых
     * (использованных) координат Map usedBattlefieldGamer. Данная коллекция
     * перезаписывается при каждом новом потоплении однопалубного корабля.
     */
    private static Map<String, Integer> limitCoordDeck1,
            limitCoordDeck2, limitCoordDeck3, limitCoordDeck4;

    /**
     * int valueOfBattlefieldGamer - хранит в себе число, характерезующее
     * координату, по которой "стрельнул" корабль Компьютер генерирует случайную
     * координату, например B3. Как узнать находиться ли там корабль, либо
     * компьютер промахнулся. Для этого смотрим, какое же число находиться в
     * коллекции battlefieldGamer (value) по координате B3. Там 411. Вот это
     * число мы заносим в данную переменную. Дополнительную информацию можно
     * получить в описании класса Main.
     */
    private static int valueOfBattlefieldGamer;

    /**
     * String randomCompCoord - переменная, хранящая в себе случайно
     * сгенерированную координату - ход компьютера. Например A1, G5...
     */
    private static String randomCompCoord;

    /**
     * int limitDeck1 (int limitDeck2, int limitDeck3, int limitDeck4) -
     * вспомогательная переменная, хранящая в себе число - границу однопалубного
     * (двухпалубного, трехпалубного, четырехпалубного) корабля соответственно;
     */
    private static int limitDeck1, limitDeck2, limitDeck3, limitDeck4;

    /**
     * int serialNumberOfDeck1 (serialNumberOfDeck2, serialNumberOfDeck3,
     * serialNumberOfDeck4) - переменная, хранящая в себе число - порядковый
     * номер однопалубного (двухпалубного, трехпалубного, четырехпалубного)
     * корабля соответственно.
     */
    private static int serialNumberOfDeck1,
            serialNumberOfDeck2, serialNumberOfDeck3, serialNumberOfDeck4;

    /**
     * String _1successfulCoord (_2successfulCoord, _3successfulCoord ) -
     * переменная, хранящая первую (вторую, третью соответственно) координату,
     * раненого корабля.
     */
    private static String _1successfulCoord, _2successfulCoord, _3successfulCoord;

    /**
     * String _1CoordForWoundShip ( _2CoordForWoundShip, _3CoordForWoundShip,
     * _4CoordForWoundShip) - переменная, хранящая значение первой (второй,
     * третей, четвертой) случайно сгенерированной координаты для следующего
     * хода.
     */
    private static String _1CoordForWoundShip, _2CoordForWoundShip,
            _3CoordForWoundShip, _4CoordForWoundShip;

    /**
     * int randomN - вспомогательная переменная, хранящая одно из четырех
     * случайно выбранных чисел: 1, 2, 3, 4. В зависимости от метода Math.random
     * будет выбрана одна случайная координата из этих четырех чисел.
     */
    private static int randomN;

    /**
     * int letter1 (letter2, letter3) - число, соответствующее по таблице
     * Unicode букве первой (второй, третей соответственно) координаты раненого
     * корабля (ведь координата соостоит из буквы и цифры). Например, если
     * координата подбитого корабля A1, то число letter1 будет хранить значение
     * 65 и т.д. для остальных букв. Это вспомогательная переменная, помогающая
     * понять, находиться ли корабль по вертикали или по горизонатли, и от этого
     * формировать следующие возможные координаты.
     */
    private static int letter1, letter2, letter3;

    /**
     * int number1 (number2, number3) - число, соответствующее цифре первой
     * (второй, третей соответственно) координаты раненого корабля. Это
     * вспомогательная переменная, помогающая понять, находиться ли корабль по
     * вертикали или по горизонатли, и от этого формировать следующие возможные
     * координаты.
     */
    private static int number1, number2, number3;

    /**
     * int previousLetter1 (nextLetter1) - вспомогательная переменная,
     * показывающая предыдущую (следующую) букву, в соответствии с Unicode
     * относительно буквы координаты раненого корабля. Необходима для
     * формирования одной из координат для следующего хода компьютера.
     */
    private static int previousLetter1 = 0, nextLetter1 = 0;

    /**
     * int previousNumber1 (nextNumber1) - вспомогательная переменная,
     * показывающая предыдущую (следующую) цифру относительно цифры координаты
     * раненого корабля. Необходима для формирования одной из координат для
     * следующего хода компьютера.
     */
    private static int previousNumber1 = 0, nextNumber1 = 0;

    /**
     * String randomCoordForWoundShip - итоговая сгенерировання случайным
     * образом координата для следующего хода компьютера. Заноситься в коллекцию
     * compInputWound
     */
    private static String randomCoordForWoundShip = null;

    /**
     * boolean compHit - переменная, которая хранит значение попал ли компьютер
     * или промахнулся. true - попал; false - промахнулся; 
     */
    private static boolean compHit;

    /**
     * boolean winner - переменная, которая хранит значение победил ли компьютер
     * или нет. true - победил; false - нет. true может присвоиться только в 
     * методе getWinner.
     */
    private static boolean winner;
    
    /**
     * Метод получения переменной winner
     * @return 
     */
    public static boolean isWinner() {
        return winner;
    }

    /**
     * Метод получения переменной compHit
     * @return 
     */
    public static boolean isCompHit() {
        return compHit;
    }

    /**
     * Метод установки переменной winner
     * @param winner 
     */
    public static void setWinner(boolean winner) {
        CompInputAndOutput.winner = winner;
    }

    /**
     * compMoveRandom. В этом методе компьютер генерирует первую случайную
     * координату, проверяет ноходиться ли по этой координате корабль
     * игрока, либо компьютер промахнулся. Возможны три варианта: 
     * 1) Промах.
     * 2) Потопил однопалубный корабль.
     * 3) Ранил друх, трех или четырех палубный корабль.
     * @param battlefieldGamer - коллекция, хранящая значения поля игрока
     * @param usedBattlefieldGamer - коллекция, хранящая уже использованные
     * значения поля компьютера
     * @param compInputWound - коллекция, хранящая координаты раненого, 
     * но не потопленного корабля
     * @return usedBattlefieldGamer
     */
    public static Map<String, Integer> compMoveRandom(Map<String, Integer> battlefieldGamer, Map<String, Integer> usedBattlefieldGamer, ArrayList<String> compInputWound) {

        Ships ships = new Ships();
        try {
            System.out.println("Компьютер думает...");
            Thread.sleep(2000); // Задержка в 2.0 сек для имитации обдумывания компьютером следубщего хода
        } catch (Exception e) {
            System.out.println(e);
        }

        while (true) {
            randomCompCoord = Character.toString((char) ships.mFirstRandomNumberForLetter()) + ships.mFirstRandomNumberForNumber();
            if (usedBattlefieldGamer.get(randomCompCoord) == 0) {
                break;
            } else {
                System.out.println("Компьютер уже стреляли по этой координате!\n");
            }
        }

        valueOfBattlefieldGamer = (int) battlefieldGamer.get(randomCompCoord);
        usedBattlefieldGamer.put(randomCompCoord, valueOfBattlefieldGamer);

        System.out.print("Компьютер сделал свой ход: " + randomCompCoord);

        switch (valueOfBattlefieldGamer) {
            case 0:
            case 11:
            case 12:
            case 13:
            case 14:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 41:
                System.out.println("Компьютре, МИМО!\n");
                usedBattlefieldGamer.put(randomCompCoord, 1);
                compHit = false;
                return usedBattlefieldGamer;
            case 111:
            case 121:
            case 131:
            case 141:
                switch (valueOfBattlefieldGamer) {
                    case 111:
                        limitDeck1 = 11;
                        serialNumberOfDeck1 = 1;
                        break;
                    case 121:
                        limitDeck1 = 12;
                        serialNumberOfDeck1 = 2;
                        break;
                    case 131:
                        limitDeck1 = 13;
                        serialNumberOfDeck1 = 3;
                        break;
                    case 141:
                        limitDeck1 = 14;
                        serialNumberOfDeck1 = 4;
                        break;
                }
                usedBattlefieldGamer = compDeck1SinkOrWound(usedBattlefieldGamer, battlefieldGamer, limitDeck1, serialNumberOfDeck1);
                usedBattlefieldGamer = getWinner(usedBattlefieldGamer);
                compHit = true;
                return usedBattlefieldGamer;
            case 211:
            case 212:
            case 221:
            case 222:
            case 231:
            case 232:
            case 311:
            case 312:
            case 313:
            case 321:
            case 322:
            case 323:
            case 411:
            case 412:
            case 413:
            case 414:
                System.out.println("ПОДБИТ КОРАБЛЬ!");
                compInputWound.add(0, randomCompCoord);
                CompInputAndOutput2.setCompInputWound(createSecondRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                compHit = true;
                return usedBattlefieldGamer;
            default:
                System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 0!!!");
        }
        return usedBattlefieldGamer;
    }

    /**
     * compMoveAfterFirstHit. В этом методе компьютер генерирует вторую 
     * случайную координату, если один раз уже ранили корабль. Проверяет 
     * ноходиться ли по этой координате корабль игрока, либо компьютер
     * промахнулся. Возможны три варианта: 
     * 1) Промах.
     * 2) Потопил двухпалубный корабль.
     * 3) Ранил трех или четырех палубный корабль. 
     * 
     * @param battlefieldGamer - коллекция, хранящая значения поля игрока
     * @param usedBattlefieldGamer - коллекция, хранящая уже использованные
     * значения поля компьютера
     * @param compInputWound - коллекция, хранящая координаты раненого, 
     * но не потопленного корабля
     * @return usedBattlefieldGamer
     */
    public static Map<String, Integer> compMoveAfterFirstHit(Map<String, Integer> battlefieldGamer, Map<String, Integer> usedBattlefieldGamer, ArrayList<String> compInputWound) {

        try {
            System.out.println("Компьютер думает...");
            Thread.sleep(2000); // Задержка в 2.0 сек для имитации обдумывания компьютером следубщего хода
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("Компьютер сделал свой ход после единожды подбитого корабля: " + compInputWound.get(1));
        valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(1));
        usedBattlefieldGamer.put(compInputWound.get(1), valueOfBattlefieldGamer);
        switch (valueOfBattlefieldGamer) {
            case 0:
            case 11:
            case 12:
            case 13:
            case 14:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 41:
                System.out.println("Компьютер, МИМО!\n");
                usedBattlefieldGamer.put(compInputWound.get(1), 1);
                compHit = false;
                compInputWound.remove(1);
                CompInputAndOutput2.setCompInputWound(createSecondRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                return usedBattlefieldGamer;
            case 211:
            case 212:
            case 221:
            case 222:
            case 231:
            case 232:
                switch (valueOfBattlefieldGamer) {
                    case 211:
                    case 212:
                        limitDeck2 = 21;
                        serialNumberOfDeck2 = 1;
                        break;
                    case 221:
                    case 222:
                        limitDeck2 = 22;
                        serialNumberOfDeck2 = 2;
                        break;
                    case 231:
                    case 232:
                        limitDeck2 = 23;
                        serialNumberOfDeck2 = 3;
                        break;
                }
                System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ ЗЗЗ №" + serialNumberOfDeck2 + "!\n");
                Deck2 deck2_x = new Deck2(limitDeck2, serialNumberOfDeck2);
                limitCoordDeck2 = deck2_x.genLimitCoordDeck2(battlefieldGamer);

                // добавляем границы корабля в массив usedBattlefieldGamer
                usedBattlefieldGamer = addLimits(usedBattlefieldGamer, limitCoordDeck2, limitDeck2);

                compInputWound.clear();
                compHit = true;
                CompInputAndOutput2.setCompInputWound(compInputWound);
                usedBattlefieldGamer = getWinner(usedBattlefieldGamer);
                return usedBattlefieldGamer;
            case 311:
            case 312:
            case 313:
            case 321:
            case 322:
            case 323:
            case 411:
            case 412:
            case 413:
            case 414:
                System.out.println("ПОДБИТ КОРАБЛЬ!");
                CompInputAndOutput2.setCompInputWound(createThirdRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                compHit = true;
                return usedBattlefieldGamer;
            default:
                System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 2!!!");
        }
        return usedBattlefieldGamer;
    }

    /**
     * compMoveAfterSecondHit. В этом методе компьютер генерирует третью 
     * случайную координату, если дважды уже ранили корабль. Проверяет 
     * ноходиться ли по этой координате корабль игрока, либо компьютер
     * промахнулся. Возможны три варианта: 
     * 1) Промах.
     * 2) Потопил трехпалубный корабль.
     * 3) Ранил четырех палубный корабль. 
     * 
     * @param battlefieldGamer - коллекция, хранящая значения поля игрока
     * @param usedBattlefieldGamer - коллекция, хранящая уже использованные
     * значения поля компьютера
     * @param compInputWound - коллекция, хранящая координаты раненого, 
     * но не потопленного корабля
     * @return usedBattlefieldGamer
     */
    public static Map<String, Integer> compMoveAfterSecondHit(Map<String, Integer> battlefieldGamer, Map<String, Integer> usedBattlefieldGamer, ArrayList<String> compInputWound) {

        try {
            System.out.println("Компьютер думает...");
            Thread.sleep(2000);  // Задержка в 2.0 сек для имитации обдумывания компьютером следубщего хода
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.print("Компьютер сделал свой ход после дважды подбитого корабля: " + compInputWound.get(2));
        valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(2));
        usedBattlefieldGamer.put(compInputWound.get(2), valueOfBattlefieldGamer);
        switch (valueOfBattlefieldGamer) {
            case 0:
            case 11:
            case 12:
            case 13:
            case 14:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 41:
                System.out.println("Компьютер, МИМО!\n");
                usedBattlefieldGamer.put(compInputWound.get(2), 1);
                compHit = false;
                compInputWound.remove(2);
                CompInputAndOutput2.setCompInputWound(createThirdRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                return usedBattlefieldGamer;
            case 311:
            case 312:
            case 313:
            case 321:
            case 322:
            case 323:
                switch (valueOfBattlefieldGamer) {
                    case 311:
                    case 312:
                    case 313:
                        limitDeck3 = 31;
                        serialNumberOfDeck3 = 1;
                        break;
                    case 321:
                    case 322:
                    case 323:
                        limitDeck3 = 32;
                        serialNumberOfDeck3 = 2;
                        break;
                }
                System.out.println("ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ №" + serialNumberOfDeck3 + "!\n");
                // выводим границы корабля на экран
                Deck3 deck3_x = new Deck3(limitDeck3, serialNumberOfDeck3);
                limitCoordDeck3 = deck3_x.genLimitCoordDeck3(battlefieldGamer);
                // добавляем границы корабля в массив usedBattlefieldGamer
                usedBattlefieldGamer = addLimits(usedBattlefieldGamer, limitCoordDeck3, limitDeck3);
                compInputWound.clear();
                CompInputAndOutput2.setCompInputWound(compInputWound);
                compHit = true;
                usedBattlefieldGamer = getWinner(usedBattlefieldGamer);
                return usedBattlefieldGamer;
            case 411:
            case 412:
            case 413:
            case 414:
                System.out.println("ПОДБИТ КОРАБЛЬ!");
                CompInputAndOutput2.setCompInputWound(createFourthRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                compHit = true;
                return usedBattlefieldGamer;
            default:
                System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 3!!!");
        }
        return usedBattlefieldGamer;
    }
    
    /**
     * compMoveAfterThirdHit. В этом методе компьютер генерирует четверную
     * случайную координату, если трижды уже ранили корабль. Проверяет 
     * ноходиться ли по этой координате корабль игрока, либо компьютер
     * промахнулся. Возможны три варианта: 
     * 1) Промах.
     * 2) Потопил трехпалубный корабль.
     * 
     * @param battlefieldGamer - коллекция, хранящая значения поля игрока
     * @param usedBattlefieldGamer - коллекция, хранящая уже использованные
     * значения поля компьютера
     * @param compInputWound - коллекция, хранящая координаты раненого, 
     * но не потопленного корабля
     * @return usedBattlefieldGamer
     */
    public static Map<String, Integer> compMoveAfterThirdHit(Map<String, Integer> battlefieldGamer, Map<String, Integer> usedBattlefieldGamer, ArrayList<String> compInputWound) {

        try {
            System.out.println("Компьютер думает...");
            Thread.sleep(2000); // Задержка в 2.0 сек для имитации обдумывания компьютером следубщего хода
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.print("Компьютер сделал свой ход после трижды подбитого корабля: " + compInputWound.get(3));
        valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(3));
        usedBattlefieldGamer.put(compInputWound.get(3), valueOfBattlefieldGamer);
        switch (valueOfBattlefieldGamer) {
            case 0:
            case 11:
            case 12:
            case 13:
            case 14:
            case 21:
            case 22:
            case 23:
            case 31:
            case 32:
            case 41:
                System.out.println("Компьютер, МИМО!\n");
                usedBattlefieldGamer.put(compInputWound.get(3), 1);
                compHit = false;
                compInputWound.remove(3);
                CompInputAndOutput2.setCompInputWound(createFourthRandomCoordForWoundShip(compInputWound, battlefieldGamer, usedBattlefieldGamer));
                return usedBattlefieldGamer;
            case 411:
            case 412:
            case 413:
            case 414:
                System.out.println("ПОТОПЛЕН ЧЕТЫРЕХПАЛУБНЫЙ КОРАБЛЬ!\n");
                // выводим границы корабля на экран
                Deck4 deck4 = new Deck4(41);
                limitCoordDeck4 = deck4.genLimitCoordDeck4(battlefieldGamer);
                // добавляем границы корабля в массив usedBattlefieldGamer
                usedBattlefieldGamer = addLimits(usedBattlefieldGamer, limitCoordDeck4, 41);
                compInputWound.clear();
                CompInputAndOutput2.setCompInputWound(compInputWound);
                compHit = true;
                usedBattlefieldGamer = getWinner(usedBattlefieldGamer);
                return usedBattlefieldGamer;
            default:
                System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 4!!!");
        }
        return usedBattlefieldGamer;
    }

    /**
     * addLimits - метод, который добавляет в коллекцию usedBattlefieldGamer 
     * значения использованный координат поля игрока.
     * 
     * @param usedBattlefieldGamer - коллекция, хранящая уже использованные
     * значения поля компьютера
     * @param limitCoordDeckX - число граница определенного корабля
     * @param lcdx - число порядковый номер потопленного корабля
     * @return usedBattlefieldGamer
     */
    private static Map<String, Integer> addLimits(Map<String, Integer> usedBattlefieldGamer, Map<String, Integer> limitCoordDeckX, int lcdx) {

        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeckX.get(s) == lcdx) {
                    usedBattlefieldGamer.put(s, lcdx);
                }
            }
        }
        return usedBattlefieldGamer;
    }

    /**
     * compDeck1SinkOrWound - метод необходимый для: вывода сообщения об
     * потоплении одного из однопалубных кораблей ИГРОКА, вызова метода, который
     * генерирует границы корабля, добавлении этих границ в коллекцию
     * usedBattlefieldGamer, чтобы исключить возможность повторного выстрела по
     * использованной границе корабля.
     *
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах КОМПЬЮТЕРА
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении
     * кораблей игрока
     * @param limitDeck1 - вспомогательная коллекция, хранящая информацию о
     * граничных координатах однопалубных кораблей.
     * @param serialNumberOfDeck1 - порядковый номер однопалубного корабля.
     * @return - метод возвращает дополненную новыми значениями коллекцию
     * usedBattlefieldGamer.
     *
     */
    public static Map compDeck1SinkOrWound(Map usedBattlefieldGamer, Map battlefieldGamer, int limitDeck1, int serialNumberOfDeck1) {

        System.out.println("ПОТОПЛЕН ОДНОПАЛУБНЫЙ КОРАБЛЬ!\n");
        Deck1 deck1 = new Deck1(limitDeck1, serialNumberOfDeck1);
        limitCoordDeck1 = deck1.genLimitCoordDeck1(battlefieldGamer);

        // добавляем границы корабля в массив usedBattlefieldGamer
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeck1.get(s) == limitDeck1) {
                    usedBattlefieldGamer.put(s, limitDeck1);
                }
            }
        }
        return usedBattlefieldGamer;
    }

    /**
     * createSecondRandomCoordForWoundShip - метод, генерирующий вторую 
     * случайную координату после того, как один из кораблей ранен.  
     * Внутри выполняет проверки, на повторность хода. Недопускает выпадания
     * недопустимой или уже "стреляной" координаты.
     *
     * @param compInputWound - коллекция, хранящая информацию раненом корабле.
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении
     * кораблей игрока
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах ИГРОКА
     * @return compInputWound; - возвращает коллекцию с координатами подбитого
     * корабля и новую случайно сгенерированную координату.
     */
    public static ArrayList<String> createSecondRandomCoordForWoundShip(ArrayList<String> compInputWound, Map battlefieldGamer, Map usedBattlefieldGamer) {

        System.out.println("Внутри createSecondRandomCoordForWoundShip");
        _1successfulCoord = compInputWound.get(0);
        do {
            if (_1successfulCoord.equals("A10")
                    || _1successfulCoord.equals("B10")
                    || _1successfulCoord.equals("C10")
                    || _1successfulCoord.equals("D10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("F10")
                    || _1successfulCoord.equals("G10")
                    || _1successfulCoord.equals("H10")
                    || _1successfulCoord.equals("I10")
                    || _1successfulCoord.equals("J10")) {

                letter1 = randomCompCoord.charAt(0);
                number1 = 10;
            } else {
                letter1 = randomCompCoord.charAt(0);
                number1 = Character.getNumericValue(randomCompCoord.charAt(1));
            }
            previousLetter1 = letter1 - 1;
            nextLetter1 = letter1 + 1;

            previousNumber1 = number1 - 1;
            nextNumber1 = number1 + 1;

            _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
            _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);
            _3CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);
            _4CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);

            randomN = (int) (Math.random() * 4 + 1);

            switch (randomN) {
                case 1:
                    randomCoordForWoundShip = _1CoordForWoundShip;
                    break;
                case 2:
                    randomCoordForWoundShip = _2CoordForWoundShip;
                    break;
                case 3:
                    randomCoordForWoundShip = _3CoordForWoundShip;
                    break;
                case 4:
                    randomCoordForWoundShip = _4CoordForWoundShip;
                    break;
            }
            System.out.println("Выбранная случайно одна после одного попадания: " + randomCoordForWoundShip);
        } while (battlefieldGamer.containsKey(randomCoordForWoundShip) == false || (((int) usedBattlefieldGamer.get(randomCoordForWoundShip)) == 0) == false);
        compInputWound.add(1, randomCoordForWoundShip);
        return compInputWound;
    }

    /**
     * createThirdRandomCoordForWoundShip - метод, генерирующий третью
     * случайную координату после того, как два раза корабль ранен.  
     * Внутри выполняет проверки, на повторность хода. Недопускает выпадания
     * недопустимой или уже "стреляной" координаты.
     *
     * @param compInputWound - коллекция, хранящая информацию раненом корабле.
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении
     * кораблей игрока
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах ИГРОКА
     * @return compInputWound; - возвращает коллекцию с координатами подбитого
     * корабля и новую случайно сгенерированную координату.
     */
    public static ArrayList<String> createThirdRandomCoordForWoundShip(ArrayList<String> compInputWound, Map battlefieldGamer, Map usedBattlefieldGamer) {
        do {
            _1successfulCoord = compInputWound.get(0);
            _2successfulCoord = compInputWound.get(1);

            //раскладывание первой координаты
            if (_1successfulCoord.equals("A10")
                    || _1successfulCoord.equals("B10")
                    || _1successfulCoord.equals("C10")
                    || _1successfulCoord.equals("D10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("F10")
                    || _1successfulCoord.equals("G10")
                    || _1successfulCoord.equals("H10")
                    || _1successfulCoord.equals("I10")
                    || _1successfulCoord.equals("J10")) {

                letter1 = _1successfulCoord.charAt(0);
                number1 = 10;
            } else {
                letter1 = _1successfulCoord.charAt(0);
                number1 = Character.getNumericValue(_1successfulCoord.charAt(1));
            }

            //раскладывание второй координаты
            if (_2successfulCoord.equals("A10")
                    || _2successfulCoord.equals("B10")
                    || _2successfulCoord.equals("C10")
                    || _2successfulCoord.equals("D10")
                    || _2successfulCoord.equals("E10")
                    || _2successfulCoord.equals("E10")
                    || _2successfulCoord.equals("F10")
                    || _2successfulCoord.equals("G10")
                    || _2successfulCoord.equals("H10")
                    || _2successfulCoord.equals("I10")
                    || _2successfulCoord.equals("J10")) {

                letter2 = _2successfulCoord.charAt(0);
                number2 = 10;
            } else {
                letter2 = _2successfulCoord.charAt(0);
                number2 = Character.getNumericValue(_2successfulCoord.charAt(1));
            }

            /* Необходимо определиться стоят координата вертикально или горизонтально вертикально или горизонтально
             * если буквы равны, то корабль находиться вертикально
             * если цифры равны, то корабль находиться горизонтально
             */
            if (letter1 == letter2) { // по вертикали
                if (number1 < number2) {
                    previousNumber1 = number1 - 1;
                    nextNumber1 = number2 + 1;
                } else if (number1 > number2) {
                    previousNumber1 = number2 - 1;
                    nextNumber1 = number1 + 1;
                }

                _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
                _2CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);

                randomN = (int) (Math.random() * 2 + 1);

                switch (randomN) {
                    case 1:
                        randomCoordForWoundShip = _1CoordForWoundShip;
                        break;
                    case 2:
                        randomCoordForWoundShip = _2CoordForWoundShip;
                        break;
                }
            } else if (number1 == number2) { // по горизонтали
                if (letter1 < letter2) {
                    previousLetter1 = letter1 - 1;
                    nextLetter1 = letter2 + 1;
                } else if (letter1 > letter2) {
                    previousLetter1 = letter2 - 1;
                    nextLetter1 = letter1 + 1;
                }

                _1CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);
                _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);

                randomN = (int) (Math.random() * 2 + 1);

                switch (randomN) {
                    case 1:
                        randomCoordForWoundShip = _1CoordForWoundShip;
                        break;
                    case 2:
                        randomCoordForWoundShip = _2CoordForWoundShip;
                        break;
                }
            }
            System.out.println("Выбранная случайно одна после двух попаданий: " + randomCoordForWoundShip);
        } while (battlefieldGamer.containsKey(randomCoordForWoundShip) == false 
                || (((int) usedBattlefieldGamer.get(randomCoordForWoundShip)) == 0) == false);
        compInputWound.add(2, randomCoordForWoundShip);
        return compInputWound;
    }

    /**
     * createFourthRandomCoordForWoundShip - метод, генерирующий четвертую
     * случайную координату после того, как два раза корабль ранен.  
     * Внутри выполняет проверки, на повторность хода. Недопускает выпадания
     * недопустимой или уже "стреляной" координаты.
     *
     * @param compInputWound - коллекция, хранящая информацию раненом корабле.
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении
     * кораблей игрока
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже
     * использованных ("стреляных") координатах ИГРОКА
     * @return compInputWound; - возвращает коллекцию с координатами подбитого
     * корабля и новую случайно сгенерированную координату.
     */
    public static ArrayList<String> createFourthRandomCoordForWoundShip(ArrayList<String> compInputWound, Map battlefieldGamer, Map usedBattlefieldGamer) {

        //Сортировка по возростанию входных координат
        compInputWound = CompInputAndOutput.specialSort(compInputWound); 

        _1successfulCoord = compInputWound.get(0);
        _3successfulCoord = compInputWound.get(2);

        do {
            _1successfulCoord = compInputWound.get(0);
            _3successfulCoord = compInputWound.get(2);
            //раскладывание первой координаты
            if (_1successfulCoord.equals("A10")
                    || _1successfulCoord.equals("B10")
                    || _1successfulCoord.equals("C10")
                    || _1successfulCoord.equals("D10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("E10")
                    || _1successfulCoord.equals("F10")
                    || _1successfulCoord.equals("G10")
                    || _1successfulCoord.equals("H10")
                    || _1successfulCoord.equals("I10")
                    || _1successfulCoord.equals("J10")) {

                letter1 = _1successfulCoord.charAt(0);
                number1 = 10;

            } else {
                letter1 = _1successfulCoord.charAt(0);
                number1 = Character.getNumericValue(_1successfulCoord.charAt(1));
            }

            //раскладывание третей координаты
            if (_3successfulCoord.equals("A10")
                    || _3successfulCoord.equals("B10")
                    || _3successfulCoord.equals("C10")
                    || _3successfulCoord.equals("D10")
                    || _3successfulCoord.equals("E10")
                    || _3successfulCoord.equals("E10")
                    || _3successfulCoord.equals("F10")
                    || _3successfulCoord.equals("G10")
                    || _3successfulCoord.equals("H10")
                    || _3successfulCoord.equals("I10")
                    || _3successfulCoord.equals("J10")) {

                letter3 = _3successfulCoord.charAt(0);
                number3 = 10;
            } else {
                letter3 = _3successfulCoord.charAt(0);
                number3 = Character.getNumericValue(_3successfulCoord.charAt(1));
            }

            /*Необходимо определиться стоят координата вертикально или горизонтально вертикально или горизонтально
             * если буквы равны, то корабль находиться вертикально
             * если цифры равны, то корабль находиться горизонтально
             */
            if (letter1 == letter3) {
                if (number1 < number3) {
                    previousNumber1 = number1 - 1;
                    nextNumber1 = number3 + 1;
                } else if (number1 > number3) {
                    previousNumber1 = number3 - 1;
                    nextNumber1 = number1 + 1;
                }
                _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
                _2CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);
                randomN = (int) (Math.random() * 2 + 1);

                switch (randomN) {
                    case 1:
                        randomCoordForWoundShip = _1CoordForWoundShip;
                        break;
                    case 2:
                        randomCoordForWoundShip = _2CoordForWoundShip;
                        break;
                }
            } else if (number1 == number3) {
                if (letter1 < letter3) {
                    previousLetter1 = letter1 - 1;
                    nextLetter1 = letter3 + 1;
                } else if (letter1 > letter3) {
                    previousLetter1 = letter3 - 1;
                    nextLetter1 = letter1 + 1;
                }
                _1CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);
                _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);
                randomN = (int) (Math.random() * 2 + 1);

                switch (randomN) {
                    case 1:
                        randomCoordForWoundShip = _1CoordForWoundShip;
                        break;
                    case 2:
                        randomCoordForWoundShip = _2CoordForWoundShip;
                        break;
                }
            }
            System.out.println("Выбранная случайно одна после трех попаданий: " + randomCoordForWoundShip);

        } while (battlefieldGamer.containsKey(randomCoordForWoundShip) == false 
                || (((int) usedBattlefieldGamer.get(randomCoordForWoundShip)) == 0) == false);
        compInputWound.add( 3, randomCoordForWoundShip);
        return compInputWound;
    }

    public static Map<String, Integer> getWinner(Map<String, Integer> usedBattlefieldGamer) {
        // проверка, победил ли компьютер или нет
        if (usedBattlefieldGamer.containsValue(111)
                && usedBattlefieldGamer.containsValue(121)
                && usedBattlefieldGamer.containsValue(131)
                && usedBattlefieldGamer.containsValue(141)
                && usedBattlefieldGamer.containsValue(211)
                && usedBattlefieldGamer.containsValue(212)
                && usedBattlefieldGamer.containsValue(221)
                && usedBattlefieldGamer.containsValue(222)
                && usedBattlefieldGamer.containsValue(231)
                && usedBattlefieldGamer.containsValue(232)
                && usedBattlefieldGamer.containsValue(311)
                && usedBattlefieldGamer.containsValue(312)
                && usedBattlefieldGamer.containsValue(313)
                && usedBattlefieldGamer.containsValue(321)
                && usedBattlefieldGamer.containsValue(322)
                && usedBattlefieldGamer.containsValue(323)
                && usedBattlefieldGamer.containsValue(411)
                && usedBattlefieldGamer.containsValue(412)
                && usedBattlefieldGamer.containsValue(413)
                && usedBattlefieldGamer.containsValue(414)) {
            System.out.println("Игра закончена!");
            System.out.println("ПОБЕДИЛ КОМПЬЮТЕР!!!");
            winner = true;
        }
        return usedBattlefieldGamer;
    }

    public static ArrayList<String> specialSort(ArrayList<String> compInputWound) {
        String thirdCoord = null;

        for (int i = 0; i < compInputWound.size(); i++) {
            if (compInputWound.get(i).length() > 2) {
                thirdCoord = compInputWound.get(i);
                compInputWound.remove(i);
            }
        }
        Collections.sort(compInputWound);
        if (thirdCoord != null) {
            compInputWound.add(2, thirdCoord);
        }
        return compInputWound;
    }
}