package Middlewares;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;

public class AuthMiddleware extends Middleware {
    public AuthMiddleware() {
        super();
    }

    @Override
    public IChainOfCommand<Request, Response> getNext() {
        return new IPFilterMiddleware();
    }

    @Override
    public Response handle(Request input) {
        System.out.println("Checking token validity...");
        if (!this.isTokenValid(input.token))
            return new Response(403, "forbidden");
        return this.getNext().handle(input);
    }

    private boolean isTokenValid(String token) {
        return true;
    }
}
