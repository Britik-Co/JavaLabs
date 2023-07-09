package Handlers;
abstract class Handler
{
    private Handler Successor;
    public abstract void Handle(Receiver receiver);

    public Handler getSuccessor() {
        return Successor;
    }

    public void setSuccessor(Handler successor) {
        Successor = successor;
    }
}