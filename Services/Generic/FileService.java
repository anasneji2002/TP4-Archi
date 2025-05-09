package Services.Generic;

public class FileService {
    public FileService() {
        super();
    }

    public Object getFile() {
        System.out.println("FileService: Getting file..."); 
        return null; 
    }

    public void addFile(Object data) { 
        System.err.println("FileService: Adding file: " + data);
    }
}
