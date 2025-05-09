package Patterns;

import java.util.ArrayList;

public interface IObserver {
    default void subscribe(IObservable observable, ArrayList<IObserver> observers) {
        observable.addSubscriber(this, observers);
    }

    default void unsubscribe(IObservable observable, ArrayList<IObserver> observers) {
        observable.removeSubscriber(this, observers);
    }

    public void update(Object arg);
}
