package DAO;

import model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ClassDAO {
    Connection connection = DAO.getConnection();

    public Queue<Class> getClasses(){
        Queue<Class> classQueue = new ArrayDeque<>();
        try{
            String sql = "Select * from class";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Class c = new Class(rs.getString("name"), rs.getString("code"));
                classQueue.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return classQueue;
    }

    public void addClass(String name, String code){
        try {
            String sql = "insert into class(name, code) values ('"+name+"','"+code+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
