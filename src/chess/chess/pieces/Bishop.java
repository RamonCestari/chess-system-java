package chess.chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {


    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //NORTHWEST
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (getBoard().positionExistis(p) && isThereAnOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NORTHEAST
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (getBoard().positionExistis(p) && isThereAnOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHEAST
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }
        if (getBoard().positionExistis(p) && isThereAnOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHWEST
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExistis(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if (getBoard().positionExistis(p) && isThereAnOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;

    }

    @Override
    public String toString() {
        return "B";
    }
}
