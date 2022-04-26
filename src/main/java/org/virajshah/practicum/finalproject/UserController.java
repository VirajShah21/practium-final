package org.virajshah.practicum.finalproject;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
class UserController {
    @PostMapping("/users")
    User postUser() {
        User user = new User(UUID.randomUUID().toString(), new Date().getTime());
        UserService service = new UserService();
        service.createUser(user);
        return user;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        UserService service = new UserService();
        return service.getUsers();
    }

    @PostMapping("/users/{userId}/notes")
    Note postNote(@PathVariable String userId, @RequestBody Map<String, String> body) {
        Note note = new Note(userId, body.get("title"), body.get("content"));
        NoteService service = new NoteService();
        service.createNote(note);
        return note;
    }

    @GetMapping("/users/{userId}/notes")
    List<Note> getNotes(@PathVariable String userId) {
        NoteService service = new NoteService();
        List<Note> allNotes = service.getNotes();
        List<Note> userNotes = new ArrayList<>();
        for (Note note : allNotes)
            if (note.getUserId().equals(userId))
                userNotes.add(note);
        return userNotes;
    }

    @DeleteMapping("/users/{userId}/notes/{noteId}")
    String deleteNote(@PathVariable String userId, @PathVariable String noteId) {
        NoteService service = new NoteService();
        service.deleteNote(noteId);
        return "The JSON form of the note that was just deleted";
    }
}