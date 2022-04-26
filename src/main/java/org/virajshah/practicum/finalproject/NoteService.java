package org.virajshah.practicum.finalproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void createNote(final Note customer) {
        noteRepository.save(customer);
    }

    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository.findAll().forEach(notes::add);
        return notes;
    }

    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }
}