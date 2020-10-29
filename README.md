# Library-management-system-java-javaFX-SQL
Library management system to help smoothen the process for admins and users. 
You can fund all the data related to DataBase(SQL) in DBInfo.java
Functional requirements: 
Admin Authorization: 
  The admin need to insert id and password 
Add new user: 
  The customer can register as a user 
  The customer can have id and password 
  The customer need to add his identification info 
User authentication: 
  The user need to insert id and password 
Search book: 
  Admins and users can search books. 
  The search can be made by book id or name or publisher or category. 
Issue book:
  Users must be registered to issue books.
  Admin can issue books 
  The books to be issued must be available and not out of stock. 
Return book: 
  Users must have user id and book id to return book. 
  Admin can return books. 
  Books must be returned before certain date. 
Register new book: 
  Only admins can register a book. 
  The book to be registered must fit in a category. 
Edit books: 
  Only admins can update the data of the books. 
Delete books: 
  Only admins can update the data of the books.      
Non-functional requirements: 
  performance requirements: 
  Performance of system should be fast and accurate.  
Security requirements: 
  Users validation using id and password. 
  Only admins can edit, delete and register a new book. 
User-friendly requirements: 
  The system is easy to use.  
Development environment: 
  Java MYSQL
