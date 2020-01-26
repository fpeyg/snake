package snake;

import java.util.Arrays;

public class Grid {

    private String[][] grid;
    private int nRows = 0 ;
    private int nCols = 0;
    private int[][] intGrid;

    public Grid() {
    }

    public Grid(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.grid = new String[nRows][nCols];
        for (int i = 0; i < this.nRows; i++) {
            for (int j = 0; j < this.nCols; j++) {
                this.grid[i][j] = " ";
            }
        }
        this.intGrid = genIntGrid();
    }

     public int[][] genIntGrid() {
        int[][] tab2D = new int[this.nRows][this.nCols];
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                tab2D[i][j] = 0;
            }
        }
        return tab2D;
    }

    public void decrIntGrid() {
//        décrémente de 1 chaque valeur trouvée
//        de intGrid sans tomber au dessous de 0
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (this.intGrid[i][j] != 0) {
                    this.intGrid[i][j]--;
                }
            }
        }
    }

    public void updateGrids(Snake snake) {
//      effacer tous les symboles Snake "*" de la grille
        for (int i = 0; i < this.nRows; i++) {
            for (int j = 0; j < this.nCols; j++) {
                if ((this.grid[i][j]).compareTo("*") == 0) {
                    this.grid[i][j] = " ";
                }
            }
        }
//      si le serpent est vivant , récupère sa position et donne à la
//      case correspondante dans intGrid la même valeur que la taille du Snake
        if (snake.isAlive()) {
            this.intGrid[snake.getPos()[0]][snake.getPos()[1]] = snake.getSize();
//       Passe sur toutes les cases de intGrid et si une valeur supérieure à 0 est trouvée,
//       dessine un symbole Snake ‘*’ à cet emplacement dans grid
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    if (this.intGrid[i][j] >0) {
                        this.grid[i][j] = "*";
                    }
                }
            }
        }
//        Appelle decrIntGrid()
        decrIntGrid();
    }

    public boolean pointInsideGrid(int i, int y) {

        return ( (i >= 0 && i < (this.nRows - 1))
                && (y >= 0 && y < (this.nCols - 1)));
    }

    public void placeObject(int y, int x, String o) {
        this.grid[y][x] = o;
    }

    public void dropBlock(int y, int x) {
        placeObject(y, x, "#");
    }

    public void dropFood(int y, int x) {
        placeObject(y, x, "o");
    }

    public void updateGrid(Snake snake) {
//      mettre la grille à jour en fonction du serpent ==
//      effacer tous les symboles Snake "*" de la grille
        for (int i = 0; i < this.nRows; i++) {
            for (int j = 0; j < this.nCols; j++) {
                if ((this.grid[i][j]).compareTo("*") == 0) {
                    this.grid[i][j] = " ";
                }
            }
        }
//      si le serpent est vivant , le repeindre (que le tête)
        if (snake.isAlive()) {
            this.grid[snake.getPos()[0]][snake.getPos()[1]] = "*";
        }
    }

    public String getCell(int y, int x) {
        return this.grid[y][x];
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getNRows() {
        return nRows;
    }

    public int getNCols() {
        return nCols;
    }

    @Override
    public String toString() {
        String out = "";
//        première ligne
        for (int l = 0; l < nCols + 2; l++) {
           out += "+";
        }
//       contenu de la grille
        for (int i = 0; i < nRows; i++) {
            out += "\n+";
            for (int j = 0; j < nCols; j++) {
                out += grid[i][j];
            }
            out += "+";
        }
//        dernière ligne
        out += "\n";
        for (int l = 0; l < nCols + 2; l++) {
            out += "+";
        }
        return out + "\n";
    }


}