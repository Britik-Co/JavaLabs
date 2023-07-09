package Handlers;

public class DebitHandler extends Handler{
    @Override
    public void Handle(Receiver receiver)
    {
        if (receiver.DebitA== true)
            System.out.println("Выполняем банковский перевод");
        else if (getSuccessor() != null)
            getSuccessor().Handle(receiver);
    }
}
