package Services.Generic;

public class CryptographyService {
    public CryptographyService() {
        super();
    }

    public Object encrypt(Object data) {
        System.out.println("CryptographyService: Encrypting data..."); 
        return data; 
    }
    public Object decrypt(Object data) {
        System.out.println("CryptographyService: Decrypting data..."); 
        return data; 
    }
}
