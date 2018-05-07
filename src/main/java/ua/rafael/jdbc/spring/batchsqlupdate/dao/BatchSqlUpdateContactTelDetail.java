package ua.rafael.jdbc.spring.batchsqlupdate.dao;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;
import org.springframework.stereotype.Component;

@Component
public class BatchSqlUpdateContactTelDetail extends BatchSqlUpdate {
	public static String INSERT_CONTACT_DETAILS_QUERY = "INSERT INTO contact_tel_detail "
			+ "(contact_id,tel_type,tel_number) VALUES (:contact_id, :tel_type, :tel_number)";
	public static Integer BATCH_SIZE = 10;

	@Autowired
	private DataSource dataSource;

	public BatchSqlUpdateContactTelDetail(DataSource dataSource) {
		super(dataSource, INSERT_CONTACT_DETAILS_QUERY);
		super.declareParameter(new SqlParameter("contact_id", INTEGER));
		super.declareParameter(new SqlParameter("tel_type", VARCHAR));
		super.declareParameter(new SqlParameter("tel_number", VARCHAR));
		setBatchSize(BATCH_SIZE);
	}
}
