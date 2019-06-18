package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
    private final String QUERY_COMPANY = "select * from company where username = ? and password = ?";
    private final String QUERY_CANDIDATO = "select * from candidato where username = ?  and password = ?"; 
    /**
     * 
     * @param username
     * @param password
     * @return the type of user of null if nothing is found
     */
    public String login (String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        //connette al db
        String usertype = null;
        ResultSet rs;


        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            //prepara la richiesta al db
            statement.setString(1, username);
            statement.setString(2, password);
            
                       
            if(statement.executeQuery().next()) {
            	//scorre la lista
            	rs = statement.executeQuery();
            	rs.next();
            	usertype = rs.getString("usertype");
            	//estrae usertype
            }
            if (usertype == null) {
            	statement = connection.prepareStatement(QUERY_CANDIDATO);
            	statement.setString(1, username);
                statement.setString(2, password);
                
                if(statement.executeQuery().next()) {
                	//scorre la lista
                	rs = statement.executeQuery();
                	rs.next();
                	usertype = rs.getString("usertype");
                	//estrae usertype
                }
	                if ( usertype == null) {	
		                statement = connection.prepareStatement(QUERY_COMPANY);
		            	statement.setString(1, username);
		                statement.setString(2, password);
		                
		                if(statement.executeQuery().next()) {
		                	//scorre la lista
		                	rs = statement.executeQuery();
		                	rs.next();
		                	usertype = rs.getString("usertype");
		                	//estrae usertype
		                }
	                }
            }
            return usertype;
        }
        catch (SQLException e) {
            
            return null;
        }
    }
}
