package Client;

import java.util.ArrayList;

import Patterns.IObservable;
import Patterns.IObserver;
import Requests.Request;

public class Client implements IObservable {
    public ArrayList<IObserver> observers = new ArrayList<IObserver>();
    public Client() {
    }

    public void sendRequest() {
        System.out.println("Client: Sending request...");
        Request request = new Request();
        this.notifySubscribers(request, this.observers);
    }
}
