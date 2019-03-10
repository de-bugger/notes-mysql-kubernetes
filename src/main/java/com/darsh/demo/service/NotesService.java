package com.darsh.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.darsh.demo.model.Notes;
import com.darsh.demo.model.User;

@Service("NotesService")
public interface NotesService {

	List<Notes> getAllNotes(User user);

	Notes addNote(Notes note);

}
