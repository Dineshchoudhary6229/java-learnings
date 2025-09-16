package com.decipher.dinesh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Student {
    private int id;
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
}

public class StudentTest {

                                                                                // Normal Java Run
    public static void main(String[] args) {
        Student student = new Student(1, "Amit", 20, "A");
        System.out.println("Id: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Grade: " + student.getGrade());
    }

                                                                         // JUnit Tests
    @Test
    void testGetId() {
        Student student = new Student(1, "Amit", 20, "A");
        assertEquals(1, student.getId());
    }

    @Test
    void testGetName() {
        Student student = new Student(2, "Dinesh", 22, "B");
        assertEquals("Dinesh", student.getName());
    }

    @Test
    void testGetAge() {
        Student student = new Student(3, "Kumar", 25, "C");
        assertEquals(25, student.getAge());
    }

    @Test
    void testGetGrade() {
        Student student = new Student(4, "Ravi", 21, "A");
        assertEquals("A", student.getGrade());
    }
}
