package practice.codejava.contact.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import practice.codejava.contact.modal.Contact;

public class ContactDAOTest {

	private DriverManagerDataSource dataSource;
	private ContactDAO dao;

	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("password");

		dao = new ContactDAOImpl(dataSource);
	}

	@Test
	public void testSave() {

		setupBeforeEach();
		Contact c = new Contact("Rocher", "rocher@yahoo.com", "#01-401, block-3, US", "88855437");
		int result = dao.save(c);
		assertTrue(result > 0);

	}

	@Test
	public void testUpdate() {
		setupBeforeEach();
		Contact c = new Contact(2, "Bill gates", "bill.gates@microsoft.com", "#01-441, block-3, US", "88855437");
		int result = dao.update(c);
		assertTrue(result > 0);
	}

	@Test
	public void testGet() {
		setupBeforeEach();
		Integer id = 2;
		Contact contact = dao.get(id);
		if(contact!=null)
		{
			System.out.println(contact);
		}
		assertNotNull(contact);
	}

	@Test
	public void testDelete() {
		setupBeforeEach();
	    Integer id = 3;
	    int result = dao.delete(id);
	    assertTrue(result > 0);
	}

	@Test
	public void testListContacts() {
		setupBeforeEach();
		List<Contact> contactList = dao.listContacts();
		for(Contact c: contactList)
		{
			System.out.println(c);
		}
		assertTrue(!contactList.isEmpty());
	}

}
