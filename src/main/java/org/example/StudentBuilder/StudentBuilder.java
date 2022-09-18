package org.example.StudentBuilder;

import org.example.Student;

/**
 * @author oleg on 18.09.2022
 */
public interface StudentBuilder {
  public StudentBuilder setName(String name);
  public StudentBuilder setGroup(int group);
  public StudentBuilder setCourse(int course);
  public Student build();
}
