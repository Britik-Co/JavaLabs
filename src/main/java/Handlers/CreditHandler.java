package Handlers;

public class CreditHandler extends Handler{
    @Override
    public void Handle(Receiver receiver)
    {
        if (receiver.CreditA == true)
            System.out.println("Выполняем банковский перевод");
        else if (getSuccessor() != null)
            getSuccessor().Handle(receiver);
    }
}
