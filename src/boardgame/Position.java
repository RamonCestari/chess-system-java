package boardgame;

public class Position {

    private Integer row;
    private Integer columns;

    public Position(Integer row, Integer colum) {
        this.row = row;
        this.columns = colum;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return columns;
    }

    public void setColum(Integer colum) {
        this.columns = colum;
    }

    @Override
    public String toString() {
        return row + "," + columns;
    }
}
