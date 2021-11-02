package model.persistence;

import error.InvalidInputException;
import java.util.ArrayList;
import model.Member;

/**
 * The interface Persistence.
 */
public interface Persistence {

  /**
   * Load data and return loaded members in an ArrayList.
   *
   * @return the array list with loaded members.
   * @throws InvalidInputException the invalid input exception.
   */
  public ArrayList<Member> loadData();
  // public void saveData();
}
