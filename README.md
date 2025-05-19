# Ghumi Ghumi API

This API provides endpoints for managing users, vendors, and experiences for the Ghumi Ghumi application.

## API Testing Flow

Follow this guide to test all endpoints in a logical sequence. Each section contains the necessary endpoints, request formats, and expected responses.

## 1. User Management

### Create a User

**Endpoint:** `POST /api/users`

**Request:**
```json
{
  "id": "u1",
  "name": "John Doe",
  "email": "john@example.com",
  "phoneNumber": "1234567890"
}
```

**Expected Response:**
```json
{
  "id": "u1",
  "name": "John Doe",
  "email": "john@example.com",
  "phoneNumber": "1234567890"
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"id":"u1","name":"John Doe","email":"john@example.com","phoneNumber":"1234567890"}'
```

### Get All Users

**Endpoint:** `GET /api/users`

**Expected Response:**
```json
[
  {
    "id": "u1",
    "name": "John Doe",
    "email": "john@example.com",
    "phoneNumber": "1234567890"
  },
  {
    "id": "u2",
    "name": "Jane Smith",
    "email": "jane@example.com",
    "phoneNumber": "0987654321"
  }
]
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/users
```

### Get User by ID

**Endpoint:** `GET /api/users/{id}`

**Expected Response:**
```json
{
  "id": "u1",
  "name": "John Doe",
  "email": "john@example.com",
  "phoneNumber": "1234567890"
}
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/users/u1
```

## 2. Vendor Management

### Create a Vendor

**Endpoint:** `POST /api/vendors`

**Request:**
```json
{
  "id": "v1",
  "name": "Adventure Tours",
  "email": "info@adventuretours.com",
  "phoneNumber": "9876543210",
  "description": "We provide exciting adventure tours"
}
```

**Expected Response:**
```json
{
  "id": "v1",
  "name": "Adventure Tours",
  "email": "info@adventuretours.com",
  "phoneNumber": "9876543210",
  "description": "We provide exciting adventure tours"
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/vendors \
  -H "Content-Type: application/json" \
  -d '{"id":"v1","name":"Adventure Tours","email":"info@adventuretours.com","phoneNumber":"9876543210","description":"We provide exciting adventure tours"}'
```

### Get All Vendors

**Endpoint:** `GET /api/vendors`

**Expected Response:**
```json
[
  {
    "id": "v1",
    "name": "Adventure Tours",
    "email": "info@adventuretours.com",
    "phoneNumber": "9876543210",
    "description": "We provide exciting adventure tours"
  },
  {
    "id": "v2",
    "name": "City Explorers",
    "email": "contact@cityexplorers.com",
    "phoneNumber": "5556667777",
    "description": "Guided city tours"
  }
]
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/vendors
```

### Get Vendor by ID

**Endpoint:** `GET /api/vendors/{id}`

**Expected Response:**
```json
{
  "id": "v1",
  "name": "Adventure Tours",
  "email": "info@adventuretours.com",
  "phoneNumber": "9876543210",
  "description": "We provide exciting adventure tours"
}
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/vendors/v1
```

## 3. Experience Management

### Create an Experience

**Endpoint:** `POST /api/experiences`

**Request:**
```json
{
  "id": "e1",
  "name": "Mountain Trekking",
  "description": "Exciting trek through mountain trails",
  "price": 99.99,
  "duration": "8 hours",
  "location": "Himalayan Foothills",
  "availableSlots": 20,
  "vendorId": "v1"
}
```

**Expected Response:**
```json
{
  "id": "e1",
  "name": "Mountain Trekking",
  "description": "Exciting trek through mountain trails",
  "price": 99.99,
  "duration": "8 hours",
  "location": "Himalayan Foothills",
  "availableSlots": 20,
  "vendorId": "v1"
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/experiences \
  -H "Content-Type: application/json" \
  -d '{"id":"e1","name":"Mountain Trekking","description":"Exciting trek through mountain trails","price":99.99,"duration":"8 hours","location":"Himalayan Foothills","availableSlots":20,"vendorId":"v1"}'
```

### Create Experience by Vendor

**Endpoint:** `POST /api/experiences/vendor/{vendorId}`

**Request:**
```json
{
  "id": "e2",
  "name": "City Walking Tour",
  "description": "Discover hidden gems in the city",
  "price": 49.99,
  "duration": "3 hours",
  "location": "City Center",
  "availableSlots": 15
}
```

**Expected Response:**
```json
{
  "id": "e2",
  "name": "City Walking Tour",
  "description": "Discover hidden gems in the city",
  "price": 49.99,
  "duration": "3 hours",
  "location": "City Center",
  "availableSlots": 15,
  "vendorId": "v1"
}
```

**cURL Example:**
```bash
curl -X POST http://localhost:8080/api/experiences/vendor/v1 \
  -H "Content-Type: application/json" \
  -d '{"id":"e2","name":"City Walking Tour","description":"Discover hidden gems in the city","price":49.99,"duration":"3 hours","location":"City Center","availableSlots":15}'
```

### Get All Experiences

**Endpoint:** `GET /api/experiences`

**Expected Response:**
```json
[
  {
    "id": "e1",
    "name": "Mountain Trekking",
    "description": "Exciting trek through mountain trails",
    "price": 99.99,
    "duration": "8 hours",
    "location": "Himalayan Foothills",
    "availableSlots": 20,
    "vendorId": "v1"
  },
  {
    "id": "e2",
    "name": "City Walking Tour",
    "description": "Discover hidden gems in the city",
    "price": 49.99,
    "duration": "3 hours",
    "location": "City Center",
    "availableSlots": 15,
    "vendorId": "v1"
  }
]
```

**cURL Example:**
```bash
curl -X GET http://localhost:8080/api/experiences
```

### Book an Experience

**Endpoint:** `POST /api/experiences/{experienceId}/book`

**Request Parameters:**
- `userId`: The ID of the user booking the experience
- `tickets`: Number of tickets to book

**Expected Response:**
```
Booking successful! You have booked 2 tickets for Mountain Trekking.
```

**cURL Example:**
```bash
curl -X POST "http://localhost:8080/api/experiences/e1/book?userId=u1&tickets=2"
```

## Complete Testing Flow

1. Create a few users
2. Create a vendor
3. Create experiences (either directly or through a vendor)
4. Get all experiences to verify they were created
5. Book an experience for a user
6. Verify the available slots have decreased

This flow ensures that all components of the API are tested in a logical sequence.
