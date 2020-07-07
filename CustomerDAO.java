package main;

/**
 *
 * @author Luís Guilherme Ferreira Bizzi
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends Customer{ 
    /*FAZ A CONEXAO COM O BANCO DE DADOS*/
    private Connection conexao;
    
    public CustomerDAO(){
        this.conexao = ConnectionFactory.getConnection();
    }
    
    public void insere(Customer consumidor){
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
            
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    public void seleciona() throws SQLException{
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
    
    public void altera(Customer consumidor){
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
        } catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
    
    public void remove(Customer consumidor){
        String remove_cliente = "DELETE FROM Customer WHERE id=?";
        
        try(PreparedStatement cliente = conexao.prepareStatement(remove_cliente)){
            cliente.setLong(1, consumidor.getId());
            
            cliente.execute();
            cliente.close();
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }    
}
