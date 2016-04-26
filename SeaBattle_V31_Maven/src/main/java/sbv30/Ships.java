package sbv30;

public class Ships {

    /* в random1 присваиваем число 0 или 1.
     * 0 - корабль будет установлен горизонтально
     * 1 - корабль будет установлен вертикально
     */
    private int random1;

    private int firstRandomNumberForLetter;
    private int firstRandomNumberForNumber;

    public int verOrHorPositionOfSpips () {
        random1 = (int) (Math.random() * 2);
        //int random1 = 0; // для отладки
        //System.out.println(random1 + " случайное число 0 - горизонтально или 1 - вертикально."); // для отладки
        return random1;
    }

    /* выбираем случайное число (координата firstRandomNumberForLetter) от 65 до 71 (соответствует буквам от A до G).
     * Это будет буква первой координаты корабля.
     */

    public int mFirstRandomNumberForLetter () {
        firstRandomNumberForLetter = (int) (Math.random() * 10 + 65); // генерирует число от 65 до 75
        return firstRandomNumberForLetter;
    }
    /* выбираем случайную цифру от 1 до 10, она будет показывать в каком ряде находиться корабль
     */
    public int mFirstRandomNumberForNumber () {
        firstRandomNumberForNumber = (int) (Math.random() * 10 + 1); // генерирует число от 1 до 10
        return firstRandomNumberForNumber;
    }

}
