package com.spring.rest.spring_rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class NotesService {

	@PersistenceContext
	EntityManager em;
	
	public List<Notes> getallNotes() {
		TypedQuery<Notes> query = em.createNamedQuery(Notes.FIND_ALL_NOTES, Notes.class);
		List<Notes> results = query.getResultList();
		return results;
	}

	public Notes getNote(String id) {
		return em.find(Notes.class, id);
	}

	@Transactional
	public void deleteNote(String id) {
		em.remove(em.find(Notes.class, id));
	}

	@Transactional
	public void addNote(Notes n) {
		em.persist(n);
	}

	@Transactional
	public void updateNote(Notes n) {
		em.merge(n);
	}
}
