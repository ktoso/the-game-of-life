package pl.project.ca;

/**
* Created by IntelliJ IDEA.
* User: ktoso
* Date: 12/14/10
* Time: 1:44 PM
* To change this template use File | Settings | File Templates.
*/
enum AntMovementDirection {
  UP {
    @Override
    AntMovementDirection turnRight() {
      return RIGHT;
    }

    @Override
    AntMovementDirection turnLeft() {
      return LEFT;
    }

    @Override
    int moveX() {
      return 0;
    }

    @Override
    int moveY() {
      return +1;
    }
  },
  RIGHT {
    @Override
    AntMovementDirection turnRight() {
      return DOWN;
    }

    @Override
    AntMovementDirection turnLeft() {
      return UP;
    }

    @Override
    int moveX() {
      return +1;
    }

    @Override
    int moveY() {
      return 0;
    }
  },
  DOWN {
    @Override
    AntMovementDirection turnRight() {
      return LEFT;
    }

    @Override
    AntMovementDirection turnLeft() {
      return RIGHT;
    }

    @Override
    int moveX() {
      return 0;
    }

    @Override
    int moveY() {
      return -1;
    }
  },
  LEFT {
    @Override
    AntMovementDirection turnRight() {
      return UP;
    }

    @Override
    AntMovementDirection turnLeft() {
      return DOWN;
    }

    @Override
    int moveX() {
      return -1;
    }

    @Override
    int moveY() {
      return 0;
    }
  };

  abstract AntMovementDirection turnRight();
  abstract AntMovementDirection turnLeft();
  abstract int moveX();
  abstract int moveY();
}
