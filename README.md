# Super*Duper*Drive Cloud Storage

Demo:http://ec2-52-91-196-164.compute-1.amazonaws.com:49155/login

![filepage.png](https://raw.github.com/cagehao/Cloud-Storage/master/images/filepage.png)
![noteupload.png](https://raw.github.com/cagehao/Cloud-Storage/master/images/noteupload.png)
This is a personal cloud storage application that forked from the project starter of udacity Java Web Developer Course with some basic settings, And I developed it to have the following user-facing features:

1. **Simple File Storage:** Upload/download/remove files
2. **Note Management:** Add/update/remove text notes
3. **Password Management:** Save, edit, and delete website credentials.  

## Get started
1. Open the "starter/cloudstorage/pom.xml" as project
2. Run starter/cloudstorage/src/main/java/com/udacity/jwdnd/course1/cloudstorage/CloudStorageApplication.java 
3. Access <locahost:8080/login> in browser

## Features and Roadmap

1. The back-end with Spring Boot
2. The front-end with Thymeleaf
3. Application tests with Selenium

### The Back-End
The back-end is all about security and connecting the front-end to database data and actions. 

1. Managing user access with Spring Security
 - Restrict unauthorized users from accessing pages other than the login and signup pages.

2. Handling front-end calls with controllers
 - Using Spring MVC's application model to identify the templates served for different requests and populating the view model with data needed by the template. 
 - The controllers are responsible for determining what, if any, error messages the application displays to the user.


3. Making calls to the database with MyBatis mappers
 - Implemented MyBatis mapper interfaces for each of the model types. These mappers have methods that represent specific SQL queries and statements required by the functionality of the application. They support the basic CRUD (Create, Read, Update, Delete) operations for their respective models.


### The Front-End
HTML templates have included fields, modal forms, success and error message elements, as well as styling and functional components using Bootstrap as a framework. And these templates are edited and inserted Thymeleaf attributes to supply the back-end data and functionality described by the following individual page requirements:

1. Login page
 - Everyone should be allowed access to this page, and users can use this page to login to the application. 
 - Show login errors, like invalid username/password, on this page. 


2. Sign Up page
 - Everyone is allowed access to this page, and potential users can use this page to sign up for a new account. 
 - Validate that the username supplied does not already exist in the application, and show such signup errors will be shown on the page when they arise.
 - User's password are stored securely!


3. Home page
The home page is the center of the application and hosts the three required pieces of functionality. The existing template presents them as three tabs that can be clicked through by the user:


 i. Files
  - The user should be able to upload files and see any files they previously uploaded. 

  - The user should be able to view/download or delete previously-uploaded files.
  - Any errors related to file actions should be displayed. For example, a user should not be able to upload two files with the same name, but they'll never know unless you tell them!


 ii. Notes
  - The user should be able to create notes and see a list of the notes they have previously created.
  - The user should be able to edit or delete previously-created notes.

 iii. Credentials
 - The user should be able to store credentials for specific websites and see a list of the credentials they've previously stored. If you display passwords in this list, make sure they're encrypted!
 - The user should be able to view/edit or delete individual credentials. When the user views the credential, they should be able to see the unencrypted password.

The home page should have a logout button that allows the user to logout of the application and keep their data private.

### Testing
Your tech lead trusts you to do a good job, but testing is important whether you're an excel number-cruncher or a full-stack coding superstar! The QA team at Super*Duper*Drive carries out extensive user testing. Still, your tech lead wants you to write some simple Selenium tests to verify user-facing functionality and prove that your code is feature-complete before the testers get their hands on it.

1. Tests for user signup, login, and unauthorized access restrictions.

2. Tests for 404 bad url page.

3. Tests for large file upload.
