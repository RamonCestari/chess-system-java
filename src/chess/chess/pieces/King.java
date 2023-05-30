package chess.chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }


    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //UP
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //DOWN
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //LEFT
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //RIGHT
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NORTHWEST
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NORTHEAST
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHWEST
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHEAST
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExistis(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SPECIAL MOVEMENT CASTLING
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position positionR1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionR1)) {
                Position position1 = new Position(position.getRow(), position.getColumn() + 1);
                Position position2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            Position positionR2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(positionR2)) {
                Position position1 = new Position(position.getRow(), position.getColumn() - 1);
                Position position2 = new Position(position.getRow(), position.getColumn() - 2);
                Position position3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }

        }


        return mat;
    }


    @Override
    public String toString() {
        return "K";
    }
}
