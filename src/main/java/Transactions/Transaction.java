package Transactions;
import BankAccount.Account;
import Banks.Bank;

/**
 * ### Операции и транзакции
 *
 * Каждый счет должен предоставлять механизм **снятия**, **пополнения** и **перевода** денег
 * (то есть счетам нужны некоторые идентификаторы).
 *
 * Еще обязательный механизм, который должны иметь банки - **отмена транзакций**.
 * Если вдруг выяснится, что транзакция была совершена злоумышленником, то такая транзакция должна быть отменена.
 * Отмена транзакции подразумевает возвращение банком суммы обратно. Транзакция не может быть повторно отменена.
 *
 * Счёта должны хранить в себе историю совершённых над ними транзакций.
 */
public abstract class Transaction {
    /**
     * Конструктор создающий транзакции
     * @param ID
     * @param Money
     * @param ScoreFrom
     * @param ScoreTo
     * @param bank
     */
    public Transaction(int ID,int Money, Account ScoreFrom, Account ScoreTo, Bank bank ){
        this.Money = Money;
        this.Number = ID;
        this.ScoreFrom = ScoreFrom;
        this.ScoreTo = ScoreTo;
        this.bank = bank;
    }
    public int Number;
    public int Money;

    public Account ScoreFrom;

    public Account ScoreTo;

    public Bank bank;
    public boolean IsCorrect = false;

    /**
     * Метод, проверяющий корректность транзакции.
     */
    public abstract void Check();

    /**
     * Метод, добавляющий транзакцию.
     */
    public abstract void AddTransaction();

    /**
     * Метод, удаляющий транзакцию.
     */
    public abstract void DeleteTransaction();
}
