package ua.rafael.jdbc.spring.getprimarykey.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.getprimarykey.model.Contact;

@Repository("contactDao")
public class GetPrimaryKeyContactDaoImpl implements GetPrimaryKeyContactDao {
	private static final Log LOG = LogFactory.getLog(GetPrimaryKeyContactDaoImpl.class);

	@Autowired
	private InsertContactFunction insertContactFunction;

	@Override
	public void insert(Contact contact) {
		Map<String, Object> insertContactMap = new HashMap<>();
		insertContactMap.put("first_name", contact.getFirstName());
		insertContactMap.put("last_name", contact.getLastName());
		insertContactMap.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertContactFunction.updateByNamedParam(insertContactMap, keyHolder);
		contact.setId(keyHolder.getKey().intValue());
		LOG.info("New contact inserted with id: " + contact.getId());
	}
}
