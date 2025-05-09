package Services.Functional;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;
import Services.Generic.DatabaseService;
import Services.Generic.OCRService;

public class CommercialService implements IChainOfCommand<Request, Response> {
    private OCRService ocrService;
    private DatabaseService databaseService;
    
    public CommercialService() {
        this.databaseService = new DatabaseService();
        this.ocrService = new OCRService();
    }

    public IChainOfCommand<Request, Response> getNext() {
        return new RiskManagementService();
    }

    public Response handle(Request input) {
        // do stuff
        System.out.println("CommercialService: Handling request...");
        Object data = this.databaseService.getData();
        Object ocrData = this.ocrService.scanFile(data);
        databaseService.addData(ocrData);
        int score = this.getUserScore(input);
        if (score < 0) {
            return new Response(1, "error: score is too low");
        }
        return this.getNext().handle(input);
    }

    public int getUserScore(Request input) {
        return 500;
    }
}
