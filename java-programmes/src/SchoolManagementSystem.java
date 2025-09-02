 import java.util.*;
 import java.util.List;

 class Student
    {
        private int id;
        private String name;
        private int age;
        private String grade;

        public Student(int id, String name, int age, String grade)
        {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
        public int getId()
        {
            return id;
        }
        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }
        public String getGrade()
        {
            return grade;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public void setAge(int age)
        {
            this.age = age;
        }
        public void setGrade(String grade)
        {
            this.grade = grade;
        }

        @Override
        public String toString()
        {
            return ("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
        }
    }
class Teacher
{
    private int id;
    private String name;
    private String subject;
    public Teacher(int id, String name,String subject)
    {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSubject()
    {
        return subject;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    public String toString()
     {
       return ("ID :" +id +"Name :"+ name +"Subject :"+subject);
     }
}

class Course
{
    private int id;
    private String  name;
    private Teacher assignedTeacher;
    List <Student> enrolledStudents = new ArrayList<>();
    public Course(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }
    public List<Student>getEnrolledStudents()
    {
        return enrolledStudents;
    }

    public void setName(String s)
    {
        this.name = name;
    }

    public void assignedTeacher(Teacher teacher)
    {
        this.assignedTeacher = teacher;
    }
    public void enrolledStudents(Student student)
    {
        this.enrolledStudents.add(student);
    }
    public String toString()
    {
        String teacherStr = (assignedTeacher == null) ? "None" : assignedTeacher.getName();
        return "ID: " + id + ", Name: " + name + ", Teacher: " + teacherStr + ", Enrolled: " + enrolledStudents.size();
    }

    public void enrollStudent(Student s) {
    }

    public void assignTeacher(Teacher t) {
    }
}
 public class SchoolManagementSystem {
     private List<Student> students = new ArrayList<>();
     private List<Teacher> teachers = new ArrayList<>();
     private List<Course> courses = new ArrayList<>();
     private Scanner scanner = new Scanner(System.in);
     private int studentId = 1, teacherId = 1, courseId = 1;

     public static void main(String[] args) {
         new SchoolManagementSystem().runMenu();
     }

     void runMenu() {
         while (true) {
             System.out.println("\nSchool Management System");
             System.out.println("1. Manage Students");
             System.out.println("2. Manage Teachers");
             System.out.println("3. Manage Courses");
             System.out.println("4. Enroll Student to Course");
             System.out.println("5. Assign Teacher to Course");
             System.out.println("6. Display Students in a Course");
             System.out.println("7. Display Courses by Teacher");
             System.out.println("8. Exit");
             System.out.print("Enter choice: ");
             int choice = nextInt();
             switch (choice) {
                 case 1: studentMenu(); break;
                 case 2: teacherMenu(); break;
                 case 3: courseMenu(); break;
                 case 4: enrollStudentToCourse(); break;
                 case 5: assignTeacherToCourse(); break;
                 case 6: displayStudentsInCourse(); break;
                 case 7: displayCoursesByTeacher(); break;
                 case 8: System.out.println("Exiting."); return;
                 default: System.out.println("Invalid!");
             }
         }
     }

     void studentMenu() {
         System.out.println("1. Add 2. Update 3. Delete 4. View All");
         int choice = nextInt();
         switch (choice) {
             case 1:
                 System.out.print("Name: "); String name = scanner.nextLine();
                 System.out.print("Age: "); int age = nextInt();
                 System.out.print("Grade: "); String grade = scanner.nextLine();
                 students.add(new Student(studentId++, name, age, grade));
                 System.out.println("Student added.");
                 break;
             case 2:
                 System.out.print("Enter Student ID to update: ");
                 int uid = nextInt();
                 Student us = findStudent(uid);
                 if (us != null) {
                     System.out.print("Name: "); us.setName(scanner.nextLine());
                     System.out.print("Age: "); us.setAge(nextInt());
                     System.out.print("Grade: "); us.setGrade(scanner.nextLine());
                     System.out.println("Student updated.");
                 } else System.out.println("Not found.");
                 break;
             case 3:
                 System.out.print("Enter Student ID to delete: ");
                 int did = nextInt();
                 Student ds = findStudent(did);
                 if (ds != null && students.remove(ds)) System.out.println("Deleted.");
                 else System.out.println("Not found.");
                 break;
             case 4:
                 for (Student s : students) System.out.println(s);
                 break;
         }
     }

     void teacherMenu() {
         System.out.println("1. Add 2. Update 3. Delete 4. View All");
         int choice = nextInt();
         switch (choice) {
             case 1:
                 System.out.print("Name: "); String name = scanner.nextLine();
                 System.out.print("Subject: "); String subject = scanner.nextLine();
                 teachers.add(new Teacher(teacherId++, name, subject));
                 System.out.println("Teacher added.");
                 break;
             case 2:
                 System.out.print("Enter Teacher ID to update: ");
                 int uid = nextInt();
                 Teacher ut = findTeacher(uid);
                 if (ut != null) {
                     System.out.print("Name: "); ut.setName(scanner.nextLine());
                     System.out.print("Subject: "); ut.setSubject(scanner.nextLine());
                     System.out.println("Teacher updated.");
                 } else System.out.println("Not found.");
                 break;
             case 3:
                 System.out.print("Enter Teacher ID to delete: ");
                 int did = nextInt();
                 Teacher dt = findTeacher(did);
                 if (dt != null && teachers.remove(dt)) System.out.println("Deleted.");
                 else System.out.println("Not found.");
                 break;
             case 4:
                 for (Teacher t : teachers) System.out.println(t);
                 break;
         }
     }

     void courseMenu() {
         System.out.println("1. Add 2. Update 3. Delete 4. View All");
         int choice = nextInt();
         switch (choice) {
             case 1:
                 System.out.print("Name: "); String name = scanner.nextLine();
                 courses.add(new Course(courseId++, name));
                 System.out.println("Course added.");
                 break;
             case 2:
                 System.out.print("Enter Course ID to update: ");
                 int uid = nextInt();
                 Course uc = findCourse(uid);
                 if (uc != null) {
                     System.out.print("Name: "); 
                     uc.setName(scanner.nextLine());
                     System.out.println("Course updated.");
                 } else System.out.println("Not found.");
                 break;
             case 3:
                 System.out.print("Enter Course ID to delete: ");
                 int did = nextInt();
                 Course dc = findCourse(did);
                 if (dc != null && courses.remove(dc)) System.out.println("Deleted.");
                 else System.out.println("Not found.");
                 break;
             case 4:
                 for (Course c : courses) System.out.println(c);
                 break;
         }
     }

     void enrollStudentToCourse() {
         System.out.print("Enter Student ID: "); int sid = nextInt();
         System.out.print("Enter Course ID: "); int cid = nextInt();
         Student s = findStudent(sid); Course c = findCourse(cid);
         if (s != null && c != null) 
         {
             c.enrollStudent(s); System.out.println("Enrolled."); }
         else System.out.println("Student or Course not found.");
     }

     void assignTeacherToCourse() {
         System.out.print("Enter Teacher ID: "); int tid = nextInt();
         System.out.print("Enter Course ID: "); int cid = nextInt();
         Teacher t = findTeacher(tid); Course c = findCourse(cid);
         if (t != null && c != null) 
         {
             c.assignTeacher(t); System.out.println("Assigned."); }
         else System.out.println("Teacher or Course not found.");
     }

     void displayStudentsInCourse() {
         System.out.print("Enter Course ID: "); int cid = nextInt();
         Course c = findCourse(cid);
         if (c != null && !c.getEnrolledStudents().isEmpty())
             for (Student s : c.getEnrolledStudents()) System.out.println(s);
         else System.out.println("No students enrolled or course not found.");
     }

     void displayCoursesByTeacher() {
         System.out.print("Enter Teacher ID: "); int tid = nextInt();
         boolean found = false;
         for (Course c : courses) {
             if (c.getAssignedTeacher() != null && c.getAssignedTeacher().getId() == tid) {
                 System.out.println(c);
                 found = true;
             }
         }
         if (!found) System.out.println("No courses assigned to this teacher.");
     }

     int nextInt() {
         while (true) {
             try { int v = Integer.parseInt(scanner.nextLine().trim()); return v; }
             catch (Exception e) { System.out.print("Invalid. Enter again: "); }
         }
     }

     Student findStudent(int id) { for (Student s : students) if (s.getId() == id) return s; return null; }
     Teacher findTeacher(int id) { for (Teacher t : teachers) if (t.getId() == id) return t; return null; }
     Course findCourse(int id) { for (Course c : courses) if (c.getId() == id) return c; return null; }
 }
