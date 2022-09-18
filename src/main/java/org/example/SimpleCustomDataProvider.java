package org.example;

import org.example.StudentBuilder.StudentType;

import java.util.HashMap;

/**
 * @author oleg on 18.09.2022
 */
public class SimpleCustomDataProvider {
  private static final String SHORT_INFO = "short";
  private static final String FULL_INFO = "full";
  private final String[] SUBJECTS = {"Russian", "Geography", "Math", "Geometry", "History", "Politics"};
  private final int[] stupidRanks = {2, 2, 2, 2, 2, 2};
  private final int[] cleverRanks = {5, 5, 5, 5, 5, 5};
  private final int[] intermediateRanks = {3, 3, 3, 3, 3, 3};

  public String[] getSUBJECTS() {
    return SUBJECTS;
  }

  public int[] getStupidRanks() {
    return stupidRanks;
  }

  public int[] getCleverRanks() {
    return cleverRanks;
  }

  public int[] getIntermediateRanks() {
    return intermediateRanks;
  }

  public String setFullInfo() {
    return FULL_INFO;
  }

  public String setShortInfo() {
    return SHORT_INFO;
  }

  public HashMap<String, Integer> getRanksByStudentType(StudentType type) {
    int[] rankArray = new int[getSUBJECTS().length];
    switch (type) {
      case STUPID_STUDENT -> rankArray = getStupidRanks();
      case INTERMEDIATE_STUDENT -> rankArray = getIntermediateRanks();
      case CLEVER_STUDENT -> rankArray = getCleverRanks();
    }
    HashMap<String, Integer> allRanks = new HashMap<>();
    for (int i = 0; i < getSUBJECTS().length; i++) {
      allRanks.put(getSUBJECTS()[i], rankArray[i]);
    }
    return allRanks;
  }
}
