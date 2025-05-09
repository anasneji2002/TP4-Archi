package Patterns;

import java.util.ArrayList;

public interface IObservable {
    default void addSubscriber(IObserver observer, ArrayList<IObserver> observers) {
        observers.add(observer);
    }

    default void removeSubscriber(IObserver observer, ArrayList<IObserver> observers) {
        observers.remove(observer);
    }

    default void notifySubscribers(Object args, ArrayList<IObserver> observers) {
        for (IObserver observer : observers) {
            observer.update(args);
        }
    }
}
