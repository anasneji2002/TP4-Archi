package Middlewares;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;

public abstract class Middleware implements IChainOfCommand<Request, Response> {
    public Response execute(Request input) {
        System.out.println(String.format("executing %s Middleware...", this.getClass().getName()));
        return this.handle(input);
    }
}
