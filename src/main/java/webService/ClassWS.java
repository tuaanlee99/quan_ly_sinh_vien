package webService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Queue;

@WebService
public interface ClassWS {
    @WebMethod
    String addClass(String name, String code);
}
