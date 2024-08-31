# User management API
Developed in ```Spring Framework 5``` with ```Spring Boot 2.5.6```

These projects use:
- Dependency Inyection
- Qualifiers
- SpEL
- Aspect Oriented Programming (AOP)
- Http
- Spring data + JPA + H2
- Micrometer
- Grafana
- Spring cache
- Spring Security
- Inversion of control
- Stereotypes
- Profiles
- Spring Beans Life Cycle
- Spring REST
- Spring metrics y Actuator
- Prometheus
- Swagger
- Redis
- Apache Kafka

This API lets you:
- List, create, update, delete users.
- List, create, update, delete, assign roles.
- List, create profiles for users.

------------

### Commands needed to properly run this API
- **Kafka commands**:
	- Zookeeper: ```.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties```
	- Kafka server: ```.\bin\windows\kafka-server-start.bat .\config\server.properties```
- **Redis**: execute the file ```redis-server.exe```
- **Spring**: ```./mvnw spring-boot:run```

------------

## TABLE OF CONTENTS

- [Endpoints](#endpoints)
    + [Users](#users)
      - [Get all usernames](#get-all-usernames)
      - [Get user by id](#get-user-by-id)
      - [Get user by username](#get-user-by-username)
      - [Create user](#create-user)
      - [Update user - TO BE PROGRAMMED](#update-user---to-be-programmed)
      - [Delete user](#delete-user)
    + [Roles](#2-roles)
      - [Get all roles](#get-all-roles)
      - [Create role](#create-role)
      - [Update role](#update-role)
      - [Delete role](#delete-role)
      - [Assign role](#assign-role)
      - [Get users by role](#get-users-by-role)
    + [Profiles](#3-profiles)
      - [Create profile for user](#create-profile-for-user)
      - [Get profile by user id and profile id](#get-profile-by-user-id-and-profile-id)
      - [Get profile by user id](#get-profile-by-user-id)

## Endpoints

### 1. Users
#### Get all users
> GET /users

- Basic Auth: (**Role must be ADMIN**)  
  - Username and password generated in console logs for debug purpose.
  - Example:
	  - Username:  "lon.rau"
	  - Password: "Zamasu"


- Output:
```
{
  "content": [
    {
      "id": 1,
      "username": "delfina.morissette",
      "password": "Champa"
    },
    {
      "id": 2,
      "username": "maragaret.torphy",
      "password": "Android 19"
    },
    . . .
    {
      "id": 100,
      "username": "nila.greenholt",
      "password": "Android 16"
    }
    ],
    "pageable": {
      "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
      },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 1000,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 100,
    "first": true,
    "size": 1000,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 100,
    "empty": false
}
```

------------

#### Get all usernames
> GET /users/usernames

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Output:
```
{
    "content": [
        "royce.cronin",
        "odis.lesch",
        "mirella.towne",
        "ngoc.mclaughlin",
        "delia.wyman",
        "tiera.rolfson",
        . . .
        "mozella.goodwin"
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 1000,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 100,
    "size": 1000,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "first": true,
    "numberOfElements": 100,
    "empty": false
}
```

------------

#### Get user by id
> GET /users/{user_id}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Output:
```
{
    "id": 1,
    "username": "royce.cronin",
    "password": "Demon King Piccolo"
}
```

------------

#### Get user by username
> GET /users/username/{username}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Output:
```
{
    "id": 100,
    "username": "mozella.goodwin",
    "password": "Dende"
}
```


------------

#### Create user
> POST /users

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Body:
```
{
    "nickName": "Danieh",
    "username": "amogus",
    "password": "kaileseabaja"
}
```

- Output
> 201 CREATED

------------

#### Update user - TO BE PROGRAMMED
> PUT /users/{username}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Body:
```
{
    "nickName": "Danieh",
    "username": "amogus",
    "password": "chido"
}
```

- Output:
> 200 OK

------------
#### Delete user
> DELETE /users/{username}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
  - Username and password generated in console logs for debug purpose.

- Output:
> 204 No Content


------------

### 2. Roles
#### Get all roles
> GET /roles

- Basic Auth: (**Role must be ADMIN**)
  - Username and password generated in console logs for debug purpose.
  - Example:
	  - Username:  "lon.rau"
	  - Password: "Zamasu"


- Output:
```
[
    {
        "id": 1,
        "name": "ADMIN"
    },
    {
        "id": 2,
        "name": "SUPPORT"
    },
    {
        "id": 3,
        "name": "USER"
    }
]
```

------------

#### Create role
> POST /roles

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
-- Username and password generated in console logs for debug purpose.

- Body:
```
{
  "name":"ADMIN"
}
```

- Output:
> 201 CREATED


------------

#### Update role
> PUT /roles/{role_id}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
	- Username and password generated in console logs for debug purpose.

- Body:
```
{
  "id": 1,
  "name": "admin"
}
```

- Output:
> 200 OK


------------

#### Delete role
> DELETE /roles/{role_id}

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
	- Username and password generated in console logs for debug purpose.

- Output:
> 204 No Content

------------

#### Assign role
> POST /roles/assign

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
	- Username and password generated in console logs for debug purpose.

- Body:
```
{
  "user": { "id": 2 },
  "role": { "id": 2 }
}
```

- Output:
```
{
    "id": 102,
    "user": {
        "id": 2,
        "username": "santa.kris",
        "password": "Demon King Piccolo"
    },
    "role": {
        "id": 3,
        "name": "USER"
    }
}
```

------------

#### Get users by role
> GET /roles/{role_name}/users

- Basic Auth: (same as the previous example) - **Role must be ADMIN**
	- Username and password generated in console logs for debug purpose.

- Output:
```
[
  {
    "id": 5,
    "username": "ted.medhurst",
    "password": "Yajirobe"
  }
]
```

------------

### 3. Profiles
#### Create profile for user
> POST /users/{user_id}/profiles

- Basic Auth: no auth required.

- Body:
```
{
  "firstName": "Danieh",
  "lastName": "Ofisial",
  "birthDate": "2002-03-24T00:00:00.00"
}
```

- Output:
```
{
  "id": 1,
  "firstName": "Danieh",
  "lastName": "Ofisial",
  "birthDate": "2002-03-24T00:00:00.000+00:00",
  "user": {
    "id": 2,
    "username": "santa.kris",
    "password": "Demon King Piccolo"
  }
}
```

------------

#### Get profile by user id and profile id
> GET /users/{user_id}/profiles/{profile_id}

- Basic Auth: no auth required.

- Output:
```
{
  "id": 1,
  "firstName": "Danieh",
  "lastName": "Ofisial",
  "birthDate": "2002-03-24T00:00:00.000+00:00",
  "user": {
    "id": 2,
    "username": "santa.kris",
    "password": "Demon King Piccolo"
  }
}
```

------------

#### Get profile by user id
> GET /users/{user_id}/profiles

- Basic Auth: no auth required.

- Output:
```
{
  "id": 1,
  "firstName": "Danieh",
  "lastName": "Ofisial",
  "birthDate": "2002-03-24T00:00:00.000+00:00",
  "user": {
    "id": 2,
    "username": "santa.kris",
    "password": "Demon King Piccolo"
  }
}
```
