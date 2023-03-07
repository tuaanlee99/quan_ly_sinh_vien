package webService;

import model.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Queue;

@WebService
public interface StudentWS {
    @WebMethod
    public Queue<Student> findAll();

    String addStudentFake(String username,String password, String name,int age, String code, String className,String address, float mark);
    @WebMethod
    String addStudent(String username,String password, String name,int age, String code, String className,String address, float mark);
    @WebMethod
    public Queue<Student> findByMark(float MARK_MIN,float MARK_MAX);
    @WebMethod
    String findByID(int id);
    @WebMethod
    String UpdateByID(int id, String name,int age, String className, String code, String address, float mark);
    @WebMethod
    public Queue<Student> findAll_MARK_UP();
    @WebMethod
    public Queue<Student> findAll_MARK_DOWN();
    @WebMethod
    public Queue<Student> find_MARK_Top_5();
    @WebMethod
    float Mark_AGV();
    @WebMethod
    public Queue<Student>  MARK_BIGGER_MarkAGV();
    @WebMethod
    public Queue<Student> findByHL(String hoc_Luc);

}
