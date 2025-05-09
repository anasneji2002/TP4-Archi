package Modules;

import Requests.Request;
import Responses.Response;

public abstract class Module {
    public abstract Response handle(Request input);
}
