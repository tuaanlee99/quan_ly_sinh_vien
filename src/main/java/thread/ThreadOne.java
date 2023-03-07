package thread;

import DAO.StudentDAO;
import model.Student;

import java.util.Queue;

public class ThreadOne extends Thread{

    public String addStudent(String name, int age, String className, String code, String address, float mark){
        String result = null;
        StudentDAO studentDAO = new StudentDAO();
        Queue<Student> studentQueue = studentDAO.getStudents();
        Student student = new Student(name, age, className, code, address, mark);
        if(studentQueue.add(student)){
            studentDAO.addStudent(name, age, className, code, address, mark);
            result = "Thành công";
        }else {
            result = "Thêm sinh viên không hợp lệ";
        }
        return result;
    }

}
