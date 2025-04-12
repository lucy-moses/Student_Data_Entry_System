# Student Data Entry System

A robust Java application for managing student records with full CRUD operations, implementing custom exception handling for comprehensive error management.

## Table of Contents
- [System Architecture](#system-architecture)
- [Class Documentation](#class-documentation)
- [Custom Exceptions](#custom-exceptions)
- [Usage Guide](#usage-guide)


## System Architecture
src/

└── studentdatabase

├── Student.java # Core entity class

├── StudentDatabase.java # Database manager

├── StudentAdder.java # Add operations

├── StudentDisplayer.java # Display operations

├── StudentSearcher.java # Search operations

├── StudentUpdater.java # Update operations

├── StudentDeleter.java # Delete operations

├── Main.java # CLI interface

└── exceptions/

├── StudentNotFoundException.java

├── InvalidPRNException.java

├── DuplicateStudentException.java

├── InvalidMarkException.java

├── InvalidPositionException.java

└── DatabaseFullException.java


## Class Documentation

### Core Classes

#### `Student.java`
Represents student entities with:
- **Attributes**: PRN, name, date of birth, marks
- **Methods**: Standard getters/setters, validation logic

#### `StudentDatabase.java`
Manages the student collection and coordinates operations:
- **Capacity**: Fixed-size student array
- **Operation Handlers**: Instantiates adder/searcher/updater/deleter

### Operation Classes

| Class               | Key Methods                      | Description                                  |
|---------------------|----------------------------------|----------------------------------------------|
| `StudentAdder`      | `addStudent()`                   | Validates and adds new students              |
| `StudentSearcher`   | `searchByPRN()`, `searchByName()` | Implements multiple search strategies       |
| `StudentUpdater`    | `updateStudent()`                | Handles record modifications                |
| `StudentDeleter`    | `deleteStudent()`                | Manages student removal                     |

## Custom Exceptions

The system implements a comprehensive exception hierarchy for precise error handling:

### Validation Exceptions

| Exception Class                 | Thrown When                              | Recovery Suggestion                         |
|---------------------------------|-----------------------------------------|---------------------------------------------|
| `InvalidPRNException`           | Empty or malformed PRN provided         | Provide a non-empty PRN string              |
| `InvalidMarkException`          | Marks outside 0-100 range               | Enter marks between 0 and 100               |
| `InvalidPositionException`      | Invalid array index requested           | Use position between 1-[student count]      |

### Operational Exceptions

| Exception Class                 | Thrown When                              | Recovery Suggestion                         |
|---------------------------------|-----------------------------------------|---------------------------------------------|
| `DatabaseFullException`         | Attempt to exceed capacity              | Delete students or increase capacity       |
| `DuplicateStudentException`     | PRN already exists in system            | Use unique PRN or update existing record   |
| `StudentNotFoundException`      | Requested student doesn't exist         | Verify PRN/name or add new student         |

**Exception Hierarchy**:
Exception

├── InvalidPRNException

├── InvalidMarkException

├── InvalidPositionException

├── DatabaseFullException

├── DuplicateStudentException

└── StudentNotFoundException


## Usage Guide

### Running the Application
```bash
# Compile
javac -d bin src/studentdatabase/*.java src/studentdatabase/exceptions/*.java

# Execute
java -cp bin studentdatabase.Main
