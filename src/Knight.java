import java.util.ArrayList;
import java.util.List;

public class Knight {

    private int x = 0;
    private int y = 0;
    // knight's position on board

    int[] xMovesLikeThis = new int[] {2,2,1,1,-1,-1,-2,-2};
    int[] yMovesLikeThis = new int[] {-1,1,-2,2,-2,2,-1,1};

    public List<int[]> listPossibleNextMoves(){
        List<int[]> nextMoves = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            int xNextMove = x + xMovesLikeThis[i];
            int yNextMove = y + yMovesLikeThis[i];
            int[] nextMove = new int[]{xNextMove,yNextMove};
            nextMoves.add(nextMove);
        }
        return nextMoves;
    }

    public void moveKnight(int[] move) {
        x = move[0];
        y = move[1];
    }

}
