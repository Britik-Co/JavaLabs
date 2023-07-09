package BankAccount;

import Banks.Bank;
import java.util.Date;

/**
 * Дебетовый счет – обычный счет с фиксированным процентом на остаток.
 * Деньги можно снимать в любой момент, в минус уходить нельзя. Комиссий нет.
 */
public class Debit extends Account{
    /**
     * Конструктор с параметрами
     * @param ID
     * @param StartDay
     * @param EndDay
     * @param StartSum
     * @param bank
     */
    public Debit(int ID, Date StartDay,Date EndDay,  int StartSum, Bank bank){
        this.Money = StartSum;
        this.EndDay = EndDay;
        this.StartDay = StartDay;
        this.bank = bank;
        ComissionMoney = bank.DebitPersents;
    }
    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void AccrualOfInterest(){
        if(Money > 0)
            Money += ComissionMoney;
    }
}
