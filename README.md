# Student Registration System

A comprehensive Java-based system for managing student course registrations with advanced features including undo/redo functionality, sorting capabilities, and status monitoring.

## System Overview

The Student Registration System is designed to manage student enrollments in courses with a focus on:
- Efficient data management using linked lists
- Real-time status tracking
- Flexible enrollment operations
- History management with undo/redo capabilities

## Detailed Features

### Student Management
- **Add Students**
  - Add new students with unique numeric IDs
  - System tracks the last added student
  - Automatic validation of student existence
  - Success confirmation messages

- **Remove Students**
  - Remove students from the system
  - Automatically removes all course enrollments
  - Updates all related course lists
  - Success confirmation messages

### Course Management
- **Add Courses**
  - Add new courses with unique numeric IDs
  - System tracks the last added course
  - Automatic validation of course existence
  - Success confirmation messages

- **Remove Courses**
  - Remove courses from the system
  - Automatically removes all student enrollments
  - Updates all related student lists
  - Success confirmation messages

### Enrollment Operations
- **Enroll Students**
  - Enroll students in available courses
  - Validates both student and course existence
  - Prevents duplicate enrollments
  - Success confirmation messages

- **Remove Enrollments**
  - Remove students from specific courses
  - Validates both student and course existence
  - Success confirmation messages

- **List Operations**
  - List all courses for a specific student
  - List all students in a specific course
  - Clear formatting with ID labels
  - Error handling for non-existent entries

### Sorting Capabilities
- **Course Sorting**
  - Sort courses by ID for a specific student
  - Maintains original data structure
  - Displays sorted list with clear formatting
  - Error handling for non-existent students

- **Student Sorting**
  - Sort students by ID in a specific course
  - Maintains original data structure
  - Displays sorted list with clear formatting
  - Error handling for non-existent courses

### Status Monitoring
- **Course Status**
  - Check if a course is full (30 students maximum)
  - Real-time capacity monitoring
  - Clear status messages
  - Error handling for non-existent courses

- **Student Status**
  - Check if a student is normal (2-7 courses)
  - Real-time enrollment monitoring
  - Clear status messages
  - Error handling for non-existent students

### Undo/Redo System
- **Undo Operations**
  - Undo last enrollment action
  - Undo last removal action
  - Maintains action history
  - Clear success messages

- **Redo Operations**
  - Redo previously undone actions
  - Maintains redo history
  - Clear success messages
  - Automatic redo stack clearing on new actions

## Technical Implementation

### Data Structures
- **Custom LinkedList Implementation**
  - Efficient student list management
  - Efficient course list management
  - Dynamic enrollment tracking
  - Optimized for frequent updates

### Stack Implementation
- **Action Tracking**
  - Undo stack for action history
  - Redo stack for undone actions
  - Automatic stack management
  - Efficient memory usage

### Error Handling
- **Validation System**
  - Student existence validation
  - Course existence validation
  - Enrollment validation
  - Clear error messages

## User Interface

### Menu System
1. Add Student
2. Add Course
3. Enroll Student in Course
4. Remove Student from Course
5. List Courses for Student
6. List Students in Course
7. Sort Courses for Student
8. Sort Students in Course
9. Check if Course is Full
10. Check if Student is Normal
11. Undo Last Action
12. Redo Last Action
0. Exit

### Input/Output
- Clear menu prompts
- Numeric input validation
- Formatted output display
- Error message formatting

## System Requirements

### Software Requirements
- Java Runtime Environment (JRE) 8 or higher
- Command line interface support

### Hardware Requirements
- Minimal memory requirements
- Standard processor capability
- Basic storage space

## File Structure

- `Main.java`: Menu-driven interface and user interaction
- `RegistrationSystem.java`: Core system implementation and business logic
- `UndoRedoManager.java`: Undo/redo functionality management
- `LinkedList.java`: Custom linked list implementation

## Usage Guidelines

### Best Practices
- Use unique IDs for students and courses
- Monitor course capacities
- Check student status regularly
- Use undo/redo for error correction

### Limitations
- Course capacity: 30 students maximum
- Normal student: 2-7 courses
- Undo/redo: Enrollment operations only
- ID format: Numeric values only

## Example Scenarios

### Basic Operations
```
1. Adding a Student
   Enter student ID: 1
   Student 1 added successfully!

2. Adding a Course
   Enter course ID: 101
   Course 101 added successfully!

3. Enrolling a Student
   Enter student ID: 1
   Enter course ID: 101
   Student 1 enrolled in course 101 successfully!
```

### Advanced Operations
```
1. Checking Course Status
   Enter course ID: 101
   Course 101 is not full

2. Checking Student Status
   Enter student ID: 1
   Student 1 is a normal student

3. Sorting Courses
   Enter student ID: 1
   Courses sorted by ID for student 1:
   Course ID: 101
   Course ID: 102
```

## Maintenance and Support

### Regular Checks
- Monitor system performance
- Verify data integrity
- Check error logs
- Update as needed

### Troubleshooting
- Verify input format
- Check error messages
- Use undo/redo for corrections
- Validate data consistency 