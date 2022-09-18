package org.example.StudentsFactory;

import java.util.HashMap;

/**
 * @author oleg on 18.09.2022
 */
public class StudentFactory {
  private String name;
  private int group;
  private int course;
  private HashMap<String, Integer> ranks;

  public void setName(String name) {
    this.name = name;
  }

  public void setGroup(int group) {
    this.group = group;
  }

  public void setCourse(int course) {
    this.course = course;
  }

  public void setRanks(HashMap<String, Integer> ranks) {
    this.ranks = ranks;
  }

  public void printStudentInfo() {
    System.out.println("Name: " + name);
    System.out.println("Group: " + group);
    System.out.println("Course: " + course);
    System.out.println("Ranks: " + ranks.toString());
  }
}
