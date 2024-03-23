
# Expense Tracker API

Expense Tracker API app built on Spring Boot and Java, seamlessly integrated with MySQL database. Easily record, categorize, and analyze expenses.
Deployed link: https://eta.up.railway.app/

## Features

- Registration
- Login
- Pagination
- Sorting Expenses
- Filters
- Add, Update, Delete & View Expenses


## Tech Stack

**Client:** Java (17), Spring Boot (3.1.9)

**Server:** MySQL


## API Reference


#### Register user

```http
  POST /url/register
```

Takes JSON fields 'name' , 'email' , 'password' , 'age' and returns the registered user details.

#### Login user

```http
  POST https://eta.up.railway.app/login
```

Takes JSON fields 'email' , 'password' and returns the 200 OK status code if successfull.

#### Read user

```http
  GET https://eta.up.railway.app/user
```

Returns details of current user.

#### Update user

```http
  PUT https://eta.up.railway.app/user
```

Takes JSON fields and returns updated details of current user.

#### Delete user

```http
  DELETE https://eta.up.railway.app/user
```

Delete current user and their expense records.

