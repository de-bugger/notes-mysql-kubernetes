package com.darsh.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darsh.demo.dao.NotesDao;
import com.darsh.demo.model.Notes;
import com.darsh.demo.model.User;
import com.darsh.demo.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	NotesDao notesDao;

	@Override
	public List<Notes> getAllNotes(User user) {
		return notesDao.findByUser(user);
	}

	@Override
	public Notes addNote(Notes note) {
		return notesDao.save(note);
	}
	
	
}
