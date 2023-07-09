package Banks;

import BankAccount.Account;
import Clients.Client;
import Clients.ClientBuilder;
import Clients.Name;
import Clients.Passport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ### Центральный банк
 *
 * Регистрацией всех банков, а также взаимодействием между банками занимается центральный банк.
 * Он должен управлять банками (предоставлять возможность создать банк) и предоставлять необходимый функционал,
 * чтобы банки могли взаимодействовать с другими банками (например, можно реализовать переводы между банками через него).
 * Он также занимается уведомлением других банков о том, что нужно начислять остаток или комиссию -
 * для этого механизма не требуется создавать таймеры и завязываться на реальное время.
 */
public class CentralBank {
    /**
     * Паттерн одиночка
     */
    private static CentralBank instance;

    private CentralBank(){}

    /**
     *
     * @return
     */
    public static CentralBank getInstance(){
        if(instance == null){
            instance = new CentralBank();
        }
        return instance;
    }
    public List<Client> Clients = new ArrayList();
    public List<Account> Accounts = new ArrayList();
    public List<Bank> Banks = new ArrayList();

    /**
     * Метод создает клиента.
     * @param fullName
     * @param Birth
     * @param number
     * @return
     */
    public Client CreateClient(Name fullName, Date Birth, Passport number){
        ClientBuilder builder = new ClientBuilder();
        builder.SetBirthDay(Birth);
        builder.SetFullName(fullName);
        builder.SetPassport(number);
        return builder.GetResult();
    }

    /**
     * Метод добавляет клиента в банковскую систему.
     * @param owner
     * @param bank
     * @return
     */
    public Client AddClient(Client owner, Bank bank){
        bank.AddClient(owner);
        Clients.add(owner);
        return owner;
    }

    /**
     * Метод создает банк в банковской системе.
     * @param Name
     * @param credit
     * @param debit
     * @param deposit
     * @return
     */
    public Bank CreateBank(String Name,float credit, float debit, float[] deposit ){
        BankBuilder builder = new BankBuilder();
        builder.SetName(Name);
        builder.SetCreditPercents(credit);
        builder.SetDebitPercents(debit);
        builder.SetDepositePercents(deposit);
        return builder.GetResult();
    }

    /**
     * Метод добавляет банк в банковскую систему.
     * @param bank
     */
    public void AddBank(Bank bank) {
        if (!Banks.contains(bank))
            Banks.add(bank);
        else {
            try {
                throw new Exception("This bank already exists");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Метод доавляет аккаунт в банковскую систему.
     * @param account
     * @param bank
     */
    public void AddAccount(Account account, Bank bank){
        bank.CreateAccount(account);
        Accounts.add(account);
    }

    /**
     * Метод списывает проценты.
     */
    public void AccrualOfInterest(){
        for( int i = 0; i < Accounts.size(); i++)
            Accounts.get(i).AccrualOfInterest();
    }
}
