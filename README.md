# coursesapi-backend-IIT

Note on Containerization :- 
The frontend application is properly containerized and available on my DockerHub account. However, I tried extensively to containerize the backend application, but due to version mismatches, it couldn't be completed successfully. The backend application is fully functional and works perfectly when run locally on your machine. I'm currently working on resolving the issues to containerize the backend.





Note on Frontend and Backend Application :-

Overview :-
The application includes a Spring Boot backend and a React frontend. The backend handles course and course instance management via RESTful APIs, while the frontend provides a user interface for interacting with these APIs.

Features: :-
1. Spring Boot Backend :-
   - Manages "Course" and "CourseInstance" entities.
   - Provides CRUD APIs for courses and instances.
   - Utilizes MySQL for storage.
   - Dockerized for easy deployment.

2. React Frontend :-
   - User-friendly interface for managing course data.
   - Includes forms for adding courses and instances.
   - Lists and searches courses and instances.
   - Dockerized and successfully pushed to DockerHub.

Issues Faced :-

1. Internal Server Errors :-
   - Inconsistent 500 errors in the backend, sometimes self-resolving.
   - Likely causes include database misconfigurations and Docker-related issues.
   - Attempts to fix included retry logic and adjusting `docker-compose.yaml` for proper startup order.

2. Container Problems :-
   - Startup Order: Backend sometimes tries to connect to MySQL before it's ready, resolved by adjusting `docker-compose.yaml`.
   - Connectivity Issues: Occasional network errors between containers, mitigated with better Docker networking setups.
   - Version Mismatch: The backend container wasn’t pushed to DockerHub due to version mismatches, leaving it local, while the frontend container is available on DockerHub.

Current Status :-
The application generally works well, though occasional internal server errors need monitoring. The frontend container is on DockerHub, but the backend remains local due to version mismatches.
