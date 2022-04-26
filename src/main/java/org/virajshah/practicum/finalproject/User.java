package org.virajshah.practicum.finalproject;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "users")
public class User {
    private String userId;
    private long createdDate;

    public User() {
    }

    public User(String uuid, long createdDate) {
        this.userId = uuid;
        this.createdDate = createdDate;
    }

    @DynamoDBHashKey
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @DynamoDBAttribute
    public long getCreatedDate() {
        return createdDate;
    }

    @DynamoDBAttribute
    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
