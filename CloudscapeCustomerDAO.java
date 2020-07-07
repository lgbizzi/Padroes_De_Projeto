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
// CloudscapeCustomerDAO implementation of the 
// CustomerDAO interface. This class can contain all
// Cloudscape specific code and SQL statements. 
// The client is thus shielded from knowing 
// these implementation details.

import java.sql.*;

public class CloudscapeCustomerDAO extends CustomerDAO{
  
  public CloudscapeCustomerDAO() {
    this.conexao = CloudscapeDAOFactory.getConnection();
  }

  // The following methods can use
  // CloudscapeDAOFactory.createConnection() 
  // to get a connection as required

  public int insertCustomer(Customer consumidor) {
    // Implement insert customer here.
    // Return newly created customer number
    // or a -1 on error

        /*DEFINE A QUERY SQL*/
        String insere_consumidor;
        insere_consumidor = "INSERT INTO `customers` (`id`, `company`, `last_name`, `first_name`, `email_address`, `job_title`, `business_phone`, `home_phone`, `mobile_phone`, `fax_number`, `address`, `city`, `state_province`, `zip_postal_code`, `country_region`, `web_page`, `notes`, `attachments`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
        try(
            /*PREPARA A DECLARACAO PARA A INSERCAO*/
            PreparedStatement cliente = conexao.prepareStatement(insere_consumidor);)
        
        {         
            cliente.setInt(1, consumidor.getId());
            cliente.setString(2, consumidor.getCompany());
            cliente.setString(3, consumidor.getLast_name());
            cliente.setString(4, consumidor.getFirst_name());
            cliente.setString(5, consumidor.getEmail_address());
            cliente.setString(6, consumidor.getJob_title());
            cliente.setString(7, consumidor.getBusiness_phone());
            cliente.setString(8, consumidor.getHome_phone());
            cliente.setString(9, consumidor.getMobile_phone());
            cliente.setString(10, consumidor.getFax_number());
            cliente.setString(11, consumidor.getAddress());
            cliente.setString(12, consumidor.getCity());
            cliente.setString(13, consumidor.getState_province());
            cliente.setString(14, consumidor.getZip_postal_code());
            cliente.setString(15, consumidor.getCountry_region());
            cliente.setString(16, consumidor.getWeb_page());
            cliente.setString(17, consumidor.getNotes());
            cliente.setString(18, consumidor.getAttachments());
            
            cliente.execute();
            cliente.close();
            
            System.out.println("/nCliente criado com sucesso!");
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return consumidor.getId();
  }
  
  public boolean deleteCustomer(Customer consumidor) {
    // Implement delete customer here
    // Return true on success, false on failure
    String remove_cliente = "DELETE FROM Customer WHERE id=?";
        
        try(PreparedStatement cliente = conexao.prepareStatement(remove_cliente)){
            cliente.setLong(1, consumidor.getId());
            
            cliente.execute();
            cliente.close();
            return true;
            
        } catch (SQLException e){
            return false;            
        }    
  }

  /*public Customer findCustomer(...) {
    // Implement find a customer here using supplied
    // argument values as search criteria
    // Return a Transfer Object if found,
    // return null on error or if not found
  }*/

  public boolean updateCustomer(Customer consumidor) {
    // implement update record here using data
    // from the customerData Transfer Object
    // Return true on success, false on failure or
    // error
    String altera_cliente;
        altera_cliente = "UPDATE Customer SET company=?, last_name=?, first_name=?, email_address=?, job_title=?, business_phone=?, home_phone=?, mobile_phone=?, fax_number=?, address=?, city=?, state_province=?, zip_postal_code=?, country_region=?,  web_page=?, notes=?, attachments=? WHERE id=?";
        
        try(PreparedStatement cliente = conexao.prepareStatement(altera_cliente)){
            
            /*ATRIBUI OS VALORES*/
            cliente.setInt(1, consumidor.getId());
            cliente.setString(2, consumidor.getCompany());
            cliente.setString(3, consumidor.getLast_name());
            cliente.setString(4, consumidor.getFirst_name());
            cliente.setString(5, consumidor.getEmail_address());
            cliente.setString(6, consumidor.getJob_title());
            cliente.setString(7, consumidor.getBusiness_phone());
            cliente.setString(8, consumidor.getHome_phone());
            cliente.setString(9, consumidor.getMobile_phone());
            cliente.setString(10, consumidor.getFax_number());
            cliente.setString(11, consumidor.getAddress());
            cliente.setString(12, consumidor.getCity());
            cliente.setString(13, consumidor.getState_province());
            cliente.setString(14, consumidor.getZip_postal_code());
            cliente.setString(15, consumidor.getCountry_region());
            cliente.setString(16, consumidor.getWeb_page());
            cliente.setString(17, consumidor.getNotes());
            cliente.setString(18, consumidor.getAttachments());
            
            /*EXECUTA A QUERY*/
            cliente.execute();
            cliente.close();
            return true;
        } catch (SQLException e){
            return false;
        }
    
  }

  public void selectCustomersTO() throws SQLException {
    // implement search customers here using the
    // supplied criteria.
    // Alternatively, implement to return a Collection 
    // of Transfer Objects.
    /*PREPARA A DECLARAÇÃO PARA O SELECT*/
	PreparedStatement cliente = conexao.prepareStatement("SELECT * FROM Customer");
		
	/*EXECUTA UM SELECT
		O ResultSet permito que a gente navegue pelos seus registros através do método next.
		Esse método será nulo quando chegar no fim.
	*/
	ResultSet resultado = cliente.executeQuery();
	
	/*ITERA NO ResultSet UTILIZADO, PARA ENQUANTO O PRÓXIMO NÃO FOR NULO*/
	while(resultado.next()){
	}
		
	resultado.close();
	cliente.close();
	conexao.close();
    }
}
