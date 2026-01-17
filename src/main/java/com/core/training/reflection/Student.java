package com.core.training.reflection;

/**
 * @Author huangyulu
 * @Date 2026/1/17 13:40
 * @Description
 */
public class Student extends User {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student() {

    }

    public Student(String school) {
        this.school = school;
    }


    public int getScore(String type) {
        if (type == null) {
            return 0;
        } else if (type.equalsIgnoreCase("student")) {
            return 1;
        } else {
            return 99;
        }
    }

    private int getGrade(int year) {
        return 1;
    }

    private void countScore() {
        System.out.println("Student.countScore() invoked!");
    }

    public static String getSchoolNetWork() {
        return "xxx.school.com";
    }

    public void hello() {
        System.out.println("Student:hello");
    }
}
