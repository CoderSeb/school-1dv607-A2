package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import model.persistence.MockData;

/**
 * The type Register.
 */
public class Register {
  private ArrayList<Member> members;

  /**
   * Instantiates a new Register.
   */
  public Register() {
    this.members = new ArrayList<Member>();
    new MockData().loadData(this);
  }

  /**
   * Returns unmodifiable list of all members.
   *
   * @return the members as an unmodifiable list.
   */
  public List<Member> getMembers() {
    List<Member> readOnlyMembers = Collections.unmodifiableList(members);
    return readOnlyMembers;
  }

  public void createAndAddMember(String firstName, String lastName, PersonalNumber personalNumber) {
    this.members.add(new Member(firstName, lastName, personalNumber, generateUniqueId()));
  }

  /**
   * Add member.
   *
   * @param newMember the new member
   */
  public void addMember(Member newMember) {
    if (!isUnique(newMember.getMemberId())) {
      throw new IllegalArgumentException("Member id is not unique!");
    }
    this.members.add(newMember);
  }

  /**
   * Remove member.
   *
   * @param member the member
   */
  public void removeMember(Member member) {
    this.members.remove(member);
  }


  /**
   * Find member by id member.
   *
   * @param id the id as a String.
   * @return the member found.
   */
  public Member findById(String id) {
    for (Member member : this.members) {
      if (member.getMemberId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  /**
   * Find member by personal number.
   *
   * @param personalNr the personal nr as a String.
   * @return the found member.
   */
  public Member findByPersonalNr(PersonalNumber personalNr) {
    for (Member member : this.members) {
      if (member.getPersonalNr().equals(personalNr.getPersonalNumber())) {
        return member;
      }
    }
    return null;
  }

  /**
   * Generate unique id string.
   *
   * @return the string
   */
  private String generateUniqueId() {
    String newId;
    do {
      newId = generateId();
    } while (!isUnique(newId));
    return newId;
  }

  /**
   * Generates a random id string.
   *
   * @return the String.
   */
  private String generateId() {
    Random random = new Random();
    int maxLength = 6;
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuffer result = new StringBuffer();

    for (int i = 0; i < maxLength / 2; i++) {
      char randChar = alphabet.charAt(random.nextInt(alphabet.length()));
      result.append(randChar);
      result.append(random.nextInt(10));
    }
    return result.toString();
  }

  /**
   * Returns true if no member with the same id as the input is found.
   *
   * @param newId as a String.
   * @return the Boolean.
   */
  private Boolean isUnique(String newId) {
    for (Member member : members) {
      if (member.getMemberId().equals(newId)) {
        return false;
      }
    }
    return true;
  }
}
