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
    List<User> users;
    List<Note> notes;

    public UserController() {
        this.users = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    @PostMapping("/users")
    User postUser() {
        User user = new User(UUID.randomUUID().toString(), new Date().getTime());
        this.users.add(user);
        return user;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return users;
    }

    @PostMapping("/users/{userId}/notes")
    Note postNote(@PathVariable String userId, @RequestBody Map<String, String> body) {
        Note note = new Note(userId, body.get("title"), body.get("content"));
        this.notes.add(note);
        return note;
    }

    @GetMapping("/users/{userId}/notes")
    List<Note> getNotes(@PathVariable String userId) {
        List<Note> userNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getUserId().equals(userId)) {
                userNotes.add(note);
            }
        }
        return userNotes;
    }

    @DeleteMapping("/users/{userId}/notes/{noteId}")
    String deleteNote(@PathVariable String userId, @PathVariable String noteId) {
        for (Note note : notes) {
            if (note.getUserId().equals(userId) && note.getNoteId().equals(noteId)) {
                notes.remove(note);
                break;
            }
        }
        return "The JSON form of the note that was just deleted";
    }
}