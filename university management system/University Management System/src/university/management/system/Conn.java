package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection connection;
    Statement statement;

    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///universitymanagement","root","Sushanth@99");
            statement = connection.createStatement();
            System.out.println("Database connected successfully!");

        }
        catch(Exception e)
        {
            System.out.println("Database  not connected successful!");
            e.printStackTrace();
        }
    }
}
