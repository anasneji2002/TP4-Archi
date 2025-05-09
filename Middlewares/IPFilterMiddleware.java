package Middlewares;

import java.util.List;
import java.util.ArrayList;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;

public class IPFilterMiddleware extends Middleware {
    private List<String> allowedIPs;

    public IPFilterMiddleware() {
        this.allowedIPs = new ArrayList<String>();
        this.allowedIPs.add("0.0.0.0");
    }

    @Override
    public IChainOfCommand<Request, Response> getNext() {
        return new LoadBalancerMiddleware();
    }

    @Override
    public Response handle(Request input) {
        System.out.println("checking if the input IP is allowed");
        if (isIPAddressAllowed(input.ipAddress)) {
            System.out.println("IP is allowed");
            return ((LoadBalancerMiddleware)getNext()).setLoadBalancerModules(input.destinationModule).handle(input);
        } else {
            System.out.println("IP is not allowed");
            return new Response(403, "Forbidden");
        }
    }

    public boolean isIPAddressAllowed(String ip) {
        return allowedIPs.contains(ip);
    }
}