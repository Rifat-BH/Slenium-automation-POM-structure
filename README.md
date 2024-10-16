# Selenium Project Documentation

## Overview

This project is a Selenium automation framework built using Java and Maven, designed to test functionalities of the OrangeHRM application through a series of test cases. 

## Prerequisites

- **Java**: Installed Java version 22.0.1
- **IDE**: IntelliJ IDEA
- **Version Control**: Git and GitHub for repository management

## Setup Instructions

1. **Create a Maven Project**: Start by creating a new project in IntelliJ using Maven.
2. **Set Up Git Repository**: After installing Git, initialize a Git repository and link it to your GitHub account.

## Dependencies

Add the following dependencies to your `pom.xml` file from [MvnRepository](https://mvnrepository.com):

- Selenium
- TestNG
- WebDriver Manager
- ExtentReports
- Apache POI
- POI-Ooxml
- SLF4J API
- Log4j API
- Log4j Core
- Log4j SLF4J Implementation

## Test Suite Configuration

Create a `testng.xml` file to define your test suites and test configurations.

## Project Structure

### Directory Structure

In the `java` directory under the `test` directory, the following packages and classes are created:

- **Objects Package**: Contains different test classes.
  - **GoogleSearchOrangeHRM**: 
    - Searches for the OrangeHRM demo on Google and navigates to the website using Selenium.
  - **LoginOrangeHRM**: 
    - Captures the username and password fields using `By`, provides the login credentials, and submits the information.
  - **AddEmployee**: 
    - Navigates to the Add Employee page, captures user information, and submits the data.
  - **RemoveEmployee**: 
    - Removes an employee by capturing the username and submitting the removal action.

### Test Scenario

In the `Test_scenario` class, tests are conducted sequentially with the following methods:

- **Setup WebDriver**: Imports necessary packages and initializes the WebDriver.
  
- **Test Methods**:
  - `@BeforeTest`: Set up WebDriver.
  - `@Test(priority = 1)`: `searchOperation()`: Searches for OrangeHRM demo from Google.
  - `@Test(priority = 2)`: `accessOrangeHRM()`: Accesses the OrangeHRM site.
  - `@Test(priority = 3)`: `loginOrangeHRM()`: Provides login credentials to log in.
  - `@Test(priority = 4)`: `testAddEmployee()`: Reads user information from an Excel file and adds new users.
  - `@Test(priority = 5)`: `removeEmployeeTest()`: Removes a user by providing their username.
  - `@AfterTest`: Closes the WebDriver.

### Utilities

In the `utils` package, the `UserDetailsFromExcel` class is implemented to read an Excel file and extract user information for adding new users. A dynamic `ArrayList` is used to handle multiple user entries.

## Reporting

The framework generates HTML test reports to provide insights into the test execution results.
![Screenshot from 2024-10-16 15-35-54](https://github.com/user-attachments/assets/e355b866-1add-492b-badf-f53774bc2f0f)

