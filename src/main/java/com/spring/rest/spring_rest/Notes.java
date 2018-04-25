package com.spring.rest.spring_rest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Notes.FIND_ALL_NOTES, query = "select n from Notes n")
public class Notes {

	protected static final String FIND_ALL_NOTES = "find_all_notes";

	@Id
	private String notesId;
	private String notesName;
	private String noteData;
	private Date lastEdited;
	private Date noteAdded;

	public Notes() {
	}

	public Notes(String notesId, String notesName, String noteData, Date lastEdited, Date noteAdded) {
		this.notesId = notesId;
		this.notesName = notesName;
		this.noteData = noteData;
		this.lastEdited = lastEdited;
		this.noteAdded = noteAdded;
	}

	public String getNotesId() {
		return notesId;
	}

	public void setNotesId(String notesId) {
		this.notesId = notesId;
	}

	public String getNotesName() {
		return notesName;
	}

	public void setNotesName(String notesName) {
		this.notesName = notesName;
	}

	public String getNoteData() {
		return noteData;
	}

	public void setNoteData(String noteData) {
		this.noteData = noteData;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}

	public Date getNoteAdded() {
		return noteAdded;
	}

	public void setNoteAdded(Date noteAdded) {
		this.noteAdded = noteAdded;
	}
}
