package webService;

import DAO.ClassDAO;
import DAO.StudentDAO;
import config.ReadFile;
import model.Class;
import model.Student;
import thread.ThreadOne;
import thread.ThreadTwo;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Queue;

@WebService(endpointInterface = "webService.StudentWS")
public class StudentWSImpl implements StudentWS{

    StudentDAO studentDAO = new StudentDAO();
    ThreadTwo threadTwo = new ThreadTwo();
    @Override
    public Queue<Student> findAll() {
        return studentDAO.getStudents();
    }

    @Override
    public String addStudentFake(String username, String password, String name, int age, String className, String code, String address, float mark) {
        ReadFile readFile = new ReadFile();

        String result = null;
        if (readFile.check_username_password(username, password)){
            StudentDAO studentDAO = new StudentDAO();
            Queue<Student> studentQueue = studentDAO.getStudents();
            Student student = new Student(name, age, className, code, address, mark);
            if(studentQueue.add(student)){
                studentDAO.addStudent(name, age, className, code, address, mark);
                result = "Thành công";
            }else {
                result = "Thêm sinh viên không hợp lệ";
            }
        }else {
            result="username/password khong hop le";
        }
        return result;
    }

    @Override
    public String addStudent(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "name") String name,
                             @WebParam(name = "age") int age, @WebParam(name = "className") String className, @WebParam(name = "code") String code,
                             @WebParam(name = "address") String address, @WebParam(name = "mark") float mark) {
        String result = null;
        boolean className_value = false;
        ClassDAO classDAO = new ClassDAO();
        Queue<Class> classQueue = classDAO.getClasses();
        ReadFile readFile = new ReadFile();
        ThreadOne threadOne = new ThreadOne();


        if (readFile.check_username_password(username, password)){
            for(Class c: classQueue){
                if(c.getName().equals(className))
                    className_value = true;
            }
            if(!className_value){
                ClassWSImpl classWS = new ClassWSImpl();
                classWS.addClass(className, code);
            }
            result = threadOne.addStudent(name, age, className, code, address, mark);
        }else {
            result="username/password khong hop le";
        }
        return result;
    }

    @Override
    public Queue<Student> findByMark(@WebParam float MARK_MIN,@WebParam float MARK_MAX) {
        return studentDAO.findByMark(MARK_MIN, MARK_MAX);
    }

    @Override
    public String findByID(@WebParam int id) {
        return studentDAO.findByID(id);
    }

    @Override
    public String UpdateByID(@WebParam int id,@WebParam String name,@WebParam int age,@WebParam String className,@WebParam String code,@WebParam String address,@WebParam float mark) {
        String result = null;
        Queue<Student> studentQueue = threadTwo.allStudents();
        Student student = new Student(name, age, code, className, address, mark);
        if(studentQueue.add(student)){
            result = "Thành công";
            studentDAO.updateByID(id, name, age, className, code, address, mark);
        }else{
            result = "update không thành công";
        }
        return result;
    }

    @Override
    public Queue<Student> findAll_MARK_UP() {
        return studentDAO.getStudentByMark_UP();
    }

    @Override
    public Queue<Student> findAll_MARK_DOWN() {
        return studentDAO.getStudentByMark_DOWN();
    }

    @Override
    public Queue<Student> find_MARK_Top_5() {
        return studentDAO.findStudent_Top5();
    }

    @Override
    public float Mark_AGV() {
        return studentDAO.mark_AVG();
    }

    @Override
    public Queue<Student> MARK_BIGGER_MarkAGV() {
        return studentDAO.MARK_BIGGER_MarkAGV();
    }

    @Override
    public Queue<Student> findByHL(@WebParam String hoc_Luc) {
        return studentDAO.findByHL(hoc_Luc);
    }
}
