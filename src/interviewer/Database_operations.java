/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewer;
import java.sql.*;
/**
 *
 * @author Aayush
 */
public class Database_operations 
{
    void read() throws SQLException, ClassNotFoundException
    {
        System.out.println("executed 5.1\n");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("executed 5.2\n");
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/intercode","root","kashyap@99");
        System.out.println("executed 5.3\n");
        Statement stmt=con.createStatement();  
        System.out.println("executed 5.4\n");
        String query;
        query="select * from student;";        
        System.out.println("executed 5.5\n");
        System.out.println(query);
        stmt.executeUpdate(query);
    }
    void write(Student_initials si) throws SQLException, ClassNotFoundException
    {
        System.out.println("executed 5.1\n");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("executed 5.2\n");
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/intercode","root","kashyap@99");
        System.out.println("executed 5.3\n");
        Statement stmt=con.createStatement();  
        System.out.println("executed 5.4\n");
        String query;
        query="insert into student values('"+si.clg+"','"+si.reg_no+"','"+si.name+"','"+si.branch+"',"+si.score+",'"+si.notes+"');";        
        System.out.println("executed 5.5\n");
        System.out.println(query);
        stmt.executeUpdate(query);  
    }
}
