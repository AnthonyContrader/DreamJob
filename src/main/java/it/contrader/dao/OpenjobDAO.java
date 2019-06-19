package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Openjob;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;

public class OpenjobDAO implements DAO<Openjob>{

	private final String QUERY_ALL = "SELECT * FROM openjob";
	private final String QUERY_CREATE = "INSERT INTO openjob (titolo, descrizione, requisiti) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM openjob WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE openjob SET titolo=?, descrizione=?, requisiti=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM openjob WHERE id=?";

	public OpenjobDAO() {

	}
	
	public List<Openjob> getAll() {
		List<Openjob> openjobsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Openjob openjob;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String titolo = resultSet.getString("titolo");
				String descrizione = resultSet.getString("descrizione");
				String requisiti = resultSet.getString("requisiti");
				openjob = new Openjob(titolo, descrizione, requisiti);
				openjob.setId(id);
				openjobsList.add(openjob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return openjobsList;
	}

	public boolean insert(Openjob openjobToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, openjobToInsert.getTitolo());
			preparedStatement.setString(2, openjobToInsert.getDescrizione());
			preparedStatement.setString(3, openjobToInsert.getRequisiti());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Openjob read(int openjobId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, openjobId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String titolo, descrizione, requisiti;

			titolo = resultSet.getString("titolo");
			descrizione = resultSet.getString("descrizione");
			requisiti = resultSet.getString("requisiti");
			Openjob openjob = new Openjob(titolo, descrizione, requisiti);
			openjob.setId(resultSet.getInt("id"));

			return openjob;
		} catch (SQLException e) {
			return null;
		}
	}
	

	public boolean update(Openjob openjobToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (openjobToUpdate.getId() == 0)
			return false;

		Openjob openjobRead = read(openjobToUpdate.getId());
		if (!openjobRead.equals(openjobToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (openjobToUpdate.getTitolo() == null || openjobToUpdate.getTitolo().equals("")) {
					openjobToUpdate.setTitolo(openjobRead.getTitolo());
				}

				if (openjobToUpdate.getDescrizione() == null || openjobToUpdate.getDescrizione().equals("")) {
					openjobToUpdate.setDescrizione(openjobRead.getDescrizione());
				}

				if (openjobToUpdate.getRequisiti() == null || openjobToUpdate.getRequisiti().equals("")) {
					openjobToUpdate.setRequisiti(openjobRead.getRequisiti());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, openjobToUpdate.getTitolo());
				preparedStatement.setString(2, openjobToUpdate.getDescrizione());
				preparedStatement.setString(3, openjobToUpdate.getRequisiti());
				preparedStatement.setInt(4, openjobToUpdate.getId());
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
