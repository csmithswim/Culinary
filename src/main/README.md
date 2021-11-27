Stage 4 objectives: 
In this stage, the recipe structure should contain two new fields:
[x] category represents a category of a recipe. The field has the same restrictions as name and description. It shouldn't be blank;

[]date stores the date when the recipe has been added (or the last update). You can use any date/time format, for example 2021-09-05T18:34:48.227624 (the default 
LocalDateTime format), but the field should have at least 8 characters.

Also, the service should support the following endpoints:

[]PUT /api/recipe/{id} receives a recipe as a JSON object and updates a recipe with a specified id. Also, update the date field too. The server should return the 204 (No 
Content) status code. If a recipe with a specified id does not exist, the server should return 404 (Not found). The server should respond with 400 (Bad Request) if a recipe 
doesn't follow the restrictions indicated above (all fields are required, string fields can't be blank, arrays should have at least one item)

[]GET /api/recipe/search takes one of the two mutually exclusive query parameters:
category – if this parameter is specified, it returns a JSON array of all recipes of the specified category. Search is case-insensitive, sort the recipes by date (newer first);
name – if this parameter is specified, it returns a JSON array of all recipes with the names that contain the specified parameter. Search is case-insensitive, sort the recipes by date (newer first).

[]If no recipes are found, the program should return an empty JSON array. If 0 parameters were passed, or more than 1, the server should return 400 (Bad Request). The same 
response should follow if the specified parameters are not valid. If everything is correct, it should return 200 (Ok).


