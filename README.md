# RemindDay Backend

This repository contains the backend code for RemindDay, built with **Java 17**.

## Getting Started

Follow the steps below to set up and run the project:

### Prerequisites

- **Java 17** installed on your machine
- **Maven** for building and managing dependencies
- **Docker** and **Docker Compose** installed

### Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Tapakorn086/remindday_backend.git
   cd remindday_backend
```


2. **Build the Project
  ```bash
  mvn clean install
```

if build fails, Try
```bash
   mvn clean install -DskipTests
```


3. **Request Environment Configuration**

Send an email to the repository owner to request the .env file.


4. **Create .env File**

After receiving the .env file, place it in the root directory of the project.


5. **Run with Docker Compose**

Start the services using Docker Compose:
```bash
docker-compose up -d
```
