package BankAccount;

import Banks.Bank;
import java.util.Date;

/**
 * Кредитный счет – имеет кредитный лимит, в рамках которого можно уходить в минус (в плюс тоже можно).
 * Процента на остаток нет. Есть фиксированная комиссия за использование, если клиент в минусе.
 */
public class Credit extends Account{
    /**
     * Конструктор
     * @param StartDay
     * @param EndDay
     * @param CreditSum
     * @param bank
     */
    public Credit(Date StartDay,Date EndDay, int CreditSum, Bank bank){
        this.Money = CreditSum;
        this.EndDay = EndDay;
        this.StartDay = StartDay;
        this.bank = bank;
        this.ComissionMoney = bank.CreditPersents;
    }

    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void AccrualOfInterest(){
        if(Money < 0)
            Money -= Money*(ComissionMoney/356);
    }

}
