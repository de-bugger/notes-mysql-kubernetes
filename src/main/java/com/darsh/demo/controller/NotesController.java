package com.darsh.demo.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/getallnotes", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Notes> getNotes(Model model, Principal principal) {
		User user= userService.findByUsername(principal.getName());
		//System.out.println(".............  "+user);
		List<Notes> notes= notesService.getAllNotes(user);
		model.addAttribute(notes);
		System.out.println(notes);
		
		return notes;
	}
	
	@RequestMapping(value= "/addnotes", method= RequestMethod.GET)
	public String addNotes(Model model) {
		Notes note= new Notes();
		model.addAttribute(note);
		return "notes";
	}
	
	@RequestMapping(value= "/addnotes", method= RequestMethod.POST)
	public String addNotesPost(@ModelAttribute("notes") Notes note, Model model, Principal principal) {
		//System.out.println("gupta"+note);
		User user= userService.findByUsername(principal.getName());
		note.setUser(user);
		//System.out.println(user);
		//System.out.println(note);
		notesService.addNote(note);
		return "notes";
	}
}
