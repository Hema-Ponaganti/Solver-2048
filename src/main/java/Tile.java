public class Tile {
    public int value;
    public int row;
    public int col;

    public Tile(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public void move(Tile other) {
        this.row = other.row;
        this.col = other.col;
    }

    public void merge(Tile other) {
        this.value *= 2;
        other.value = 0;
    }
}
