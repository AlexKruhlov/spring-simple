package ua.rafael.jdbc.firstproj.dao;

import static java.util.Objects.nonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.CommunicationException;

import ua.rafael.jdbc.firstproj.model.Contact;

public class PlainContactDao implements ContactDao {
	private static String URL = "jdbc:postgresql://localhost/postgres";
	private static String USER = "postgres";
	private static String PASSWORD = "1";

	private static String FIND_ALL_QUERY = "SELECT * FROM contact";
	private static String INSERT_QUERY = "INSERT INTO contact (first_name,last_name,birth_date) VALUES (?,?,?)";

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<>();
		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirthDate(resultSet.getDate("birth_date"));
				result.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		return null;
	}

	@Override
	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Contact contact) {
		try (Connection connection = getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, contact.getFirstName());
			preparedStatement.setString(2, contact.getLastName());
			preparedStatement.setDate(3, contact.getBirthDate());
			preparedStatement.executeQuery();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				contact.setId(resultSet.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long contactId) {
		// TODO Auto-generated method stub

	}
}
