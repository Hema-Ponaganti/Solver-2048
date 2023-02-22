import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardTest {
    @Test
    public void ShouldMoveDownAndMergeAdjacentMatchingTiles() {
        Board board = new Board(4);
        board.tiles = new int[][]{{2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 2, 0, 0},
                {2, 2, 0, 0}};

        board.moveDown();

        assertEquals(4, board.tiles[3][0]);
        assertEquals(4, board.tiles[2][0]);
        assertEquals(4, board.tiles[3][1]);
        assertEquals(12, board.getScore());
        assertFalse( board.isGameOver());
    }

    @Test
    public void ShouldMoveUpAndMergeAdjacentMatchingTiles() {
        Board board = new Board(4);
        board.tiles = new int[][]{{2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 2, 0, 0},
                {2, 2, 0, 0}};

        board.moveUp();

        assertEquals(4, board.tiles[0][0]);
        assertEquals(4, board.tiles[1][0]);
        assertEquals(4, board.tiles[0][1]);
        assertEquals(12, board.getScore());

    }

    @Test
    public void ShouldMoveLeftAndMergeAdjacentMatchingTiles() {
        Board board = new Board(4);
        board.tiles = new int[][]{{2, 2, 2, 2},
                {0, 0, 0, 0},
                {0, 4, 4, 0},
                {0, 0, 0, 0}};
        board.moveLeft();
        assertEquals(4, board.tiles[0][0]);
        assertEquals(8, board.tiles[2][0]);
        assertEquals(4, board.tiles[0][1]);
        assertEquals(16, board.getScore());

    }

    @Test
    public void ShouldMoveRightAndMergeAdjacentMatchingTiles() {
        Board board = new Board(4);
        board.tiles = new int[][]{{2, 2, 4, 4},
                {0, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 0}};
        board.moveRight();
        assertEquals(8, board.tiles[0][3]);
        assertEquals(4, board.tiles[0][2]);
        assertEquals(4, board.tiles[2][3]);
        assertEquals(16, board.getScore());

    }


}