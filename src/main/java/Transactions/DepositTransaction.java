package Transactions;

import BankAccount.Account;
import BankAccount.Deposit;
import Banks.Bank;

import java.util.Date;

public class DepositTransaction extends Transaction{
    /**
     * Конструктор
     * @param ID
     * @param Money
     * @param ScoreFrom
     * @param ScoreTo
     * @param bank
     */
    public DepositTransaction(int ID, int Money, Account ScoreFrom, Account ScoreTo, Bank bank) {
        super(ID, Money, ScoreFrom, ScoreTo, bank);
    }

    public Date data = new Date();
    @Override
    public void Check() {
        if(ScoreFrom.EndDay.before(data))
            IsCorrect = true;
        else {
            IsCorrect = false;
            System.out.println("Time your score not ready yet");
        }

    }

    /**
     * Метод, добавляющий транзакцию.
     */
    @Override
    public void AddTransaction() {
        Check();
        ScoreFrom.Money -= Money;
        ScoreTo.Money += Money;
        System.out.println();
    }

    /**
     * Метод, удаляющий транзакцию.
     */
    @Override
    public void DeleteTransaction() {
        Check();
        ScoreTo.Money -= Money;
        ScoreFrom.Money += Money;
    }
}
