package pl.project.ca;

import java.util.ArrayList;

public class Point {
  private ArrayList<Point> neighbors;
  private int              currentState;
  private int              nextState;
  private int numStates = 2;

  private final int ALIVE = 1;
  private final int DEAD  = 0;

  private final int MIN_STAY_FRIENDS = 2;
  private final int MAX_STAY_FRIENDS = 5;

  private final int MIN_BIRTH_FRIENDS = 4;
  private final int MAX_BIRTH_FRIENDS = 8;

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
    //wersja z miastem otoczonym murem
    if (getState() == ALIVE) {
      nextState = shouldStayAlive() ? ALIVE : DEAD;
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

  private boolean shouldStayAlive() {
    int aliveFriends = countAliveFriends();

    boolean shouldLive = aliveFriends >= MIN_STAY_FRIENDS && aliveFriends <= MAX_STAY_FRIENDS;
    System.out.println("alive friends: " + aliveFriends + "; " + (shouldLive ? "living" : "dying"));

    return shouldLive;
  }

  private boolean shouldThisBeBorn() {
    int aliveFriends = countAliveFriends();
    boolean shouldBeBorn = aliveFriends  >= MIN_BIRTH_FRIENDS && aliveFriends <= MAX_BIRTH_FRIENDS;
    System.out.println("alive friends: " + aliveFriends + "; " + (shouldBeBorn ? "starting" : "still dead"));

    return shouldBeBorn;
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
