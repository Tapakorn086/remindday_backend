RemindDay Backend

This repository contains the backend code for RemindDay, built with Java 17.

Getting Started

Follow the steps below to set up and run the project:

Prerequisites

Java 17 installed on your machine

Maven for building and managing dependencies

Docker and Docker Compose installed


Setup Instructions

1. Clone the Repository

git clone https://github.com/username/remindday_backend.git
cd remindday_backend


2. Build the Project

The first time you open this repository, run:

mvn clean install

If the build fails, try:

mvn clean install -DskipTests


3. Request Environment Configuration

Send an email to the repository owner to request the .env file.


4. Create .env File

After receiving the .env file, place it in the root directory of the project.


5. Run with Docker Compose

Start the services using Docker Compose:

docker-compose up -d



Additional Information

Make sure all dependencies are installed and running correctly.

For any issues, please refer to the Issues tab on this GitHub repository.


Contact

For any further assistance, please contact the repository owner.


---