package pl.project.ca;

import java.util.ArrayList;

public class Point {
  private ArrayList<Point> neighbors;
  private int              currentState;
  private int              nextState;
  private int numStates = 2;

  private final int ALIVE = 1;
  private final int DEAD  = 0;

  private final int MIN_FRIENDS = 2;
  private final int MAX_FRIENDS = 3;

  public Point() {
    currentState = 0;
    nextState = 0;
    neighbors = new ArrayList<Point>();
  }

  public void clicked() {
    currentState = (++currentState) % numStates;
  }

  public int getState() {
    return currentState;
  }

  public void setState(int s) {
    currentState = s;
  }

  public void calculateNewState() {
    //TODO: insert logic which updates according to currentState and number of active neighbors
    if (getState() == ALIVE) {
      nextState = shouldThisDie() ? DEAD : ALIVE;
    } else {//(getState() == DEAD){
      nextState = shouldThisBeBorn() ? ALIVE : DEAD;
    }
  }

  public void changeState() {
    currentState = nextState;
  }

  public void addNeighbor(Point nei) {
    neighbors.add(nei);
  }

  //TODO: write method counting all active neighbors of THIS point
  private boolean shouldThisDie() {
    int aliveFriends = countAliveFriends();

    boolean shouldDie = aliveFriends > MAX_FRIENDS || aliveFriends < MIN_FRIENDS;
    System.out.println("alive friends: " + aliveFriends + "; " + (shouldDie ? "dying" : "living"));

    return shouldDie;
  }

  private boolean shouldThisBeBorn() {
    int aliveFriends = countAliveFriends();
    boolean shouldStart = aliveFriends == MAX_FRIENDS;
    System.out.println("alive friends: " + aliveFriends + "; " + (shouldStart ? "starting" : "still dead"));

    return shouldStart;
  }

  private int countAliveFriends() {
    int aliveFriends = 0;

    System.out.print("friends: " + neighbors.size() + "; ");
    for (Point neighbor : neighbors) {
      if (neighbor.getState() == 1) {
        ++aliveFriends;
      }
    }
    return aliveFriends;
  }
}
