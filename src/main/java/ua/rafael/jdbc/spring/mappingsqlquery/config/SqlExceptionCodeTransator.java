package ua.rafael.jdbc.spring.mappingsqlquery.config;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

public class SqlExceptionCodeTransator extends SQLErrorCodeSQLExceptionTranslator {

	@Override
	protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
		return sqlEx.getErrorCode() == -12345 ? new DeadlockLoserDataAccessException(task, sqlEx) : null;
	}
}
