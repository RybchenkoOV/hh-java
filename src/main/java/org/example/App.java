package org.example;

import org.example.StudentBuilder.CleverStudentBuilder;
import org.example.StudentBuilder.IntermediateStudentBuilder;
import org.example.StudentBuilder.StudentType;
import org.example.StudentBuilder.StupidStudentBuilder;
import org.example.StudentsFactory.StudentA;
import org.example.StudentsFactory.StudentFactory;

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
  public static final String[] SUBJECTS = {"Russian", "Geography", "Math", "Geometry", "History", "Politics"};
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
    System.out.println("----------------------------------------------");
    checkAndDeleteLowerThanIntermediateStudents(students).stream().forEach(e -> e.getStudentInfo(SHORT_INFO));
    System.out.println("----------------------------------------------");
    System.out.println("Select course: ");
    System.out.println("----------------------------------------------");
    int courseSelect = scanner.nextInt();
    System.out.println("Students from " + courseSelect + " course: ");
    printStudents(students, courseSelect);
    System.out.println("----------------------------------------------");
    System.out.println("Creating Students Via Builder Pattern");
    System.out.println("----------------------------------------------");
    createStudentsViaBuilderPattern();
    System.out.println("----------------------------------------------");
    System.out.println("Creating Students Via Factory Pattern");
    System.out.println("----------------------------------------------");
    createStudentViaFactory(StudentType.STUPID_STUDENT);
    createStudentViaFactory(StudentType.INTERMEDIATE_STUDENT);
    createStudentViaFactory(StudentType.CLEVER_STUDENT);
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
      for (String subject : SUBJECTS) {
        mapSubjectAndRank.put(subject, randomIntGenerator());
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

  private static void createStudentsViaBuilderPattern() {
    StupidStudentBuilder stupidStudent = new StupidStudentBuilder();
    IntermediateStudentBuilder intermediateStudent = new IntermediateStudentBuilder();
    CleverStudentBuilder cleverStudent = new CleverStudentBuilder();

    stupidStudent
        .setName("Stupid")
        .setGroup(13)
        .setCourse(13)
        .build();

    intermediateStudent
        .setName("Intermediate")
        .setGroup(12)
        .setCourse(12)
        .build();

    cleverStudent
        .setName("Clever")
        .setGroup(7)
        .setCourse(7)
        .build();
  }

  private static void createStudentViaFactory(StudentType type) {
    SimpleCustomDataProvider dataProvider = new SimpleCustomDataProvider();
    switch (type) {
      case STUPID_STUDENT -> {
        StudentFactory studentA = new StudentA();
        studentA.setName("STUPID_FACTORY");
        studentA.setGroup(111);
        studentA.setCourse(111);
        studentA.setRanks(dataProvider.getRanksByStudentType(StudentType.STUPID_STUDENT));
        studentA.printStudentInfo();
      }
      case INTERMEDIATE_STUDENT -> {
        StudentFactory studentB = new StudentA();
        studentB.setName("INTERMEDIATE_FACTORY");
        studentB.setGroup(222);
        studentB.setCourse(222);
        studentB.setRanks(dataProvider.getRanksByStudentType(StudentType.INTERMEDIATE_STUDENT));
        studentB.printStudentInfo();
      }
      case CLEVER_STUDENT -> {
        StudentFactory studentC = new StudentA();
        studentC.setName("CLEVER_FACTORY");
        studentC.setGroup(333);
        studentC.setCourse(333);
        studentC.setRanks(dataProvider.getRanksByStudentType(StudentType.CLEVER_STUDENT));
        studentC.printStudentInfo();
      }
    }
  }
}
