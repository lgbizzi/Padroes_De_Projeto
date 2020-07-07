/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

/**
 *
 * @author Luís Guilherme Ferreira Bizzi
 */

// Cloudscape concrete DAO Factory implementation
import java.sql.*;

public abstract class CloudscapeDAOFactory extends DAOFactory {
  public static final String DRIVER=
    "COM.cloudscape.core.RmiJdbcDriver";
  public static final String DBURL=
    "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

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
