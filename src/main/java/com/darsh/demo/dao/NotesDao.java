package com.darsh.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darsh.demo.model.Notes;
import com.darsh.demo.model.User;

@Repository
public interface NotesDao extends JpaRepository<Notes, Long> {

	List<Notes> findByUser(User user);
	Optional<Notes> findById(Long Id);

}
