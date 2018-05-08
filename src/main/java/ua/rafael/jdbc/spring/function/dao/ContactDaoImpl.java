package ua.rafael.jdbc.spring.function.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {

	@Autowired
	FindFirstNameBy findFirstNameBy;

	@Override
	public String findFirstNameBy(int id) {
		Map<String, Object> parametersMap = new HashMap<>();
		parametersMap.put("id", new Integer(id));
		return findFirstNameBy.executeByNamedParam(parametersMap).get(0);
	}
}
