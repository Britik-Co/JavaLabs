package Banks;

public class BankBuilder extends Builder {
    Bank bank = new Bank();

    @Override
    public void SetName(String Name) {
        bank.Name = Name;
    }

    @Override
    public void SetCreditPercents(float Percents) {
        bank.CreditPersents = Percents;
    }

    @Override
    public void SetDebitPercents(float Percents) {
        bank.DebitPersents = Percents;
    }

    @Override
    public void SetDepositePercents(float[] Percents) {
        bank.DepositePersents = Percents;
    }

    @Override
    public Bank GetResult() {
        return bank;
    }
}
