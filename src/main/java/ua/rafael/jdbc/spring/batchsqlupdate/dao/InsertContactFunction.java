package ua.rafael.jdbc.spring.batchsqlupdate.dao;

import static java.sql.Types.DATE;
import static java.sql.Types.VARCHAR;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;

@Component
public class InsertContactFunction extends SqlUpdate {
	private static String INSERT_QUERY = "INSERT INTO contact (first_name,last_name,birth_date) "
			+ "VALUES ( :first_name, :last_name, :birth_date)";

	public InsertContactFunction(DataSource ds) {
		super(ds, INSERT_QUERY);
		super.declareParameter(new SqlParameter("first_name", VARCHAR));
		super.declareParameter(new SqlParameter("last_name", VARCHAR));
		super.declareParameter(new SqlParameter("birth_date", DATE));
		super.setGeneratedKeysColumnNames(new String[] { "id" });
		super.setReturnGeneratedKeys(true);
	}
}
