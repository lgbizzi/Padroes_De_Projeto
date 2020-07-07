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
// Abstract class DAO Factory
public abstract class DAOFactory {

  // List of DAO types supported by the factory
  public static final int CLOUDSCAPE = 1;
  public static final int ORACLE = 2;
  public static final int SYBASE = 3;

  // There will be a method for each DAO that can be 
  // created. The concrete factories will have to 
  // implement these methods.
  public abstract CustomerDAO getCustomerDAO();

  public static DAOFactory getDAOFactory(
      int whichFactory) {
  
    switch (whichFactory) {
      case CLOUDSCAPE: 
          return new CloudscapeDAOFactory() {
        @Override
        public CustomerDAO getCustomerDAO() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
      case ORACLE    : 
          return new OracleDAOFactory() {
        @Override
        public CustomerDAO getCustomerDAO() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };      
      case SYBASE    : 
          return new SybaseDAOFactory() {
        @Override
        public CustomerDAO getCustomerDAO() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
      default           : 
          return null;
    }
  }
}