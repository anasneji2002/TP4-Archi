package Interceptors;

import Patterns.IObserver;

public abstract class Interceptor implements IObserver {
    @Override
    public void update(Object arg) {
        OnIntercept(arg);
    }

    public abstract void OnIntercept(Object arg);
}
