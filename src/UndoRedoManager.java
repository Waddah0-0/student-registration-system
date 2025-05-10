import java.util.Stack;

public class UndoRedoManager {
    private Stack<EnrollmentAction> undoStack;
    private Stack<EnrollmentAction> redoStack;
    private RegistrationSystem system;

    public UndoRedoManager(RegistrationSystem system) {
        this.system = system;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Inner class for enrollment actions
    private class EnrollmentAction {
        private int studentID;
        private int courseID;
        private boolean isEnrollment; // true for enroll, false for remove

        public EnrollmentAction(int studentID, int courseID, boolean isEnrollment) {
            this.studentID = studentID;
            this.courseID = courseID;
            this.isEnrollment = isEnrollment;
        }

        public void execute() {
            if (isEnrollment) {
                system.enrollStudent(studentID, courseID);
            } else {
                system.removeEnrollment(studentID, courseID);
            }
        }

        public void undo() {
            if (isEnrollment) {
                system.removeEnrollment(studentID, courseID);
            } else {
                system.enrollStudent(studentID, courseID);
            }
        }
    }

    public void addEnrollmentAction(int studentID, int courseID, boolean isEnrollment) {
        EnrollmentAction action = new EnrollmentAction(studentID, courseID, isEnrollment);
        undoStack.push(action);
        redoStack.clear();
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        EnrollmentAction action = undoStack.pop();
        action.undo();
        redoStack.push(action);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        EnrollmentAction action = redoStack.pop();
        action.execute();
        undoStack.push(action);
    }
} 