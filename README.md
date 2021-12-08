# appsmith-talks
Steps to run project

1. You need to create the database with appsmith and the table will automatically be generated using hibernate.
	(Note : I have used MySQL Server 8.0 while development)

2. Update the application.properties file and change below parameter
	- spring.datasource.url
	- spring.datasource.username
	- spring.datasource.password
	
3. Import the project as maven project in STS IDE.

4. Run below maven commands
	- mvn clean install
	
5. Run project as spring boot application

6. Hit this URL: http://localhost:8080/swagger-ui.html


### API ###

1. Created speakers and attendee 
	This API used to create speakers and attendee. You must need to specify the role for it. Please use 0 - Speaker and 1 - Attendee
2. Created talks
	This API used to create a new talk
3. Created retrieve talks
	This API used to retrieve talks by the speaker and search by title or description
4. Created attendee for talks
	This API used to create attendee for talks with the particular user.
