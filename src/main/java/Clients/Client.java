package Clients;

import Transactions.DebitTransaction;
import Transactions.Transaction;

import javax.xml.crypto.Data;
import java.util.Date;

public class Client {
    public Name FullName;
    public Date BirthDay;
    public Passport Passport;

    /**
     * Метод добавляет транзакцию.
     * @param transfer
     */
    public void AddTransaction(Transaction transfer) {
        transfer.AddTransaction();
        System.out.println("Trasaction complited Sucsses");
    }

    /**
     * Метод удаляет транзакцию.
     * @param transfer
     */
    public void DeleteTransaction(Transaction transfer){
        transfer.DeleteTransaction();
        System.out.println("Trasaction deleted Sucsses");
    }

}
