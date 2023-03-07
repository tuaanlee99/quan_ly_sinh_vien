package thread;


import DAO.StudentDAO;
import model.Student;

import java.util.Queue;

public class ThreadTwo implements Runnable{

    public Queue<Student> allStudents(){
        StudentDAO studentDAO = new StudentDAO();
        return studentDAO.getStudents();
    }
    @Override
    public void run() {
        for (Student student: allStudents()) {
            System.out.println(student.toString());
        }
    }
}
