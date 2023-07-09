package Banks;

import BankAccount.Account;
import Clients.Client;
import Expections.ClientExpection;
import java.util.ArrayList;
import java.util.List;

/**
 *  Обновление условий счетов
 *
 * Для банков требуется реализовать методы изменений процентов и лимитов не перевод.
 * Также требуется реализовать возможность пользователям подписываться на информацию о таких изменениях -
 * банк должен предоставлять возможность клиенту подписаться на уведомления. Стоит продумать расширяемую систему,
 * в которой могут появится разные способы получения нотификаций клиентом (да, да, это референс на тот самый сайт).
 * Например, когда происходит изменение лимита для кредитных карт - все пользователи, которые подписались и имеют кредитные
 * карты, должны получить уведомление.
 */
public class Bank {
    public String Name;
    public float[] DepositePersents = new float[3];
    public float CreditPersents;
    public float DebitPersents;
    public List<Client> Clients = new ArrayList();
    public List<Account> Accounts = new ArrayList();

    /**
     * Метод, котороый добавляет клиента в банк.
     * @param owner
     */
    public void AddClient(Client owner) {
        if (!Clients.contains(owner))
            Clients.add(owner);
        else
            try {
                throw new ClientExpection("This Client already exists");
            } catch (ClientExpection e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * Метод, который позволяет создать аккаунт в банке.
     * @param score
     * @return
     */
    public Account CreateAccount(Account score) {
        if (!Accounts.contains(score))
            Accounts.add(score);
        else
            try {
                throw new ClientExpection("This Account already exists");
            } catch (ClientExpection e) {
                throw new RuntimeException(e);
            }
            return score;
    }
}
