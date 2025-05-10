public class RegistrationSystem {
    private LinkedList studentsList;
    private LinkedList coursesList;
    private UndoRedoManager undoRedoManager;

    private int lastStudentAdded;
    private int lastCourseAdded;

    public RegistrationSystem() {
        studentsList = new LinkedList();
        coursesList = new LinkedList();
        undoRedoManager = new UndoRedoManager(this);
        lastStudentAdded = -1;
        lastCourseAdded = -1;
    }

    public int getLastStudentAdded() {
        return lastStudentAdded;
    }
    public int getLastCourseAdded() {
        return lastCourseAdded;
    }
    public void addStudent(int studentID) {
        studentsList.add(new LinkedList.Node(studentID));
        lastStudentAdded = studentID;
        System.out.println("Student " + studentID + " added successfully!");
    }
    public void addCourse(int courseID) {
        coursesList.add(new LinkedList.Node(courseID));
        lastCourseAdded = courseID;
        System.out.println("Course " + courseID + " added successfully!");
    }
    public void removeStudent(int studentID) {
        studentsList.remove(studentID);
        // remove 'studentID' for each course in coursesList
        LinkedList.Node courseHead = coursesList.getHead();
        while (courseHead != null) {
            courseHead.list.remove(studentID);
            courseHead = courseHead.next;
        }
        System.out.println("Student " + studentID + " removed successfully!");
    }
    public void removeCourse(int courseID) {
        coursesList.remove(courseID);
        // remove 'courseID' For each student in studentsList
        LinkedList.Node studentHead = studentsList.getHead();
        while (studentHead != null) {
            studentHead.list.remove(courseID);
            studentHead = studentHead.next;
        }
        System.out.println("Course " + courseID + " removed successfully!");
    }
    public void enrollStudent(int studentID, int courseID) {
        LinkedList.Node studentNode = studentsList.findNode(studentID);
        LinkedList.Node courseNode = coursesList.findNode(courseID);
        if (studentNode != null && courseNode != null) {
            // Add course to student's list
            studentNode.list.add(new LinkedList.Node(courseID));
            // Add student to course's list
            courseNode.list.add(new LinkedList.Node(studentID));
            
            // Add to undo stack
            undoRedoManager.addEnrollmentAction(studentID, courseID, true);
            System.out.println("Student " + studentID + " enrolled in course " + courseID + " successfully!");
        } else {
            System.out.println("Student or Course not found!");
        }
    }
    public void removeEnrollment(int studentID, int courseID) {
        LinkedList.Node studentNode = studentsList.findNode(studentID);
        LinkedList.Node courseNode = coursesList.findNode(courseID);
        if (studentNode != null && courseNode != null) {
            studentNode.list.remove(courseID);
            courseNode.list.remove(studentID);
            
            // Add to undo stack
            undoRedoManager.addEnrollmentAction(studentID, courseID, false);
            System.out.println("Student " + studentID + " removed from course " + courseID + " successfully!");
        } else {
            System.out.println("Student or Course not found!");
        }
    }
    public void listCoursesByStudent(int studentID) {
        LinkedList.Node studentNode = studentsList.findNode(studentID);
        if (studentNode != null) {
            System.out.println("Courses for student " + studentID + ":");
            LinkedList.Node current = studentNode.list.getHead();
            while (current != null) {
                System.out.println("Course ID: " + current.ID);
                current = current.next;
            }
        } else {
            System.out.println("Student not found.");
        }
    }
    public void listStudentsByCourse(int courseID) {
        LinkedList.Node courseNode = coursesList.findNode(courseID);
        if (courseNode != null) {
            System.out.println("Students enrolled in course " + courseID + ":");
            LinkedList.Node current = courseNode.list.getHead();
            while (current != null) {
                System.out.println("Student ID: " + current.ID);
                current = current.next;
            }
        } else {
            System.out.println("Course not found!");
        }
    }
    private void sortLinkedList(LinkedList list) {
        if (list.getHead() == null) return;
        boolean swapped;
        do {
            swapped = false;
            LinkedList.Node curr = list.getHead();
            while (curr.next != null) {
                if (curr.ID > curr.next.ID) {
                    int temp = curr.ID;
                    curr.ID = curr.next.ID;
                    curr.next.ID = temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }
    public void SortCoursesByID(int studentID) {
        LinkedList.Node studentNode = studentsList.findNode(studentID);
        if (studentNode != null) {
            sortLinkedList(studentNode.list);
            System.out.println("Courses sorted by ID for student " + studentID + ":");
            LinkedList.Node current = studentNode.list.getHead();
            while (current != null) {
                System.out.println("Course ID: " + current.ID);
                current = current.next;
            }
        } else {
            System.out.println("Student not found!");
        }
    }
    public void SortStudentsByID(int courseID) {
        LinkedList.Node courseNode = coursesList.findNode(courseID);
        if (courseNode != null) {
            sortLinkedList(courseNode.list);
            System.out.println("Students sorted by ID for course " + courseID + ":");
            LinkedList.Node current = courseNode.list.getHead();
            while (current != null) {
                System.out.println("Student ID: " + current.ID);
                current = current.next;
            }
        } else {
            System.out.println("Course not found!");
        }
    }
    public boolean isFullCourse(int courseID) {
        LinkedList.Node courseNode = coursesList.findNode(courseID);
        if (courseNode != null) {
            boolean isFull = courseNode.list.size() >= 30;
            System.out.println("Course " + courseID + " is: ");
            return isFull;
        } else {
            System.out.println("Course not found!");
            return false;
        }
    }
    public boolean isNormalStudent(int studentID){
        LinkedList.Node studentNode = studentsList.findNode(studentID);
        if(studentNode!=null){
            boolean isNormal = (studentNode.list.size() >=2 && studentNode.list.size() <= 7);
            System.out.println("Student " + studentID + " is :" );
            return isNormal;
        }else{
            System.out.println("Student not found!");
            return false;
        }
    }
    public void undo() {
        undoRedoManager.undo();
    }
    public void redo() {
        undoRedoManager.redo();
    }
}