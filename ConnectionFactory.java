package main;

/**
 *
 * @author Luís Guilherme Ferreira Bizzi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection(){
		/*TENTA CONECTAR COM O BANCO*/
        try {
            return DriverManager.getConnection("jdbc:sqlite:C:/Users/Gui/Desktop/Unaerp/Padroes de Projeto de Software/Exame/Northwind/northwind.sql");
			//System.out.println("Conectado com sucesso!!");
        }
		
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}