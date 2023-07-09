package BankAccount;

import Banks.Bank;
import java.util.Date;

/**
 * Депозитный счет – счет, с которого нельзя снимать и переводить деньги до тех пор, пока не закончится его срок (пополнять можно). Процент на остаток зависит от изначальной суммы, например, если открываем депозит до 50 000 р. - 3%,
 * если от 50 000 р. до 100 000 р. - 3.5%, больше 100 000 р. - 4%. Комиссий нет.
 * Проценты должны задаваться для каждого банка свои.
 */

public class Deposit extends Account{

    /**
     * Конструктор с параметрами
     * @param ID
     * @param StartDay
     * @param EndDay
     * @param StartSum
     * @param bank
     */
    public Deposit(int ID, Date StartDay, Date EndDay, int StartSum, Bank bank){
        this.ID = ID;
        this.StartDay = StartDay;
        this.EndDay = EndDay;
        this.Money = StartSum;
        this.bank = bank;
        SetPercent();
    }

    /**
     * Метод, который определяет процент в зависимости от суммы вклада.
     */
    public void SetPercent() {
        if(Money < 50000)
            ComissionMoney = bank.DepositePersents[0];
        if (Money > 50000 && Money < 100000)
            ComissionMoney = bank.DepositePersents[1];
        if (Money > 100000)
            ComissionMoney = bank.DepositePersents[2];
    }

    /**
     * Метод, который начисляет проценты на счет
     */
    @Override
    public void AccrualOfInterest(){
            Money += Money*(ComissionMoney/365);
    }

}
