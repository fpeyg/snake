package snake;

import java.util.Arrays;

public class Snake {

    private int[] pos = new int[2];
    private int[] speed = new int[2];
    private String color;
    private boolean alive = true; // au départ le serpent est vivant
    private int size;

    public Snake() {
    }

    public Snake(int[] pos, int[] speed, String color) {
        this.pos = pos;
        this.speed = speed;
        this.color = color;
        this.size = 1;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void killSnake() {
        this.alive = false;
    }

    public int[] getNextPosition() {
        int[] nextPos = new int[2];
        nextPos[0] = this.pos[0] + this.speed[0];
        nextPos[1] = this.pos[1] + this.speed[1];
        return nextPos;
    }

//    speed est un vecteur dont les composants sont: soit 0, soit 1
    public void turnRight() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = 1;
            this.speed[1] = 0; // {1, 0} V
        }
        else if (this.speed[0] == 1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = -1; // {0, -1} <-
        }
        else if (this.speed[0] == 0 && this.speed[1] == -1) {
            this.speed[0] = -1;
            this.speed[1] = 0; // {-1, 0} ô
        }
        else if (this.speed[0] == -1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = 1; // {0, 1}  ->
        }
    }

    public void turnLeft() {
        if (this.speed[0] == 0 && this.speed[1] == 1) {
            this.speed[0] = -1;
            this.speed[1] = 0; // {-1, 0}   ô
        }
        else if (this.speed[0] == -1 && this.speed[1] ==  0) {
            this.speed[0] = 0;
            this.speed[1] = -1; // {0, -1} <-
        }
        else if (this.speed[0] == 0 && this.speed[1] ==  -1) {
            this.speed[0] = 1;
            this.speed[1] = 0; // {1, 0} V
        }
        else if (this.speed[0] == 1 && this.speed[1] == 0) {
            this.speed[0] = 0;
            this.speed[1] = 1; // {1, 0} ->
        }
    }

    public int[] getPos() {
        return pos;
    }

    public int getSize() {
        return size;
    }

    public void moveOn(Grid grid) {
//        préparation nouvelle position
        int[] nextp = getNextPosition();
        int y = nextp[0];
        int x = nextp[1];

//        sortie de grille
        if (!grid.pointInsideGrid(y, x)){
//            lignes
            if (y == -1) {
                y = grid.getNRows() - 1;
            }
            else {
                y = y % grid.getNRows();
            }
//            colonnes
            if (x == -1) {
                x = grid.getNCols() - 1;
            }
            else {
                x = x % grid.getNCols();
            }
        }
        this.pos[0] = y;
        this.pos[1] = x;

//        prochaine position objet "#" ou "*"
        if ((grid.getCell(this.pos[0], this.pos[1]).compareTo("#") == 0)
            || (grid.getCell(this.pos[0], this.pos[1]).compareTo("*") == 0)) {
            killSnake();
            System.out.println("est tué");
        }
        else {
//          si objet "o" on augmente la taille du serpent
            if ((grid.getCell(this.pos[0], this.pos[1]).compareTo("o")) == 0) {
                this.size += 1;
            }
        }
    }


    @Override
    public String toString() {
        return "Snake{" +
                "pos=" + Arrays.toString(pos) +
                ", speed=" + Arrays.toString(speed) +
                ", color='" + color + '\'' +
                ", alive=" + alive +
                ", size=" + size +
                '}';
    }


}