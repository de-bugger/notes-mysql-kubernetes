package com.darsh.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.darsh.demo.model.Notes;
import com.darsh.demo.model.User;

@Service("NotesService")
public interface NotesService {

	List<Notes> getAllNotes(User user);
	
	Optional<Notes> getNote(Long id);
	
	void deleteNote(Long id);

	Notes addNote(Notes note);

	List<Notes> findAll();

}
