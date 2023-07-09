package Transactions;

import BankAccount.Account;
import Banks.Bank;

public class DebitTransaction extends Transaction{
    /**
     * Конструктор
     * @param ID
     * @param Money
     * @param ScoreFrom
     * @param ScoreTo
     * @param bank
     */
    public DebitTransaction(int ID, int Money, Account ScoreFrom, Account ScoreTo, Bank bank) {
        super(ID, Money, ScoreFrom, ScoreTo, bank);
    }

    /**
     * Метод, проверяющий корректность транзакции.
     */
    @Override
    public void Check() {
        if(ScoreFrom.Money >= Money)
            IsCorrect = true;
        else {
            IsCorrect = false;
            System.out.println("On your score not exists money");
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
    }

    /**
     * Метод, удаляющий транзакцию.
     */
    @Override
    public void DeleteTransaction() {
        ScoreTo.Money -= Money;
        ScoreFrom.Money += Money;
    }
}
