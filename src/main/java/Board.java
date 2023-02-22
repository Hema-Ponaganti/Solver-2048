import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {

    public int size;
    public int[][] tiles;
    private int score;

    public Board(int size) {
        this.size = size;
        this.tiles = initialize(size);
        this.score = 0;

        addRandomTile();
        addRandomTile();
    }

    private int[][] initialize(int size) {
        int[][] tiles = new int[size][size];
        for(int i = 0;i<size;i++){
            for (int j=0;j<size;j++){
                tiles[i][j] = 0;
            }
        }
        return tiles;
    }

    public void moveLeft() {
        for (int row = 0; row < size; row++) {
            int[] newRow = new int[size];
            int index = 0;
            for (int col = 0; col < size; col++) {
                if (tiles[row][col] != 0) {
                    if (newRow[index] == 0) {
                        newRow[index] = tiles[row][col];
                    } else if (newRow[index] == tiles[row][col]) {
                        newRow[index] *= 2;
                        score += newRow[index];
                        index++;
                    } else {
                        index++;
                        newRow[index] = tiles[row][col];
                    }
                }
            }
            System.out.println("tiles : " + Arrays.deepToString(tiles));

            tiles[row] = newRow;
        }

        addRandomTile();
    }

    public void moveRight() {
        for (int row = 0; row < size; row++) {
            int[] newRow = new int[size];
            int index = size - 1;
            for (int col = size - 1; col >= 0; col--) {
                if (tiles[row][col] != 0) {
                    if (newRow[index] == 0) {
                        newRow[index] = tiles[row][col];
                    } else if (newRow[index] == tiles[row][col]) {
                        newRow[index] *= 2;
                        score += newRow[index];
                        index--;
                    } else {
                        index--;
                        newRow[index] = tiles[row][col];
                    }
                }
            }
            System.out.println("tiles : " + Arrays.deepToString(tiles));
            tiles[row] = newRow;
        }

        addRandomTile();
    }

    public void moveUp() {
        for (int col = 0; col < size; col++) {
            int[] newCol = new int[size];
            int index = 0;
            for (int row = 0; row < size; row++) {
                if (tiles[row][col] != 0) {
                    if (newCol[index] == 0) {
                        newCol[index] = tiles[row][col];
                    } else if (newCol[index] == tiles[row][col]) {
                        newCol[index] *= 2;
                        score += newCol[index];
                        index++;
                    } else {
                        index++;
                        newCol[index] = tiles[row][col];
                    }
                }
            }
            System.out.println("tiles : " + Arrays.deepToString(tiles));

            for (int row = 0; row < size; row++) {
                tiles[row][col] = newCol[row];
            }
        }

        addRandomTile();
        System.out.println("tiles : " + Arrays.deepToString(tiles));

    }

    public void moveDown() {
        for (int col = 0; col < size; col++) {
            int[] newColumn = new int[size];
            int index = size -1;
            for (int row = size - 1; row >= 0; row--) {
                int value = tiles[row][col];
                if (value != 0) {
                    if (newColumn[index] == 0){
                        newColumn[index] = value;
                    } else if (newColumn[index] == tiles[row][col]) {
                        newColumn[index] *= 2;
                        score += newColumn[index];
                        index--;
                    }else {
                        index --;
                        newColumn[index] = tiles[row][col];
                    }
                }
            }
            System.out.println("tiles : " + Arrays.deepToString(tiles));

            for (int row = 0; row < size; row++) {
                tiles[row][col] = newColumn[row];
            }
        }
        addRandomTile();
    }

    public boolean isGameOver() {
        if (getEmptyTiles().size() > 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = tiles[i][j];

                if (i < size - 1 && tiles[i+1][j] == value) {
                    return false;
                }

                if (j < size - 1 && i >= size/2 && (tiles[i][j+1] == value || tiles[i+1][j+1] == value)) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getScore() {
        return score;
    }

    private void addRandomTile() {
        List<int[]> emptyTiles = getEmptyTiles();

        if (emptyTiles.size() > 0) {
            int[] chosenTile = emptyTiles.get(new Random().nextInt(emptyTiles.size()));
            tiles[chosenTile[0]][chosenTile[1]] = new Random().nextInt(2) == 0 ? 2 : 4;
        }
    }

    private List<int[]> getEmptyTiles() {
        List<int[]> emptyTiles = new ArrayList<int[]>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (tiles[row][col] == 0) {
                    emptyTiles.add(new int[] {row, col});
                }
            }
        }
        return emptyTiles;
    }
}
