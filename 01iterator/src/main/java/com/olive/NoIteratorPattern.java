package com.olive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoIteratorPattern {

    public static void main(String[] args) {
        Student s1 = new Student("晓明");
        Student s2 = new Student("晓红");

        Student[] students = new Student[2];
        students[0] = s1;
        students[1] = s2;

//        ClassRoom classRoom = new ClassRoom(students);
        ClassRoom classRoom = new ClassRoom();
        HashMap<String, Student> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("s1", s1);
        objectObjectHashMap.put("s2", s2);
        classRoom.setStudentMap(objectObjectHashMap);
        Map<String, Student> studentMap = classRoom.getStudentMap();
        for (Student student: studentMap.values()) {
            System.out.println("student = " + student);
        }

    }

    public static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

//    public static class ClassRoom {
//        private Student[] students;
//
//        public ClassRoom(Student[] students) {
//            this.students = students;
//        }
//
//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
//
//        @Override
//        public String toString() {
//            return "ClassRoom{" +
//                    "students=" + Arrays.toString(students) +
//                    '}';
//        }
//    }


    public static class ClassRoom {
        private Map<String, Student> studentMap;

        public ClassRoom() {
        }
        public ClassRoom(Map<String, Student> studentMap) {
            this.studentMap = studentMap;
        }

        public Map<String, Student> getStudentMap() {
            return studentMap;
        }

        public void setStudentMap(Map<String, Student> studentMap) {
            this.studentMap = studentMap;
        }

        @Override
        public String toString() {
            return "ClassRoot{" +
                    "studentMap=" + studentMap +
                    '}';
        }
    }
}




