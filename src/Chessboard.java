import java.util.ArrayList;
import java.util.List;

public class Chessboard {
    private final int[][] moveHistory;
    private int moveNumber = 1;

    public Chessboard(int x, int y){
        moveHistory = new int[x][y];
        moveHistory[0][0] = moveNumber;
    }
    public List<int[]> validateList(List<int[]> nextMoves){
        List<int[]> validMoves = new ArrayList<>();
        for(int[] move: nextMoves){
            if(move[0] >= 0 && move[0] < moveHistory.length){
                if(move[1] >= 0 && move[1] < moveHistory.length) {
                    if (moveHistory[move[0]][move[1]] == 0){
                        validMoves.add(move);
                    }
                }
            }
        }
        return validMoves;
    }
    public boolean isTourComplete(){
        return moveNumber == moveHistory.length * moveHistory.length;
    }

    public void recordMove(int[] move) {
        moveNumber++;
        moveHistory[move[0]][move[1]] = moveNumber;
    }
    public void undoMove(int[] move) {
        moveHistory[move[0]][move[1]] = 0;
        moveNumber--;
    }
    public void printSolution(){
        for (int[] move : moveHistory) {
            for (int j = 0; j < moveHistory.length; j++) {
                System.out.printf("%2d ", move[j]);
            }
            System.out.println();
        }
    }
}
