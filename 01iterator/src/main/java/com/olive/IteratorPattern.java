package com.olive;

public class IteratorPattern {
    public static void main(String[] args) {
        Student s1 = new Student("晓明");
        Student s2 = new Student("晓明");
        Classroom classroom = new Classroom(2);
        classroom.addStudent(s1);
        classroom.addStudent(s2);

        Iterator iterator = classroom.iterator();
        while(iterator.hasNext()) {
            Student next = (Student) iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 定义一个自己的迭代器接口
     */
    public interface Iterator {
        public abstract boolean hasNext();
        public abstract Object next();
    }

    /**
     * 代表了一个集合类
     */
    public interface  Aggregate {
        public abstract Iterator iterator();
    }

    public static class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class ClassroomIterator implements Iterator {

        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        /**
         * 假设此时index是0 classroom的length是2
         * 那么肯定是可以去获取下一个学生的，此时数组还没遍历完
         *
         * 假设此时index是2，classroom的length是2，classroom可以遍历的数组的offset
         * 只能是0 和 1
         * @return
         */
        @Override
        public boolean hasNext() {
            if(index < classroom.getLength()) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 数组中获取当前的这个学生，同时将index往下移动一位
         * 比如一开始index是0，然后数组长度是2
         * 此时遍历获取了第一个学生之后，返回数组0的数据，然后往后移动一位
         * @return
         */
        @Override
        public Object next() {
            Student student = classroom.getStudent(index);
            index++;
            return student;
        }

    }


    public static class Classroom implements Aggregate {

        private Student[] students;
        private int last = 0;

        public Classroom(int size) {
            this.students = new Student[size];
        }

        public Student getStudent(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }

        public int getLength() {
            return last;
        }

        @Override
        public Iterator iterator() {
            return new ClassroomIterator(this);
        }
    }


}
