package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Candidato;
import it.contrader.model.Company;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CompanyDAO implements DAO<Company> {

	private final String QUERY_ALL = "SELECT * FROM company";
	private final String QUERY_CREATE = "INSERT INTO company (name, info, username, password, openjob, candidato) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM company WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE company SET name=?, info=?, username=?,  password=?, openjob=?, candidato=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM company WHERE id=?";

	public CompanyDAO() {

	}

	public List<Company> getAll() {
		List<Company> companysList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String info = resultSet.getString("info");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String openjob = resultSet.getString("openjob");
				String candidato = resultSet.getString("candidato");
				Company company = new Company(name, info, username,password, openjob, candidato);
				company.setId(id);
				companysList.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companysList;
	}

	public boolean insert(Company companyToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, companyToInsert.getName());
			preparedStatement.setString(2, companyToInsert.getInfo());
			preparedStatement.setString(3, companyToInsert.getUsername());
			preparedStatement.setString(4, companyToInsert.getPassword());
			preparedStatement.setString(5, companyToInsert.getOpenjob());
			preparedStatement.setString(6, companyToInsert.getCandidato());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Company read(int companyId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, companyId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, info, username, password, openjob, candidato;
	

			name = resultSet.getString("name");
			info = resultSet.getString("info");
			username = resultSet.getString("username");
			password = resultSet.getString("password");
			openjob = resultSet.getString("openjob");
			candidato= resultSet.getString("candidato");
			Company company = new Company(name, info, username, password,openjob, candidato);
			company.setId(resultSet.getInt("id"));

			return company;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Company companyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (companyToUpdate.getId() == 0)
			return false;

		Company companyRead = read(companyRead.getId());
		if (!companyRead.equals(companyRead)) {
			try {
				// Fill the userToUpdate object
				if (companyToUpdate.getName() == null || companyToUpdate.getName().equals("")) {
					companyToUpdate.setName(companyRead.getName());
				}

				if (companyToUpdate.getInfo() == null || companyToUpdate.getInfo().equals("")) {
					companyToUpdate.setInfo(companyRead.getInfo());
				}

				if (companyToUpdate.getUsername() == null || companyToUpdate.getUsername().equals("")) {
					companyToUpdate.setUsername(companyRead.getUsername());
				}
				if (companyToUpdate.getPassword() == null || companyToUpdate.getPassword().equals("")) {
					companyToUpdate.setPassword(companyRead.getPassword());
				}
				
				if (companyToUpdate.getOpenjob() == null || companyToUpdate.getOpenjob().equals("")) {
					companyToUpdate.setOpenjob(companyRead.getOpenjob());
				}
				if (companyToUpdate.getCandidato() == null || companyToUpdate.getCandidato().equals("")) {
					companyToUpdate.setCandidato(companyRead.getCandidato());
				}


				// Update the candidato
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, companyToUpdate.getName());
				preparedStatement.setString(2, companyToUpdate.getInfo());
				preparedStatement.setString(3, companyToUpdate.getUsername());
				preparedStatement.setString(4, companyToUpdate.getPassword());
				preparedStatement.setString(5, companyToUpdate.getOpenjob());
				preparedStatement.setString(6, companyToUpdate.getCandidato());
				preparedStatement.setInt(7, companyToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
