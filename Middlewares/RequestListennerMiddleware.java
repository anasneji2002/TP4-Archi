package Middlewares;

import java.util.ArrayList;

import Client.Client;
import Patterns.IChainOfCommand;
import Patterns.IObservable;
import Patterns.IObserver;
import Requests.Request;
import Responses.Response;

public class RequestListennerMiddleware extends Middleware implements IObserver, IObservable {
    public ArrayList<IObserver> observers = new ArrayList<IObserver>();
    public RequestListennerMiddleware(Client client) {
        super();
        this.subscribe(client, client.observers);
    }

    @Override
    public IChainOfCommand<Request, Response> getNext() {
        return new AuthMiddleware();
    }

    @Override
    public Response handle(Request input) {
        System.out.println("Request caught: "+ input.toString());
        return getNext().handle(input);
    }

    public void update(Object args) {
        Response response = handle(((Request)args));
        this.notifySubscribers(response, this.observers);
    }
}
