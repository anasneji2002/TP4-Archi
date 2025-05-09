import Client.Client;
import Interceptors.ResponseInterceptor;
import Middlewares.RequestListennerMiddleware;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        RequestListennerMiddleware listenerMiddleware = new RequestListennerMiddleware(client);
        ResponseInterceptor responseInterceptor = new ResponseInterceptor(listenerMiddleware);
        client.sendRequest();
    }
}
