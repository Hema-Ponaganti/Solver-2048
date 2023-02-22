import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    @Test
    public void shouldMoveTheTileToProvidedCoordinates() {
        Tile tile1 = new Tile(2, 0, 0);
        Tile tile2 = new Tile(0, 1, 0);
        tile1.move(tile2);
        assertEquals(1, tile1.row);
        assertEquals(0, tile1.col);
        assertEquals(2,tile1.value);
    }

    @Test
    public void testMerge() {
        Tile tile1 = new Tile(2, 0, 0);
        Tile tile2 = new Tile(2, 0, 1);
        tile1.merge(tile2);
        assertEquals(4, tile1.value);
        assertEquals(0, tile2.value);
    }
}