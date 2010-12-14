package pl.project.ca;

import java.util.ArrayList;

public class Point {
  private ArrayList<Point> neighbors;
  private int currentState;
  private int nextState;
  private int numStates = 4;

  private final int WHITE = 0;
  private final int BLACK = 1;

  // ant stuff


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

//  public void calculateNewState() {
//    //TODO: insert logic which updates according to currentState and number of active neighbors
//    if (getState() == BLACK) {
//
//    }
//  }

  public void changeState() {
    currentState = nextState;
  }

  public void addNeighbor(Point nei) {
    neighbors.add(nei);
  }

  //TODO: write method checking ants next movement
  private boolean isWhite() {
    return this.currentState == WHITE;
  }

  public boolean isBlack() {
    return this.currentState == BLACK;
  }
}
