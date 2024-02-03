# CPSC6175 Assignment 1 - NASA APOD API

## Assignment Details
For your assignment: You will create a new controller, object and endpoint to connect to the NASA api. For that you will need to generate a key, it is instant and you will recieve it in your email. Keep the key stored in the backend it does not need to be passed as a variable.
Your API should consume all of the query params for the Nasa APOD (picture of the day) API. These include:
* date
* start_date
* end_date
* count
* thumbs
* api_key (stored in the backend and it is your key)
From your controller perspective all these should be optional as well so they have to be query params themselves.

Deliverable: Your GitHub link with the endpoint for the Nasa API documented in the read me.

## Notes
Build: Maven

Mapping: /NASA_APOD

Set the property apod.api.key to use a specific API key. To avoid exposing the key generated to test this assignment, it has been set to the public DEMO_KEY when committed.

Available Parameters: 
* **api_key**: optional override API key. If no key is specified, the application defaults to using the value of the property apod.api.key
* **date**: specific date to retrieve, in ISO 8601 format
* **start_date**: start date of range to retrieve. If no end date is specified, retrieves all entries from the start date to present
* **end_date**: end date of range, when used with start_date, in the same format
* **count**: number of random entries to retrieve. Do not use with any date parameter
* **thumbs**: return URL of video thumbnail, if the APOD is indeed a video

All parameters are optional, including api_key which will return a 403 error from NASA's API if invalid.
The APOD API returns a JSON array if certain options are used (start_date, end_date, count). For simplicity and consistency, the assignment's endpoint always returns a list.


## Examples
localhost:8080/NASA_APOD&count=2
!["Example of &count=2 showing two random results"](https://i.imgur.com/s4izPsN.png)

localhost:8080/NASA_APOD&date=2024-01-26
!["Example of &date=2024-01-26 showing one result from a different day"](https://i.imgur.com/RzW2ibv.png)

localhost:8080/NASA_APOD
!["Example of the default result with no parameters - today's image"](https://i.imgur.com/bhHS03C.png)
