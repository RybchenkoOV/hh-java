package org.example;

import java.util.HashMap;

/**
 * @author oleg on 18.09.2022
 */
public class Student {
  private String name;
  private int group;

  public String getName() {
    return name;
  }

  public int getGroup() {
    return group;
  }

  public int getCourse() {
    return course;
  }

  private int course;

  public HashMap<String, Integer> getSubjectRanks() {
    return subjectRanks;
  }

  private HashMap<String, Integer> subjectRanks;

  public Student(String name, int group, int course, HashMap<String, Integer> subjectRanks) {
    this.name = name;
    this.group = group;
    this.course = course;
    this.subjectRanks = subjectRanks;
  }

  public void setCourse(int course) {
    this.course = course;
  }

  public double getAverageRank() {
    var avgRank = subjectRanks.values().stream().mapToInt(e -> e).average().getAsDouble();
    return avgRank;
  }

  public void getStudentInfo(String option) {
    switch (option) {
      case "full" -> {
        System.out.println("Students name: " + name);
        System.out.println("Students group: " + group);
        System.out.println("Students course: " + course);
        System.out.println("Students ranks: " + subjectRanks.toString());
        System.out.println("Average ranks: " + getAverageRank());
      }
      case "short" -> {
        System.out.println("Students name: " + name);
        System.out.println("Students course: " + course);
        System.out.println("Average ranks: " + getAverageRank());
      }
    }
  }
}
