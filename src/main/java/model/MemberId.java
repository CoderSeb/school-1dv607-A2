package model;

import java.util.ArrayList;
import java.util.Random;

public class MemberId {
  private String id;

  public MemberId(ArrayList<String> membersId) {
    this.id = generateUniqueId(membersId);
  }

  public String getId() {
    return id;
  }

  private String generateUniqueId(ArrayList<String> membersId) {
    String newId;
    do {
      newId = generateId();
    } while (!isUnique(newId, membersId));
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

  private Boolean isUnique(String newId, ArrayList<String> membersId) {
    for (String memberId : membersId) {
      if (memberId.equals(newId)) return false;
    }
    return true;
  }
}
