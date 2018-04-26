package ua.rafael.jdbc.firstproj;

import ua.rafael.jdbc.firstproj.dao.ContactDao;
import ua.rafael.jdbc.firstproj.dao.PlainContactDao;

public class App {
	private static ContactDao contactDao = new PlainContactDao();

	public static void main(String[] args) {
		System.out.println(contactDao.findAll());
	}
}
