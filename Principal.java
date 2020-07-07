package main;

/**
 *
 * @author Luís Guilherme Ferreira Bizzi
 */

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    public static void main(String[]args) throws SQLException{
    
        Scanner op = new Scanner(System.in);
        int esc;
        System.out.println("Digite o que quer fazer: 1 - Insert /n2 - Select /n3 - Update /n4 - Delete");
        esc = op.nextInt();
        
        switch(esc){
            case 1:{
                /*VALORES PARA INSERIR*/
                Customer consumidor = new Customer();
                
                consumidor.setId(30);
                consumidor.setCompany("Empresa Companhia Corporativa LTDA");
                consumidor.setLast_name("Oliveira Silva");
                consumidor.setFirst_name("Joaquim");
                consumidor.setEmail_address("quinzinho_padeiro@gmail.com");
                consumidor.setJob_title("Padeiro");
                consumidor.setBusiness_phone("(16) 8765-4726");
                consumidor.setHome_phone("");
                consumidor.setMobile_phone("");
                consumidor.setFax_number("");
                consumidor.setAddress("Rua dos Alfeneiros, 2");
                consumidor.setCity("Ribeirao Preto");
                consumidor.setState_province("Sao Paulo");
                consumidor.setZip_postal_code("14076-000");
                consumidor.setCountry_region("Brasil");
                consumidor.setWeb_page("https://paozinhodojoaquim.top.br");
                consumidor.setNotes("Cliente VIP");
                consumidor.setAttachments("");
                
                /*DEFINE A CONEXÃO QUE É PARA USAR*/
                CloudscapeCustomerDAO cliente = new CloudscapeCustomerDAO();
                
                /*INSERE OS DADOS DE UM NOVO CLIENTE*/
                cliente.insere(consumidor);
                
                break;
            }
            
            case 2:{
                /*DEFINE A CONEXAO A SER UTILIZADA*/
                OracleCustomerDAO cliente = new OracleCustomerDAO();
                
                /*SELECIONA OS DADOS DE UM ALUNO*/
                cliente.seleciona();
                
                break;
            }
            
            case 3:{
                /*VALORES PARA MODIFICAR*/
                Customer cliente = new Customer();
                cliente.setId(1);
                cliente.setCompany("Microsoft do Bill Gates LTDA");
                
                /*DEFINE A CONEXÃO QUE DEVE UTILIZAR*/
                SybaseCustomerDAO consumidor = new SybaseCustomerDAO();
                
                /*ATUALIZA OS DADOS DE UM CLIENTE*/
                consumidor.altera(cliente);
                
                break;
            }
            
            case 4:{
                /*DEFINE QUAL ID IRA PROCURAR*/
                Customer cliente = new Customer();
                cliente.setId(18);
                
                /*DEFINE A CONEXAO QUE DEVE SER UTILIZADA*/
                CustomerDAO consumidor = new CustomerDAO();
                
                /*DELETA O CADASTRO DE UM CLIENTE*/
                consumidor.remove(cliente);
                
                break;
            }
        }
        
        op.close();
        //conecta.close();
    }
}
