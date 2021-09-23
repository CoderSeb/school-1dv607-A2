package model;

import java.util.ArrayList;

public class Register {
  private ArrayList<Member> members;

  public Register() {
    this.members = new ArrayList<Member>();
  }

  public ArrayList<Member> getMembers() {
    return members;
  }

  public void setMembers(ArrayList<Member> members) {
    this.members = members;
  }

  public void addMember(Member newMember) {
    this.members.add(newMember);
  }

  public void removeMember(Member member) {
    this.members.remove(member);
  }

  public ArrayList<String> getAllMemberIds() {
    ArrayList<String> result = new ArrayList<String>();
    for (Member member : members) {
      result.add(member.getMemberId());
    }
    return result;
  }

  public Member findById(String id) {
    for (Member member : this.members) {
      if (member.getMemberId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  public Member findByPersonalNr(Long personalNr) {
    for (Member member : this.members) {
      if (member.getPersonalNr().equals(personalNr)) {
        return member;
      }
    }
    return null;
  }
}
