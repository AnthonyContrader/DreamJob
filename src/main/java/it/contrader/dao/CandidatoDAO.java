package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Candidato;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CandidatoDAO implements DAO<Candidato> {

	private final String QUERY_ALL = "SELECT * FROM candidato";
	private final String QUERY_CREATE = "INSERT INTO candidato (username, password, name, surname, age, education, experience) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM candidato WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE candidato SET username=?, password=?, usertype=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM candidato WHERE id=?";

	public CandidatoDAO() {

	}

	public List<Candidato> getAll() {
		List<Candidato> candidatiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				String education = resultSet.getString("education");
				String experience = resultSet.getString("experience");
				Candidato candidato = new Candidato(username, password, name, surname, age, education, experience);
				candidato.setId(id);
				candidatiList.add(candidato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candidatiList;
	}

	public boolean insert(Candidato candidatoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, candidatoToInsert.getUsername());
			preparedStatement.setString(2, candidatoToInsert.getPassword());
			preparedStatement.setString(3, candidatoToInsert.getName());
			preparedStatement.setString(4, candidatoToInsert.getSurname());
			preparedStatement.setInt(5, candidatoToInsert.getAge());
			preparedStatement.setString(6, candidatoToInsert.getEducation());
			preparedStatement.setString(7, candidatoToInsert.getExperience());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Candidato read(int candidatoId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, candidatoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, name, surname, education, experience;
			int age;

			username = resultSet.getString("username");
			password = resultSet.getString("password");
			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			age = resultSet.getInt("age");
			education = resultSet.getString("education");
			experience= resultSet.getString("experience");
			Candidato candidato = new Candidato(username, password, name, surname, age, education, experience);
			candidato.setId(resultSet.getInt("id"));

			return candidato;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Candidato candidatoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (candidatoToUpdate.getId() == 0)
			return false;

		Candidato candidatoRead = read(candidatoToUpdate.getId());
		if (!candidatoRead.equals(candidatoToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (candidatoToUpdate.getUsername() == null || candidatoToUpdate.getUsername().equals("")) {
					candidatoToUpdate.setUsername(candidatoRead.getUsername());
				}

				if (candidatoToUpdate.getPassword() == null || candidatoToUpdate.getPassword().equals("")) {
					candidatoToUpdate.setPassword(candidatoRead.getPassword());
				}

				if (candidatoToUpdate.getName() == null || candidatoToUpdate.getName().equals("")) {
					candidatoToUpdate.setName(candidatoRead.getName());
				}
				if (candidatoToUpdate.getSurname() == null || candidatoToUpdate.getSurname().equals("")) {
					candidatoToUpdate.setSurname(candidatoRead.getSurname());
				}
				if (candidatoToUpdate.getAge() == 0) {
					candidatoToUpdate.setAge(candidatoRead.getAge());
				}
				if (candidatoToUpdate.getEducation() == null || candidatoToUpdate.getEducation().equals("")) {
					candidatoToUpdate.setEducation(candidatoRead.getEducation());
				}
				if (candidatoToUpdate.getExperience() == null || candidatoToUpdate.getExperience().equals("")) {
					candidatoToUpdate.setExperience(candidatoRead.getExperience());
				}


				// Update the candidato
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, candidatoToUpdate.getUsername());
				preparedStatement.setString(2, candidatoToUpdate.getPassword());
				preparedStatement.setString(3, candidatoToUpdate.getName());
				preparedStatement.setString(4, candidatoToUpdate.getSurname());
				preparedStatement.setInt(5, candidatoToUpdate.getAge());
				preparedStatement.setString(6, candidatoToUpdate.getEducation());
				preparedStatement.setString(7, candidatoToUpdate.getExperience());
				preparedStatement.setInt(8, candidatoToUpdate.getId());
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
