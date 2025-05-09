package Interceptors;

import Middlewares.RequestListennerMiddleware;
import Responses.Response;

public class ResponseInterceptor extends Interceptor {
    public ResponseInterceptor(RequestListennerMiddleware requestListennerMiddleware) {
        super();
        this.subscribe(requestListennerMiddleware, requestListennerMiddleware.observers);
    }
    
    @Override
    public void OnIntercept(Object arg) {
        System.out.println("ResponseInterceptor: Response resultcode: " + ((Response)arg).resultCode + " - Response message: " + ((Response)arg).message);
    }
}
