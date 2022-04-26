# Practicum Final

1. [API Documentation](#api-documentation)
2. [AWS Setup](#aws-setup)

The Project is hosted on: http://ec2-54-166-203-152.compute-1.amazonaws.com/

## API Documentation

### Users API

#### `GET` `/users`

**Request:** `[NONE]`

**Response:** `[JSON]` Responds with a list of all users in the database

**Example Response:**

```json
[
    {
        "userId": "XXX-XXXX-XXX",
        "createdDate": 1234567890
    },
    {
        "userId": "YYY-YYYY-YYY",
        "createdDate": 987654321
    }
]
```

#### `POST` `/users`

**Request:** `[NONE]`

**Response:** `[JSON]` Responds with the created user

**Example Response:**

```json
{
    "userId": "XXX-XXXX-XXX",
    "createdDate": 1234567890
}
```

#### `GET` `/users/:userId/qr`

**Request:** `[PATH VARIABLE]` `userId`

**Response:** `[PNG]` Responds with a PNG of QR code

### Notes

#### `GET` `/users/:userId/notes`

**Request:** `[PATH VARIABLE]` `userId`

**Response:** `[JSON]` A list of every note belonging to the specified user

**Response Body:**

```json
[
    {
        "noteId": "XXX-XXXX-XXX",
        "title": "Title",
        "content": "Content",
        "createdDate": 1234567890
    },
    {
        "noteId": "YYY-YYYY-YYY",
        "title": "Title",
        "content": "Other content",
        "createdDate": 1111111111
]
```

#### `POST` `/users/:userId/notes`

**Request:** `[Path Variable, JSON]` The note details to add

**Example Request Body:**

```json
{
    "title": "Some title",
    "content": "Some Content"
}
```

**Response:** `[JSON]` The note object that was inserted to the database

**Example Response Body:**

```json
{
    "noteId": "XXX-XXXX-XXX",
    "title": "Some title",
    "content": "Some Content",
    "createdDate": 1234567890
}
```

#### `DELETE` `/user/:userId/notes/:noteId`

**Request:** `[Path Variables]` `userId` and `noteId`

**Response:** `[STRING]` A nice message saying that the note was deleted

## AWS Setup

The project is hosted on an Amazon Linux EC2 instance, running on port `8080`. Rather than having the instance run on port `80` (which would be a public-facing HTTP port) we allow the load balancer to redirect all incoming requests to port `80` which then redirects to port `8080` which is only internally accessible.
