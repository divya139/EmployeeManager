package practice.codejava.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;


import practice.codejava.contact.dao.*;
import practice.codejava.contact.modal.Contact;
@Controller
public class MainController {
	
	@Autowired
	private ContactDAO contactDAO;
	@RequestMapping(value="/")
	@CrossOrigin(origins="*")
	public ModelAndView listContact(ModelAndView model)
	{
		List<Contact> listContacts = contactDAO.listContacts();
		model.addObject("listContacts", listContacts);
		model.setViewName("index");
		
		return model; //viewName
	}
	@RequestMapping(value="/new" , method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model)
	{
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("newContact_form");
		
		return model; 
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact)
	{
		if(contact.getId()== null)
		{
		    System.out.println("Trying to save contact for id: " +contact.getId());
		    contactDAO.save(contact);
		    System.out.println("Saved successfully for contact with id: " +contact.getId());
		}
		else
		{
			contactDAO.update(contact);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value="/edit" , method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(id);
		ModelAndView model = new ModelAndView("newContact_form");
		model.addObject("contact", contact);
		//model.setViewName();
		
		return model; 
	}
	@RequestMapping(value="/delete" , method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
	    contactDAO.delete(id);
		
		
		return new ModelAndView("redirect:/"); 
	}
}
