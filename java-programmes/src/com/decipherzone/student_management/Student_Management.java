package com.decipherzone.student_management;

import java.util.*;

class Student {
    public int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return ("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}

class Teacher {
    private int id;
    private String name;
    private String subject;

    public Teacher(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return ("ID: " + id + ", Name: " + name + ", Subject: " + subject);
    }
}

class Course {
    private int id;
    private String name;
    private Teacher assignedTeacher;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public List<Student> getEnrolledStudents()        // provide a list of student enrolled in particular course
    {
        return enrolledStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void enrollStudent(Student s) {
        enrolledStudents.add(s);
    }

    public void assignTeacher(Teacher t) {
        assignedTeacher = t;
    }

    @Override
    public String toString() {
        String teacherStr = (assignedTeacher == null) ? "None" : assignedTeacher.getName();  // ternary operator
        return ("ID: " + id + ", Name: " + name + ", Teacher: " + teacherStr + ", Enrolled: " + enrolledStudents.size());
    }
}

public class Student_Management {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int studentId = 1, teacherId = 1, courseId = 1;       // initialise these later we increase these automatically

    public static void main(String[] args) {
        new Student_Management().startMenu();     // anonymous object is created
    }

    void startMenu() {
        while (true) {
            System.out.println("\nSchool Management System");
            System.out.println("1. Provide Student Details");
            System.out.println("2. Provide Teacher Details");
            System.out.println("3. Provide Course Details");
            System.out.println("4. Enroll Student to Course");
            System.out.println("5. Assign Teacher to Course");
            System.out.println("6. Display Students in a Course");
            System.out.println("7. Display Courses by Teacher");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();             // user input as integer
            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                case 3:
                    courseMenu();
                    break;
                case 4:
                    enrollStudentToCourse();
                    break;
                case 5:
                    assignTeacherToCourse();
                    break;
                case 6:
                    displayStudentsInCourse();
                    break;
                case 7:
                    displayCoursesByTeacher();
                    break;
                case 8:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }

    void studentMenu() {
        System.out.println("1. Add 2. Update 3. Delete 4. View All");
        int choice = nextInt();
        switch (choice) {
            case 1:
                System.out.println("Name: ");
                String name = scanner.nextLine();        // user input name as string
                System.out.println("Age: ");
                int age = nextInt();
                System.out.println("Grade: ");
                String grade = scanner.nextLine();
                students.add(new Student(studentId++, name, age, grade));
                System.out.println("Student added.");
                break;
            case 2:
                System.out.print("Enter Student ID to update: ");
                int updateId = nextInt();
                Student updateStudent = findStudent(updateId);
                if (updateStudent != null) {
                    System.out.print("Name: ");
                    updateStudent.setName(scanner.nextLine());
                    System.out.print("Age: ");
                    updateStudent.setAge(nextInt());
                    System.out.print("Grade: ");
                    updateStudent.setGrade(scanner.nextLine());
                    System.out.println("Student updated.");
                }
                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 3:
                System.out.print("Enter Student ID to delete: ");
                int deleteId = nextInt();
                Student deleteStudent = findStudent(deleteId);
                if (deleteStudent != null && students.remove(deleteStudent))
                {
                    System.out.println("Deleted.");
                }
                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 4:
                for (Student s : students)
                {
                    System.out.println(s);
                }
                break;
        }
    }

    void teacherMenu() {
        System.out.println("1. Add 2. Update 3. Delete 4. View All");
        int choice = nextInt();
        switch (choice) {
            case 1:
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                teachers.add(new Teacher(teacherId++, name, subject));
                System.out.println("Teacher added.");
                break;
            case 2:
                System.out.print("Enter Teacher ID to update: ");
                int uid = nextInt();
                Teacher ut = findTeacher(uid);
                if (ut != null) {
                    System.out.print("Name: ");
                    ut.setName(scanner.nextLine());
                    System.out.print("Subject: ");
                    ut.setSubject(scanner.nextLine());
                    System.out.println("Teacher updated.");
                }
                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 3:
                System.out.print("Enter Teacher ID to delete: ");
                int deleteId = nextInt();
                Teacher deleteTeacher = findTeacher(deleteId);
                if (deleteTeacher != null && teachers.remove(deleteTeacher))
                {
                    System.out.println("Deleted.");
                }

                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 4:
                for (Teacher t : teachers)
                {
                    System.out.println(t);
                }
                break;
        }
    }

    void courseMenu() {
        System.out.println("1. Add 2. Update 3. Delete 4. View All");
        int choice = nextInt();
        switch (choice)
        {
            case 1:
                System.out.print("Name: ");
                String name = scanner.nextLine();
                courses.add(new Course(courseId++, name));
                System.out.println("Course added.");
                break;
            case 2:
                System.out.print("Enter Course ID to update: ");
                int updateId = nextInt();
                Course updateCourse = findCourse(updateId);
                if (updateCourse != null) {
                    System.out.print("Name: ");
                    updateCourse.setName(scanner.nextLine());
                    System.out.println("Course updated.");
                }
                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 3:
                System.out.print("Enter Course ID to delete: ");
                int deleteId = nextInt();
                Course deleteCourse = findCourse(deleteId);
                if (deleteCourse != null && courses.remove(deleteCourse))
                {
                    System.out.println("Deleted.");
                }
                else
                {
                    System.out.println("Not found.");
                }
                break;
            case 4:
                for (Course c : courses)
                {
                    System.out.println(c);
                }
                break;
        }
    }

    void enrollStudentToCourse() {
        System.out.print("Enter Student ID: ");
        int studentId = nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = nextInt();
        Student s = findStudent(studentId);
        Course c = findCourse(courseId);
        if (s != null && c != null) {
            c.enrollStudent(s);
            System.out.println("Enrolled.");
        }
        else
        {
            System.out.println("Student or Course not found.");
        }
    }

    void assignTeacherToCourse() {
        System.out.print("Enter Teacher ID: ");
        int teacherId = nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = nextInt();
        Teacher t = findTeacher(teacherId);
        Course c = findCourse(courseId);
        if (t != null && c != null) {
            c.assignTeacher(t);
            System.out.println("Assigned.");
        }
        else
        {
            System.out.println("Teacher or Course not found.");
        }
    }

    void displayStudentsInCourse() {
        System.out.print("Enter Course ID: ");
        int courseId = nextInt();
        Course c = findCourse(courseId);
        if (c != null && !c.getEnrolledStudents().isEmpty())
        {
            for (Student s : c.getEnrolledStudents())  // retrieve student enrolled in course by for-each loop
            {
                System.out.println(s);
            }
        }
        else
        {
            System.out.println("No students enrolled or course not found.");
        }
    }

    void displayCoursesByTeacher() {
        System.out.print("Enter Teacher ID: ");
        int teacherId = nextInt();
        boolean found = false;
        for (Course c : courses)
        {
            if (c.getAssignedTeacher() != null && c.getAssignedTeacher().getId() == teacherId)
            {
                System.out.println(c);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No courses assigned to this teacher.");
        }
    }

    int nextInt() {
        while (true) {
            try {
                int v = Integer.parseInt(scanner.nextLine().trim());
                return v;
            } catch (Exception e) {
                System.out.print("Invalid. Enter again: ");
            }
        }
    }

    Student findStudent(int id) {
        for (Student s : students)
        {
            if (s.getId() == id)
            {
                return s;
            }
        }
        return null;
    }

    Teacher findTeacher(int id) {
        for (Teacher t : teachers)
        {
            if (t.getId() == id)
            {
                return t;
            }
        }
        return null;
    }

    Course findCourse(int id) {
        for (Course c : courses)
        {
            if (c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }
}

