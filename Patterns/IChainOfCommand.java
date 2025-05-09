package Patterns;

public interface IChainOfCommand<InputClass, OutputClass> {
    public IChainOfCommand<InputClass, OutputClass> getNext();

    public OutputClass handle(InputClass input);
}