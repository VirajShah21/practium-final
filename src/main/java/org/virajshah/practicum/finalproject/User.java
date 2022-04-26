package org.virajshah.practicum.finalproject;

public class User {
    private String userId;
    private long createdDate;

    public User(String uuid, long createdDate) {
        this.userId = uuid;
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
