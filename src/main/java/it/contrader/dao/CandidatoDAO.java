package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Candidato;


public class CandidatoDAO {

	private final String QUERY_ALL = "select * from candidato";
	private final String QUERY_INSERT = "insert into candidato (name,surname,age,education,experience,password, username, usertype) values (?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from candidato where id=?";


	private final String QUERY_UPDATE = "UPDATE candidato SET name=?, age=?, surname=?,education=?,experience=?,password=?, username=? WHERE id=?";
	private final String QUERY_DELETE = "delete from candidato where id=?";

	public CandidatoDAO() {

	}

	public List<Candidato> getAllCandidato() {
		List<Candidato> candidatoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Candidato candidato;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				String education = resultSet.getString("education");
				String experience = resultSet.getString("experience");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String usertype = resultSet.getString("usertype");
				

				candidato = new Candidato(name,surname,age,education,experience,username, password, usertype);
				candidato.setId(id);
				candidatoList.add(candidato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidatoList;
	}

	public boolean insertCandidato(Candidato candidato) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, candidato.getName());
			preparedStatement.setString(2, candidato.getSurname());
			preparedStatement.setInt(3, candidato.getAge());
			preparedStatement.setString(4, candidato.getEducation());
			preparedStatement.setString(5, candidato.getExperience());
			preparedStatement.setString(6, candidato.getPassword());
			preparedStatement.setString(7, candidato.getUsername());
			preparedStatement.setString(8, candidato.getUsertype());
			
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Candidato readCandidato(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, surname, education, experience;
			int age;

			 name = resultSet.getString("name");
			 surname = resultSet.getString("surname");
			 age = resultSet.getInt("age");
			 education = resultSet.getString("education");
			 experience = resultSet.getString("experience");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String usertype = resultSet.getString("usertype");
			 Candidato candidato = new Candidato (name,surname,age,education,experience,password,username,usertype);
			 

			return candidato;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateCandidato(Candidato candidatoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
	
		// Check if id is present
		if (candidatoToUpdate.getId() == 0)
			return false;

		Candidato candidatoRead = readCandidato(candidatoToUpdate.getId());
		if (!candidatoRead.equals(candidatoToUpdate)) {
						try {
				// Fill the userToUpdate object
				if (candidatoToUpdate.getName() == null || candidatoToUpdate.getName().equals("")) {
					candidatoToUpdate.setName(candidatoRead.getName());
				}

				if (candidatoToUpdate.getSurname() == null || candidatoToUpdate.getSurname().equals("")) {
					candidatoToUpdate.setSurname(candidatoRead.getSurname());
				}
				
				if (candidatoToUpdate.getAge() == 0
						|| candidatoToUpdate.getAge() == 0 ) {
					candidatoToUpdate.setAge(candidatoRead.getAge());
				}
				
				if (candidatoToUpdate.getEducation() == null || candidatoToUpdate.getEducation().equals("")) {
					candidatoToUpdate.setEducation(candidatoRead.getEducation());
				}
				
				if (candidatoToUpdate.getExperience() == null || candidatoToUpdate.getExperience().equals("")) {
					candidatoToUpdate.setExperience(candidatoRead.getExperience());
					
				}
				if (candidatoToUpdate.getPassword() == null || candidatoToUpdate.getPassword().equals("")) {
					candidatoToUpdate.setPassword(candidatoRead.getPassword());
					
				}
				if (candidatoToUpdate.getUsername() == null || candidatoToUpdate.getUsername().equals("")) {
					candidatoToUpdate.setUsername(candidatoRead.getUsername());
					
				}

				
				
				// Update the candidato
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(8, candidatoToUpdate.getId());
				preparedStatement.setString(1, candidatoToUpdate.getName());
				preparedStatement.setString(2, candidatoToUpdate.getSurname());
				preparedStatement.setInt(3, candidatoToUpdate.getAge());
				preparedStatement.setString(4, candidatoToUpdate.getEducation());
				preparedStatement.setString(5, candidatoToUpdate.getExperience());
				preparedStatement.setString(6, candidatoToUpdate.getPassword());
				preparedStatement.setString(7, candidatoToUpdate.getUsername());

				
				
				boolean a = preparedStatement.execute();
				return a;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean deleteCandidato(Integer id) {
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
