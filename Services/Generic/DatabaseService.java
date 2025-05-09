package Services.Generic;

public class DatabaseService {
    private CryptographyService cryptographyService;

    public DatabaseService() {
        this.cryptographyService = new CryptographyService();
    }

    public Object getData() { 
        return this.cryptographyService.decrypt("data"); 
    }

    public void addData(Object data) { 
        Object encryptedData = this.cryptographyService.encrypt(data);
        System.err.println("DatabaseService: Adding data: " + encryptedData);
    }
}
