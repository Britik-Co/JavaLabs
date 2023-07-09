package Clients;

/**
 * Класс отвечает за персональные данные клиеты: Серия и номер паспорта.
 */
public class Passport {
    /**
     * Конструктор
     * @param number
     * @param series
     */
    public Passport(int number, int series){
        Number = number;
        Series = series;
    }
    public int Number;
    public int Series;
}
