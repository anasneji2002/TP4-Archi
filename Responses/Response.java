package Responses;

public class Response {
    public int resultCode;
    public String message;
    public Response(int resultCode, String message) {
        this.message = message;
        this.resultCode = resultCode;
    }
}
