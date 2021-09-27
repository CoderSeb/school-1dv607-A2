package model;

import java.util.ArrayList;

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
  }

  /**
   * Gets members.
   *
   * @return the members
   */
  public ArrayList<Member> getMembers() {
    return members;
  }

  /**
   * Sets members.
   *
   * @param members the members
   */
  public void setMembers(ArrayList<Member> members) {
    this.members = members;
  }

  /**
   * Add member.
   *
   * @param newMember the new member
   */
  public void addMember(Member newMember) {
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
   * Gets all member ids.
   *
   * @return the all member ids
   */
  public ArrayList<String> getAllMemberIds() {
    ArrayList<String> result = new ArrayList<String>();
    for (Member member : members) {
      result.add(member.getMemberId());
    }
    return result;
  }

  /**
   * Find by id member.
   *
   * @param id the id
   * @return the member
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
   * Find by personal nr member.
   *
   * @param personalNr the personal nr
   * @return the member
   */
  public Member findByPersonalNr(Long personalNr) {
    for (Member member : this.members) {
      if (member.getPersonalNr().equals(personalNr)) {
        return member;
      }
    }
    return null;
  }
}
