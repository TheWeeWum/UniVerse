# UofTMapper

## Problem domain
On a campus as large as UofT it could be difficult to find a good study spot and avoid the crowds. Thus, we want to make an application designed to provide information about the campus to help students navigate and discover new places on campus. 

## Features
1. Students can write reviews for lecture halls, bathrooms, cafeteria, or overall facilities for specific buildings. Students can indicate whether or not a building has amenities such as microwaves etc.
2. Students can mark each of their lecture/tutorial room locations
   We can save this info to categorize the buildings into Social Sciences building, Math & Physics building, Engineering building, CS building, etc.
   New students can look at our com.app to see where their courses have generally been held in the past, and decide where to live.
3. Students can log in to keep their account information, like favorite study spots or favorite bathroom as pins.
4. Create a heat map of student population/population density for areas so students can avoid crowded areas
   Help students avoid being late to class
   
## Additional features
1. Community Tab: Students can post UofT related content and interact with other students
2. Events Tab: Keep students updated about school events and where they are occurring. This can help drive more engagement for these events as well.
3. Adding friends: Allow users to upload their timetables and share their time tables with friends

## List of API
1. Google map API: https://developers.google.com/maps/documentation/maps-static
   for map image layout
2. YouTube API: https://developers.google.com/youtube/v3/getting-started
   allows us to put youtube videos inside our com.app (virtual tours of various buildings)
3. other map APIs: https://blog.hubspot.com/website/free-api-maps

## Using a tool to try out the API
![Capture2](https://github.com/TheWeeWum/UofTMapper/assets/87148396/442c73e8-34ef-4666-a095-e335b6467c29)

## Example output of our Java code
https://drive.google.com/file/d/1HHD0ERHB9Aw1QVzghszsZIoTiPcA6UNT/view?usp=drive_link

Top has the GeoEncoding api request results and the bottom is a link to an image like the one you see above in the hoppscotch request.

## Example of the code calling the output
![Capture](https://github.com/TheWeeWum/UofTMapper/assets/87148396/9595e47e-3df0-4ab7-98c1-4e4055d448f2)
