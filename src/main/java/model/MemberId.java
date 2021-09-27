package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberId {
  private String id;
  private ArrayList<String> membersId;

  public MemberId(ArrayList<String> membersId) {
    this.membersId = membersId;
    this.id = generateUniqueId();
  }

  public String getId() {
    return id;
  }

  private String generateUniqueId() {
    String newId;
    do {
      newId = generateId();
    } while (!isUnique(newId));
    return newId;
  }

  private String generateId() {
    Random random = new Random();
    int maxLength = 6;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String result = "";

    for (int i = 0; i < maxLength / 2; i++) {
      char randChar = alphabet.charAt(random.nextInt(alphabet.length()));
      result += randChar;
      result += String.valueOf(random.nextInt(10));
    }
    return result;
  }

  private Boolean isUnique(String newId) {
    for (String memberId : membersId) {
      if (memberId.equals(newId)) {
        return false;
      }
    }
    return true;
  }
}
