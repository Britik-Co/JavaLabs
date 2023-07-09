import BankAccount.Account;
import BankAccount.Debit;
import BankAccount.Deposit;
import Banks.Bank;
import Banks.CentralBank;
import Clients.Client;
import Clients.Name;
import Clients.Passport;
import Expections.ClassExeption;
import Transactions.DebitTransaction;
import Transactions.Transaction;
import org.junit.Before;
import org.junit.Test;
import BankAccount.Credit;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BankTest {
    public CentralBank mainBank;
    @Before
    public void initTest() {
        CentralBank mainBank = CentralBank.getInstance();
    }

    @Test
    public void TestSystems(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.CreateBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.AddBank(sber);
        Client el = mainBank.CreateClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.AddClient(el, sber);
        Deposit score1 = new Deposit(1, new Date(), new Date(13012025), 100000, sber);
        mainBank.AddAccount(score1, sber);

        assertEquals("SberBank",mainBank.Banks.get(0).Name);

        assertEquals("Элиза", mainBank.Clients.get(0).FullName.FirstName);

        assertEquals("Бритикова", sber.Clients.get(0).FullName.SecondName);

        assertEquals(1, mainBank.Accounts.size());
    }

    @Test
    public void TestTransaction(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.CreateBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.AddBank(sber);
        Client el = mainBank.CreateClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.AddClient(el, sber);
        Debit score1 = new Debit(1, new Date(), new Date(13012025), 100000, sber);
        mainBank.AddAccount(score1, sber);

        Debit score2 = new Debit(2, new Date(), new Date(13012025), 100000, sber);
        DebitTransaction transfer1  = new DebitTransaction(1, 10230, score1, score2,sber);
        el.AddTransaction(transfer1);

        assertEquals(89770, score1.Money);
        assertEquals(110230, score2.Money);

        el.DeleteTransaction(transfer1);
        assertEquals(score1.Money, score2.Money);

    }

    @Test
    public void TestTimeMachine(){
        CentralBank mainBank = CentralBank.getInstance();
        Bank sber = mainBank.CreateBank("SberBank", 3.1F, 400.0F, new float[]{3.0F, 3.5F, 4.0F});
        mainBank.AddBank(sber);
        Client el = mainBank.CreateClient(new Name("Элиза","Бритикова"), new Date(17032003), new Passport(4523, 234567));
        mainBank.AddClient(el, sber);
        Debit score1 = new Debit(1, new Date(), new Date(13012025), 100, sber);
        mainBank.AddAccount(score1, sber);

        assertEquals(2142137, score1.GoToFuture(new Date(9072024)), 100);
    }

}

