package model.persistence;

import error.InvalidInputException;
import java.util.ArrayList;
import model.Member;

/**
 * The interface Persistence.
 */
public interface Persistence {

  /**
   * Load data array list.
   *
   * @return the array list
   * @throws InvalidInputException the invalid input exception
   */
  public ArrayList<Member> loadData() throws InvalidInputException;
  // public void saveData();
}
