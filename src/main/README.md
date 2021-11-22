Stage 3 objectives: 
[]Add new dependencies/configurations to build/gradle and application.properties.
i.e. the application.properties file should contain the following line with the database name: spring.datasource.url=jdbc:h2:file:../recipes_db

[]Store all recipes permanently in a database: after a server restart, all added recipes should be available to a user;
[]Implement a new DELETE /api/recipe/{id} endpoint. Server should respond with 204(No Content) status code and if the specified id does not exist, the server should return 404 
(Not found)
[]The service should only accept valid recipes - all fields are obligatory, name/description should not be blank and JSON arrays should contain at least one item. If these 
requirements are not met then the service should respond with the 400(Bad Request) status code.




