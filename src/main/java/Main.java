import snake.*;

import static java.lang.Thread.*;

public class Main {

    public static void main(String[] args) {

//       création d'une Grid
        int nRows = 10;
        int nCols = 20;
        Grid gr = new Grid(nRows, nCols);

//        création d'un Snake
        int [] pos = {0, 0};
        int [] speed = {0,1};
        Snake python = new Snake(pos, speed, "red");

//      blocage sur la grille avec la méthode dropBlock
        gr.dropBlock(8,8);

//      bouffe sur la grille avec la méthode dropFood
        gr.dropFood(5,4);
        gr.dropFood(6,4);
        gr.dropFood(7,4);
        gr.dropFood(8,4);
        gr.dropFood(8,5);
        gr.dropFood(8,6);
        gr.dropFood(8,7);

        int tour = 0;
        while (python.isAlive()) {
            if ((tour == 3) || (tour == 20) || (tour == 22)
                    || (tour == 24) || (tour == 26)) {
                python.turnRight();
            }
            if ((tour == 11) || (tour == 14) || (tour == 16)
                || (tour == 18) || (tour == 28)) {
                python.turnLeft();
            }
            python.moveOn(gr);
//            gr.updateGrid(python);
            gr.updateGrids(python);

            System.out.println(gr);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tour == nRows * nCols) python.killSnake();
            tour += 1;
        }

        System.out.println("Taille du python: " + python.getSize());

        gr.decrIntGrid();


/*
        System.out.println("hello world !");
//      initialisation position de départ
        int [] pos = {4,4};
        int [] speed = {0,1};

        Snake p = new Snake(pos, speed, "rouge");
        System.out.println(p);

        if (p.isAlive()) {
            System.out.println("Le serpent est vivant");
        } else {
            System.out.println("Le serpent est mort");
        }

        p.isAlive();
        p.killSnake();

        p.getNextPosition();
        p.turnRight();
        p.turnLeft();
        System.out.println(p);

        System.out.println();

        int nRows = 2;
        int nCols = 4;
        Grid gr = new Grid(nRows, nCols);
        System.out.println(gr);


        if (gr.pointInsideGrid(1,1)) {
            gr.dropBlock(1, 1);
        }

        System.out.println(gr.getCell(1,1));

        p.moveOn(gr);
        System.out.println(p);

        gr.updateGrid(p);
*/
    }
}