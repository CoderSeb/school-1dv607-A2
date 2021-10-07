package model.persistence;

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
   */
  public ArrayList<Member> loadData();
  // public void saveData();
}
