package basics._3_OOP;

/*
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз, направо или налево.
Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):

Direction, направление взгляда робота,  — это перечисление.
 */

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public class MoveRobot {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int startX = robot.getX();
        int startY = robot.getY();

        if (startX < toX) {
            moveRight(robot, (toX - startX));
        } else if (startX > toX) {
            moveLeft(robot, (startX - toX));
        }

        if (startY < toY) {
            moveUp(robot, (toY - startY));
        } else if (startY > toY) {
            moveDown(robot, (startY - toY));
        }
    }

    private static void moveLeft(Robot robot, int steps) {
        switch(robot.getDirection()) {
            case LEFT:
                break;

            case RIGHT:
                robot.turnLeft();
                robot.turnLeft();
                break;

            case UP:
                robot.turnLeft();
                break;

            case DOWN:
                robot.turnRight();
                break;
        }
        for (int i = 0; i < steps; i++)
            robot.stepForward();
    }

    private static void moveRight(Robot robot, int steps) {
        switch(robot.getDirection()) {
            case LEFT:
                robot.turnRight();
                robot.turnRight();
                break;

            case RIGHT:
                break;

            case UP:
                robot.turnRight();
                break;

            case DOWN:
                robot.turnLeft();
                break;
        }
        for (int i = 0; i < steps; i++)
            robot.stepForward();
    }

    private static void moveUp(Robot robot, int steps) {
        switch(robot.getDirection()) {
            case LEFT:
                robot.turnRight();
                break;

            case RIGHT:
                robot.turnLeft();
                break;

            case UP:
                break;

            case DOWN:
                robot.turnRight();
                robot.turnRight();
                break;
        }
        for (int i = 0; i < steps; i++)
            robot.stepForward();
    }

    private static void moveDown(Robot robot, int steps) {
        switch(robot.getDirection()) {
            case LEFT:
                robot.turnLeft();
                break;

            case RIGHT:
                robot.turnRight();
                break;

            case UP:
                robot.turnRight();
                robot.turnRight();
                break;

            case DOWN:
                break;
        }
        for (int i = 0; i < steps; i++)
            robot.stepForward();
    }
}

//
class Robot {
    int x;
    int y;
    Direction dir;

    public Robot (int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {return y;}

    public void turnLeft() {
        if      (dir == Direction.UP)    {dir = Direction.LEFT;}
        else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
        else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
        else if (dir == Direction.RIGHT) {dir = Direction.UP;}
    }

    public void turnRight() {
        if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
        else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
        else if (dir == Direction.LEFT)  {dir = Direction.UP;}
        else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
    }

    public void stepForward() {
        if (dir == Direction.UP)    {y++;}
        if (dir == Direction.DOWN)  {y--;}
        if (dir == Direction.LEFT)  {x--;}
        if (dir == Direction.RIGHT) {x++;}
    }
}