package Transactions;

import BankAccount.Account;
import Banks.Bank;

public class CreditTransaction extends Transaction{
    /**
     * Конструктор
     * @param ID
     * @param Money
     * @param ScoreFrom
     * @param ScoreTo
     * @param bank
     */
    public CreditTransaction(int ID, int Money, Account ScoreFrom, Account ScoreTo, Bank bank) {
        super(ID, Money, ScoreFrom, ScoreTo, bank);
    }

    /**
     * Метод, проверяющий корректность транзакции.
     */
    @Override
    public void Check() {}
    /**
     * Метод, добавляющий транзакцию.
     */
    @Override
    public void AddTransaction() {
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
