package practice.codejava.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import practice.codejava.contact.dao.ContactDAO;
import practice.codejava.contact.modal.Contact;

@RestController
public class ApiController {
	@Autowired
	private ContactDAO contactDAO;
	@RequestMapping(value="/contacts",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins="*")
	public @ResponseBody List<Contact> listContact()
	{
		List<Contact> listContacts = contactDAO.listContacts();
		
		
		return listContacts; //viewName
	}
}
