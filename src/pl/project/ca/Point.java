package pl.project.ca;

import java.util.ArrayList;

public class Point {
  private ArrayList<Point> neighbors;
  private int currentState;
  private int nextState;

  private final int numStates = 10;
  private final int riseStates[] = {1, 2, 3, 4, 5};

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
    //fala
    nextState = nextStateByNeighbours();
  }

  public void changeState() {
    currentState = nextState;
  }

  public void addNeighbor(Point nei) {
    neighbors.add(nei);
  }

  private int nextStateByNeighbours() {
    int aliveLeftFriendHeight = countAliveFriendsWithAnyOfStates(riseStates);

    if (aliveLeftFriendHeight > 0) { // jest fala, kontunuuj
      return aliveLeftFriendHeight + 1;
    } else {// nie ma fali z lewej, malej
      return isAlive() ? currentState - 1 /*fall down*/ : 0/* stay dead*/;
    }
  }

  private boolean isAlive() {
    return currentState > 0;
  }

  private int countAliveFriendsWithAnyOfStates(int... requiredStates) {
    for (Point neighbor : neighbors) {
      for (int rqState : requiredStates) {
        if (neighbor.getState() == rqState) {
          return rqState;
        }
      }
    }

    return 0;
  }

//  private int countAliveFriendsWithAnyOfStates(int... states) {
//    int aliveFriends = 0;
//
//    System.out.print("friends: " + neighbors.size() + "; ");
//    for (Point neighbor : neighbors) {
//      for (int state : states) {
//        if (neighbor.getState() == state) {
//          ++aliveFriends;
//        }
//      }
//    }
//
//    return aliveFriends;
//  }
}
