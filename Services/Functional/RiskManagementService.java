package Services.Functional;

import Patterns.IChainOfCommand;
import Requests.Request;
import Responses.Response;
import Services.Generic.CentralBankDatabaseService;
import Services.Generic.DatabaseService;
import Services.Generic.NotificationService;
import Services.Generic.OCRService;

public class RiskManagementService implements IChainOfCommand<Request,Response> {
    private OCRService ocrService;
    private DatabaseService databaseService;
    private CentralBankDatabaseService centralBankDatabaseService;
    private NotificationService notificationService;

    public RiskManagementService() {
        this.ocrService = new OCRService();
        this.databaseService = new DatabaseService();
        this.centralBankDatabaseService = new CentralBankDatabaseService();
        this.notificationService = new NotificationService();
    }

    public IChainOfCommand<Request,Response> getNext() {
        return new CreditService();
    }

    public Response handle(Request input) {
        System.out.println("RiskManagementService: Handling request...");
        Object data = this.databaseService.getData();
        Object ocrData = this.ocrService.scanFile(data);
        databaseService.addData(ocrData);
        Object bankData = this.centralBankDatabaseService.getData();
        if (!this.processRisk(input, data, bankData)) {
            return new Response(1, "error: risk is too high");
        }
        notificationService.sendNotification();
        return this.getNext().handle(input);
    }

    public boolean processRisk(Request input, Object data, Object bankData) {
        System.out.println("Processing risk...");
        return true;
    }
}
