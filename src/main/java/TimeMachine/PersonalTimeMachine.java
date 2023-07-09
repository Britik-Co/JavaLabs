package TimeMachine;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Класс помогающий показать состояние счета в определенный день.
 */
public class PersonalTimeMachine {
    /**
     * Конструктор
     * @param Money
     * @param StartDay
     * @param ComissionMoney
     */
    public PersonalTimeMachine(int Money, Date StartDay, float ComissionMoney){
        FutureMoney = Money;
        this.StartDay = StartDay;
        this.ComissionMoney = ComissionMoney;
    }
    public float FutureMoney;
    public Date StartDay;

    public float ComissionMoney;

    /**
     * Метод, показывающий состояние счета в определенную дата.
     * @param EndDate
     * @return
     */
    public float StartMachine(Date EndDate){
        long NumDay = TimeUnit.DAYS.convert(Math.abs(StartDay.getTime() - EndDate.getTime()), TimeUnit.MILLISECONDS);
        FutureMoney = (FutureMoney * (ComissionMoney/365) * NumDay);
        System.out.println("Остаток на вашем счете равен");
        System.out.println((int)FutureMoney);
        return FutureMoney;
    }
}
