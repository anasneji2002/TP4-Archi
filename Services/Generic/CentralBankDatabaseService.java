package Services.Generic;

public class CentralBankDatabaseService {
    private CryptographyService cryptographyService;
    public CentralBankDatabaseService() {
        this.cryptographyService = new CryptographyService();
    }

    public Object getData() { 
        return this.cryptographyService.decrypt("bank data"); 
    }
}