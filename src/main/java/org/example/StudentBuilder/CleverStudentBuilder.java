package org.example.StudentBuilder;

import org.example.SimpleCustomDataProvider;
import org.example.Student;

import java.util.HashMap;

/**
 * @author oleg on 18.09.2022
 */
public class CleverStudentBuilder implements StudentBuilder {
  SimpleCustomDataProvider dataProvider = new SimpleCustomDataProvider();
  private String name;
  private int group;
  private int course;

  @Override
  public StudentBuilder setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public StudentBuilder setGroup(int group) {
    this.group = group;
    return this;
  }

  @Override
  public StudentBuilder setCourse(int course) {
    this.course = course;
    return this;
  }


  @Override
  public Student build() {
    HashMap<String,Integer> allRanks = new HashMap<>();
    for (int i = 0; i < dataProvider.getSUBJECTS().length; i++) {
      allRanks.put(dataProvider.getSUBJECTS()[i], dataProvider.getCleverRanks()[i]);
    }
    Student cleverStudent = new Student(name, group, course, allRanks);
    cleverStudent.getStudentInfo(dataProvider.setFullInfo());
    return cleverStudent;
  }
}
