package Middlewares;

import java.util.ArrayList;

import Enums.ModulesEnum;
import Modules.LoanManagementModule;
import Modules.Module;
import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;
public class LoadBalancerMiddleware extends Middleware {
    private ArrayList<Module> modules;
    
    public LoadBalancerMiddleware() {
        this.modules = new ArrayList<>();
    }

    public LoadBalancerMiddleware setLoadBalancerModules(ModulesEnum module) {
        switch (module) {
            case LOAN_MANAGEMENT:
                this.modules = new ArrayList<>();
                this.modules.add(new LoanManagementModule());
                this.modules.add(new LoanManagementModule());
                this.modules.add(new LoanManagementModule());
                break;
        
            default:
                this.modules = null;
                break;
        }
        return this;
    }

    @Override
    public IChainOfCommand<Request, Response> getNext() {
        return null;
    }

    @Override
    public Response handle(Request input) {
        System.out.println("Load Balancer Middleware: Distributing request to the appropriate module...");
        Module module = getAvailableModule();
        return module.handle(input);
    }

    private Module getAvailableModule() {
        // get a random module from the list of modules
        int randomIndex = (int) (Math.random() * modules.size());
        Module module = modules.get(randomIndex);
        return module;
    }
}
