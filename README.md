
# Expense Tracker API

Expense Tracker API app built on Spring Boot and Java, seamlessly integrated with MySQL database. Easily record, categorize, and analyze expenses.

Deployed link: https://eta.up.railway.app/

## Demo Data

Email: demouser@gmail.com
Password: demouser

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
  POST https://eta.up.railway.app/register
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

#### Add expense

```http
  POST https://eta.up.railway.app/expenses
```

Add new expense for current user.

#### View expense

```http
  GET https://eta.up.railway.app/expenses
```

Read all expenses for current user.

#### Delete expense

```http
  DELETE https://eta.up.railway.app/expenses/{expense_id}
```

Delete expense using the id provided.

#### Update expense

```http
  PUT https://eta.up.railway.app/expenses/{expense_id}
```

Update expense by passing new body with updated data.

#### Filter expense by category

```http
  GET https://eta.up.railway.app/expenses?category={category}
```

Get filtered records by category.

#### Filter expense by name keyword

```http
  GET https://eta.up.railway.app/expenses?keyword={keyword}
```

Get filtered records by name keyword.

#### Filter expense by date

```http
  GET https://eta.up.railway.app/expenses?start={start_date}&end={end_date}
```

Get filtered records between start and end date.