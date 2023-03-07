package DAO;

import model.HocLuc;
import model.Student;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Queue;


public class StudentDAO {
    Connection connection = DAO.getConnection();

    public Queue<Student> getStudents(){
        Queue<Student> studentQueue = new ArrayDeque<>();
        try{
            String sql = "Select * from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("className"), rs.getString("code"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public void addStudent(String name, int age, String className, String code, String address, float mark){
        String sql = "insert into student(name, age, className, code, address, mark) values('"+ name+"','"+age+"','"+className+"','"+code+"', '"+address+"', '"+mark+"')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Queue<Student> findByMark(float MIN_MARK, float MAX_MARK){
        Queue<Student> studentQueue = new ArrayDeque<>();
        try{
            String sql = "select * from student where mark beetwen '" + MIN_MARK +"'and '" + MAX_MARK+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public String findByID(int id){
        Student student = null;
        try {
            String sql = "select * from student where id ='"+ id+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );

        }catch (Exception e){
            e.printStackTrace();
        }
        return student.toString();
    }

    public void updateByID(int id, String name, int age, String className, String code, String address, float mark){
        try {
            String sql = "Update Student set name = '"+ name+"', age = '"+age+"', className = '"+className+"', code = '"+code+"', address = '"+address+"', mark = '"+mark+"' where id = '"+id+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Queue<Student> getStudentByMark_UP(){
        Queue<Student> studentQueue = new ArrayDeque<>();
        try {
            String sql = "select * from student order by mark";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public Queue<Student> getStudentByMark_DOWN(){
        Queue<Student> studentQueue = new ArrayDeque<>();
        try {
            String sql = "select * from student order by mark DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public Queue<Student> findStudent_Top5(){
        Queue<Student> studentQueue = new ArrayDeque<>();
        try {
            String sql = "select TOP 3 * from student order by mark DESC ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public Float mark_AVG(){
        Float mark_AVG = null;
        try{
            String sql = "Select AVG(mark) from student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                mark_AVG = resultSet.getFloat(1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return mark_AVG;
    }

    public Queue<Student> MARK_BIGGER_MarkAGV(){
        Queue<Student> studentQueue = new ArrayDeque<>();
        String sql = "select * from student where mark > (Select AVG(mark) from student)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

    public Queue<Student> findByHL(String hoc_Luc){
        HocLuc hocLuc = new HocLuc();
        Queue<Student> studentQueue = new ArrayDeque<>();
        hocLuc.stringToHocLuc(hoc_Luc);
        String sql = "Select * from student where mark >= '"+hocLuc.MIN_MARK+"' and mark < '"+hocLuc.MAX_MARK+"'";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("code"), rs.getString("className"), rs.getString("address"), rs.getFloat("mark") );
                studentQueue.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentQueue;
    }

}

