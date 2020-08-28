# Set up database
To run this App, you will need to first install mysql in your local.
Creat empty schema
```
CREATE DATABASE bank CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
Also please make sure you also configure the application.properties username/password based on your local database set up
# How to run it?

If you have gradle installed and under linux/mac:

    gradle runJar

If gradle is not installed, but still under linux/mac

    gradlew runJar

And for windows without gradle

    gradlew.bat runJar

After the server is running, go to

```
http://localhost:8080
```

# Test api

## Load API
Endpoint (123 is messageId, but since we simplified the process, it is not really used)
```
POST http://localhost:8080/load/123

Body  (application/json)
{
    "userId": "123",
    "transactionAmount": "100.0"
}
```

## Authorization API
Endpoint (123 is messageId, but since we simplified the process, it is not really used)
```
http://localhost:8080/authorization/123

Body  (application/json)
{
    "userId": "123",
    "transactionAmount": "100.0"
}
```
