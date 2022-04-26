package org.virajshah.practicum.finalproject;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @PostMapping("/users")
    User postUser() {
        User user = new User(UUID.randomUUID().toString(), new Date().getTime());
        userService.createUser(user);
        return user;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users/{userId}/notes")
    Note postNote(@PathVariable String userId, @RequestBody Map<String, String> body) {
        Note note = new Note(userId, body.get("title"), body.get("content"));
        noteService.createNote(note);
        return note;
    }

    @GetMapping("/users/{userId}/notes")
    List<Note> getNotes(@PathVariable String userId) {
        List<Note> allNotes = noteService.getNotes();
        List<Note> userNotes = new ArrayList<>();
        for (Note note : allNotes) {
            System.out.println(
                    "Found note:\t" + note.getTitle() + "\nUser ID:\t" + note.getUserId() + "\nShould Be:\t" + userId);
            if (note.getUserId().equals(userId))
                userNotes.add(note);
        }
        return userNotes;
    }

    @DeleteMapping("/users/{userId}/notes/{noteId}")
    String deleteNote(@PathVariable String userId, @PathVariable String noteId) {
        noteService.deleteNote(noteId);
        return "The JSON form of the note that was just deleted";
    }

    @GetMapping("/users/{userId}/qr")
    byte[] getUserQRCode(@PathVariable String userId) throws WriterException, IOException {
        return QRCodeGenerator.getQRCodeImage(userId, 300, 300);
    }
}