package org.virajshah.practicum.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void createUser(final Note customer) {
        noteRepository.save(customer);
    }
}