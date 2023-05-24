package chess.chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //UP-LEFT
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 2, p.getColumn() - 1);
        }

        //UP-RIGHT
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 2, p.getColumn() + 1);
        }

        //DOWN-LEFT
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 2, p.getColumn() - 1);
        }

        //DOWN-RIGHT
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 2, p.getColumn() + 1);
        }

        //RIGHT-UP
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 2);
        }

        //RIGHT-DOWN
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }

        //LEFT-UP
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 2);
        }

        //LEFT-DOWN
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 2);
        }

        return mat;
    }


    @Override
    public String toString() {
        return "N";
    }
}
