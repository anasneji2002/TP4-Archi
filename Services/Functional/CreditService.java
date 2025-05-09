package Services.Functional;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;
import Services.Generic.DatabaseService;
import Services.Generic.FileService;

public class CreditService implements IChainOfCommand<Request,Response> {
    private FileService fileService;
    private DatabaseService databaseService;

    public CreditService() {
        this.fileService = new FileService();
        this.databaseService = new DatabaseService();
    }

    public IChainOfCommand<Request,Response> getNext() {
        return null;
    }

    public Response handle(Request input) {
        System.out.println("CreditService: Handling request...");
        Object data = this.databaseService.getData();
        Object fileData = this.fileService.getFile();
        databaseService.addData(fileData);
        if (!this.processCredit(input, data, fileData)) {
            return new Response(1, "error: credit is too low");
        }
        return new Response(0, "success");
    };

    public boolean processCredit(Request input, Object data, Object fileData) {
        System.out.println("Processing credit...");
        return true;
    }
}
