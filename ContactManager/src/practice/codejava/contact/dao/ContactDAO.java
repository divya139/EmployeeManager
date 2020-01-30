package practice.codejava.contact.dao;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import practice.codejava.contact.modal.Contact;

public interface ContactDAO {

	public int save(Contact contact);

	public int update(Contact contact);

	public Contact get(Integer id);

	public int delete(Integer id);

	public List<Contact> listContacts();
}
