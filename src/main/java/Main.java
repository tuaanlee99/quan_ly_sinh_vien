import thread.ThreadTwo;
import webService.ClassWSImpl;
import webService.StudentWSImpl;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args){
        try {
            Endpoint.publish("http://localhost:1234/ws/students", new StudentWSImpl());
            Endpoint.publish("http://localhost:1234/ws/classes", new ClassWSImpl());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
