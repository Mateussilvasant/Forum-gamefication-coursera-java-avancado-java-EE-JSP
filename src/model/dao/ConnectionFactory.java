package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory
{
    static
    {
	try
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e)
	{
	    Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, e.getMessage());
	}
    }

    public static Connection getConnection() throws SQLException
    {
	return DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/forumappbd?useTimezone=true&useSSL=false&serverTimezone=America/Sao_Paulo",
		"root", "pass123");
    }
}
