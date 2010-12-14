package pl.project.ca;

public class Ant {

  int x;
  int y;
  private Point[][] field;

  AntMovementDirection direction = AntMovementDirection.UP;

  public Ant(int x, int y, Point[][] field) {
    this.x = x;
    this.y = y;
    this.field = field;
  }

  public void move(){
    if(antPosition().isBlack()){
      direction.
    }
  }

  private Point antPosition() {
    return field[x][y];
  }
}
