package ua.rafael.jdbc.spring.sqlupdate.dao;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class ContactUpdate extends SqlUpdate {
	public static String UPDATE_QUERY = "UPDATE contact SET first_name= :first_name,last_name=:last_name, birth_date=:birth_date"
			+ " WHERE id= :id";

	public ContactUpdate(DataSource dataSource) {
		super(dataSource, UPDATE_QUERY);
		super.declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", Types.DATE));
		super.declareParameter(new SqlParameter("id", Types.INTEGER));
	}
}
