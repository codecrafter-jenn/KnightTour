import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard(8,8);
        Knight knight = new Knight();
        boolean solved = takeTour(chessboard,knight);
        if(solved) {
            chessboard.printSolution();
        }
    }
    public static boolean takeTour(Chessboard chessboard, Knight knight){
        if(!chessboard.isTourComplete()) {
            List<int[]> nextMoves = knight.listPossibleNextMoves();
            List<int[]> validNextMoves = chessboard.validateList(nextMoves);
            for(int[] move: validNextMoves) {
                chessboard.recordMove(move);
                knight.moveKnight(move);
                if(takeTour(chessboard,knight)){
                    return true;
                }
                chessboard.undoMove(move);
            }
        } else {
            return true;
        }
        return false;
    }
}