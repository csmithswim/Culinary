Stage 2 objectives: 
[]Create unique ID's with the recipe object
[]Adjust POST request to respond with a JSON object that includes only
    the ID field && Http.status.code of 200.
[]Refactor recipe object's fields for ingredients and directions to be
    String[]
[]Refactor GET request to accept an ID as its @RequestParam and responds with 
    Http.status.code of 200 and the recipe object if found, 404 if not found.

