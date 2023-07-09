package BankAccount;

import Banks.Bank;
import TimeMachine.PersonalTimeMachine;
import java.util.Date;

/**
 * Абстрактный метод на основе которого мы создаем разные типы платежных аккаунтов.
 * Счета бывают трёх видов: Дебетовый счет, Депозит и Кредитный счет. Каждый счет принадлежит какому-то клиенту.
 */
public abstract class Account {

    public int ID;
    public int Money;
    public Bank bank;
    public Date StartDay;
    public Date EndDay;
    public float ComissionMoney = 0;
    public PersonalTimeMachine TimeTravel;
    /**
     * Метод, который начисляет проценты на счет
     */
    public abstract void AccrualOfInterest();

    /**
     * Метод показывающий состояние счета в любую дату.
     * @param EndData
     * @return
     */
    public float GoToFuture(Date EndData){
        TimeTravel = new PersonalTimeMachine(Money, StartDay, ComissionMoney);
        return TimeTravel.StartMachine(EndData);
    }
}
