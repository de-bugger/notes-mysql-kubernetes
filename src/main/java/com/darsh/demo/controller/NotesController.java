package com.darsh.demo.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darsh.demo.model.Notes;
import com.darsh.demo.model.User;
import com.darsh.demo.service.NotesService;
import com.darsh.demo.service.UserService;

@Controller
public class NotesController {

	@Autowired
	NotesService notesService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/getallnotes", method= RequestMethod.GET)
	public String getNotes(Model model, Principal principal) {
		User user= userService.findByUsername(principal.getName());
		//System.out.println(".............  "+user);
		List<Notes> notes= notesService.getAllNotes(user);
		model.addAttribute("notes",notes);
		
		return "getallnotes";
	}
	
	@RequestMapping(value= "/addnotes", method= RequestMethod.GET)
	public String addNotes(Model model) {
		Notes note= new Notes();
		model.addAttribute(note);
		return "notes";
	}
	
	@RequestMapping(value= "/addnotes", method= RequestMethod.POST)
	public String addNotesPost(@ModelAttribute("notes") Notes note, Model model, Principal principal) {
		User user= userService.findByUsername(principal.getName());
		note.setUser(user);
		notesService.addNote(note);
		List<Notes> notes= notesService.getAllNotes(user);
		model.addAttribute("notes",notes);
		return "getallnotes";
	}
	
	@RequestMapping(value= "/editnotes/{id}", method= RequestMethod.GET)
	public String editNotesPage(@PathVariable("id") Long id, Model model) {
		Optional<Notes> note= notesService.getNote(id);
		model.addAttribute("note",note.get());
		return "editnotes";
	}
	
	@RequestMapping(value= "/editnotes/{id}", method= RequestMethod.POST)
	public String editNotes(@PathVariable("id") Long id, @ModelAttribute("notes") Notes note,BindingResult result, Model model, Principal principal) {
		//TODO
		if (result.hasErrors()) {
	        note.setNotes_Id(id);
	        return "editnotes";
	    }
		System.out.println("Chaman"+note);
		User user= userService.findByUsername(principal.getName());
		note.setUser(user);
		System.out.println("Gupta"+note);
		notesService.addNote(note);
		List<Notes> notes= notesService.getAllNotes(user);
		model.addAttribute("notes",notes);
		return "getallnotes";
	}
	
	@RequestMapping(value= "/deletenotes/{id}", method= RequestMethod.GET)
	public String deleteNotes(@PathVariable("id") Long id, Model model, Principal principal) {
		Optional<Notes> note= notesService.getNote(id);
		if(note.get() != null) {
			notesService.deleteNote(id);
		}
		User user= userService.findByUsername(principal.getName());
		List<Notes> notes= notesService.getAllNotes(user);
		model.addAttribute("notes",notes);
		return "getallnotes";
	}
}
