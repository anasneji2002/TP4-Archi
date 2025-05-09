package Requests;

import Enums.ModulesEnum;

public class Request {
    public String token;
    public String ipAddress;
    public ModulesEnum destinationModule;
    public String endPoint;

    public Request() {
        this.token = "VXA29pU2qqT5LKBFLLIloTyKh2wH92Iv6hw2oftSORb1j6lQygb7boIWM0USc4gl";
        this.ipAddress = "0.0.0.0"; 
        this.destinationModule = ModulesEnum.LOAN_MANAGEMENT;
        this.endPoint = "/api/v1/loan";
    }
}
