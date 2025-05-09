package Modules;

import Requests.Request;
import Responses.Response;
import Services.Functional.CommercialService;

public class LoanManagementModule extends Module {
    private CommercialService commercialService;

    public LoanManagementModule() {
        this.commercialService = new CommercialService();
    }

    @Override
    public Response handle(Request input) {
        System.out.println("LoanManagementModule: Handling request...");
        return commercialService.handle(input);
    }
}
