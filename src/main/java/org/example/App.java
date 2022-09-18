package org.example;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author oleg on 18.09.2022
 */
public class App {
  private static final String[] SUBJECTS = {"Russian", "Geography", "Math", "Geometry", "History", "Politics"};
  private static final String SHORT_INFO = "short";
  private static final String FULL_INFO = "full";

  public static void main(String[] args) {
    System.out.println("!!!Chinese students info!!!");
    Scanner scanner = new Scanner(System.in);

    List<Student> students = studentGenerator(3);
    for (Student student : students) {
      student.getStudentInfo(FULL_INFO);
    }
    System.out.println("----------------------------------------------");
    System.out.println("List of students promoted to the next course: ");
    checkAndDeleteLowerThanIntermediateStudents(students).stream().forEach(e -> e.getStudentInfo(SHORT_INFO));
    System.out.println("----------------------------------------------");
    System.out.println("Select course: ");
    int courseSelect = scanner.nextInt();
    System.out.println("Students from " + courseSelect + " course: ");
    printStudents(students, courseSelect);
  }

  private static String randomStringGenerator() {
    byte[] inputRange = new byte[10];
    new Random().nextBytes(inputRange);
    String randomString = new String(inputRange, StandardCharsets.UTF_16);
    return randomString;
  }

  private static int randomIntGenerator() {
    return new Random().nextInt(5) + 1;
  }

  private static List<Student> studentGenerator(int count) {
    ArrayList<Student> students = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      HashMap<String, Integer> mapSubjectAndRank = new HashMap<>();
      for (int j = 0; j < SUBJECTS.length; j++) {
        mapSubjectAndRank.put(SUBJECTS[j], randomIntGenerator());
      }
      students.add(new Student(randomStringGenerator(),
          randomIntGenerator(),
          randomIntGenerator(),
          mapSubjectAndRank));
    }
    return students;
  }

  private static void printStudents(List<Student> students, int course) {
    List<Student> selectedStudents = students
        .stream()
        .filter(e -> e.getCourse() == course)
        .toList();
    selectedStudents.stream().forEach(e -> e.getStudentInfo(FULL_INFO));
  }

  public static List<Student> checkAndDeleteLowerThanIntermediateStudents(List<Student> students) {
    for (int i = 0; i < students.size(); i++) {
      int currentCourse = students.get(i).getCourse();
      if (students.get(i).getAverageRank() < 3) {
        students.remove(students.get(i));
      } else students.get(i).setCourse(currentCourse + 1);
    }
    return students;
  }

}
