package boardgame;

public class Position {

    private Integer rows;
    private Integer columns;

    public Position(Integer row, Integer colum) {
        this.rows = row;
        this.columns = colum;
    }

    public Integer getRow() {
        return rows;
    }

    public void setValues(Integer row, Integer column){
        this.rows = row;
        this.columns = column;

    }

    public void setRow(Integer row) {
        this.rows = row;
    }

    public Integer getColumn() {
        return columns;
    }

    public void setColum(Integer colum) {
        this.columns = colum;
    }

    @Override
    public String toString() {
        return rows + "," + columns;
    }
}
