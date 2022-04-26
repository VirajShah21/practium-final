package org.virajshah.practicum.finalproject;

import java.util.Date;
import java.util.UUID;

public class Note {
    private String userId;
    private String noteId;
    private String title;
    private String content;
    private long createdDate;

    public Note(String userId, String title, String content) {
        this.userId = userId;
        this.noteId = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.createdDate = new Date().getTime();
    }

    // Getters and setters for all fields

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
