#Sample Spring / Gradle / Docker application

The application tries to load the authentication file from firebase.json , and initialize a Firebase client

Clone the project to your local machine or a non-google VM

Add your GCP Auth file content into the "firebase.json" file at the root of the application

navigate to the root of the project

Build the image LOCALLY or a non-google VM with :

`docker build --build-arg JAR_FILE=build/libs/\*.jar -t GROUP_NAME/IMAGE_NAME .`

Then run the container LOCALLY or a non-google VM with:

`docker run -p 8080:8080 --name MY_CONTAINER -t GROUP_NAME/IMAGE_NAME`

See logs.


