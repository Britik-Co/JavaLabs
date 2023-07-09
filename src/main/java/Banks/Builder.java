package Banks;

abstract class Builder {
    public abstract void SetName(String Name);
    public abstract void SetCreditPercents(float Percents);
    public abstract void SetDebitPercents(float Percents);
    public abstract void SetDepositePercents(float[] Percents);
    public abstract Bank GetResult();
}
