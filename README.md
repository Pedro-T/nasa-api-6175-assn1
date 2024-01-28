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

Available Parameters: api_key, date, start_date, end_date, count, thumbs

All parameters are optional, including api_key which will return a 403 error from NASA's API if missing or invalid. The APOD API returns a JSON array if certain options are used (start_date, end_date, count). For simplicity and consistency, the assignment's endpoint always returns a list.


## Examples
localhost:8080/NASA_APOD?api_key=YOURKEY&count=2
!["Example of &count=2 showing two random results"](https://i.imgur.com/s4izPsN.png)

localhost:8080/NASA_APOD?api_key=YOURKEY&date=2024-01-26
!["Example of &date=2024-01-26 showing one result from a different day"](https://i.imgur.com/RzW2ibv.png)

localhost:8080/NASA_APOD?api_key=YOURKEY
!["Example of the default result with no parameters other than API key - today's image"](https://i.imgur.com/bhHS03C.png)
