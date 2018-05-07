package ua.rafael.jdbc.spring.batchsqlupdate.dao;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.batchsqlupdate.model.Contact;
import ua.rafael.jdbc.spring.batchsqlupdate.model.ContactTelDetail;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	private static final Log LOG = LogFactory.getLog(ContactDaoImpl.class);

	@Autowired
	private InsertContactFunction insertContact;

	@Autowired
	private BatchSqlUpdateContactTelDetail insertContactTelDetale;

	@Override
	public void insert(Contact contact) {
		Map<String, Object> insertContactMap = new HashMap<>();
		insertContactMap.put("first_name", contact.getFirstName());
		insertContactMap.put("last_name", contact.getLastName());
		insertContactMap.put("birth_date", contact.getBirthDate());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertContact.updateByNamedParam(insertContactMap, keyHolder);
		contact.setId(keyHolder.getKey().intValue());
		LOG.info("New contact inserted with id: " + contact.getId());
		List<ContactTelDetail> contactTelDetailsList = contact.getContactTelDetails();
		if (!isNull(contactTelDetailsList)) {
			contactTelDetailsList.forEach(contactTelDetail -> {
				Map<String, Object> insertContactTelDetailsMap = new HashMap<>();
				insertContactTelDetailsMap.put("contact_id", contact.getId());
				insertContactTelDetailsMap.put("tel_type", contactTelDetail.getTelType());
				insertContactTelDetailsMap.put("tel_number", contactTelDetail.getTelNumber());
				LOG.info(contact);
				insertContactTelDetale.updateByNamedParam(insertContactTelDetailsMap);
			});
			insertContactTelDetale.flush();
		}
	}
}
