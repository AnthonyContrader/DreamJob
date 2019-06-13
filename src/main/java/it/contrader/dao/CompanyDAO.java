package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Company;

public class CompanyDAO {
	
	private final String QUERY_ALL = "select * from company";
	private final String QUERY_INSERT = "insert into company (name,info,openjob) values (?,?,?)";
	private final String QUERY_READ = "select * from company where id=?";

	private final String QUERY_UPDATE = "UPDATE company SET name=?,info=?,openjob=? WHERE id=?";
	private final String QUERY_DELETE = "delete from company where id=?";

	public CompanyDAO() {

	}
	
	public List<Company> getAllCompany() {
		List<Company> CompanysList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Company company;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String info = resultSet.getString("info");
				String openjob = resultSet.getString("openjob");
				
				company = new Company(name,info,openjob);
				company.setId(id);
				CompanysList.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CompanysList;
	}
	
	public boolean insertCompany(Company company) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, company.getName());
			preparedStatement.setString(2, company.getInfo());
			preparedStatement.setString(3, company.getOpenjob());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	
	public Company readCompany(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, info, openjob;

			name = resultSet.getString("name");
			info = resultSet.getString("info");
			openjob = resultSet.getString("openjob");
			 
			 Company company = new Company (name,info,openjob);
			 

			return company;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}
	
	public boolean updateCompany(Company companyToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (companyToUpdate.getId() == 0)
			return false;

		Company companyRead = readCompany(companyToUpdate.getId());
		if (!companyRead.equals(companyToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (companyToUpdate.getName() == null || companyToUpdate.getName().equals("")) {
					companyToUpdate.setName(companyRead.getName());
				}

				if (companyToUpdate.getInfo() == null || companyToUpdate.getInfo().equals("")) {
					companyToUpdate.setInfo(companyRead.getInfo());
				}
				
				if (companyToUpdate.getOpenjob() == null || companyToUpdate.getOpenjob().equals("")) {
					companyToUpdate.setOpenjob(companyRead.getOpenjob());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, companyToUpdate.getId());
				preparedStatement.setString(2, companyToUpdate.getName());
				preparedStatement.setString(3, companyToUpdate.getInfo());
				preparedStatement.setString(4, companyToUpdate.getOpenjob());
				
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

	public boolean deleteCompany(Integer id) {
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
