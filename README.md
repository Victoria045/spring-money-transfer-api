# spring-money-transfer-api
This is a RESTful API for creating accounts and implements money transfer between accounts.

## Author 
[Victoria Beryl](https://github.com/Victoria045)

#### Prerequisites
* JAVA
* Spring boot
* PostgreSQL

## Setup and Installation
* Open Terminal:
```bash
        $ git clone git@github.com:Victoria045/spring-money-transfer-api.git
        $ open via your IDE preferably IntelliJ IDEA 
        
        Note: In the application properties set the correct credentials for PostgreSQL.
```

## Running the application
* Open Terminal:
```bash
        $ mvn spring:boot run
```
## API:
#### Note:
```bash
         The application requires authorization by Basic Auth
         Credentials: Username: development
                      Password: dXNlcjpwYXNzd29yZA==
                    
```
### Create Account:
```bash
        POST localhost:8080/accounts/
        
           Request Payload
           {
                {
                  "initialBalance":2000
                }
            }
            
            Note: Initial balance cannot be either 0 or a negative value.
```
### Get Account:
```bash
        GET localhost:8080/accounts/{id}
```
### Transfer Money:
```bash
        POST localhost:8080/transfers
        
               Request Payload
               {
                    "sourceAccountId": 1,
                    "targetAccountId": 2,
                    "amount": 1000
                }
```
### Screenshot:
![Screenshot from 2023-04-05 17-50-34](https://user-images.githubusercontent.com/50333645/230119026-f22cbfef-a3d0-440f-9c7c-593941f1d5bd.png)
![Screenshot from 2023-04-05 17-51-25](https://user-images.githubusercontent.com/50333645/230119060-5ce958a4-6fbe-4140-9d5b-2519dc3cb64f.png)

### License
[![License](https://img.shields.io/packagist/l/loopline-systems/closeio-api-wrapper.svg)](git@github.com:Victoria045/spring-money-transfer-api.git/blob/master/LICENSE)
