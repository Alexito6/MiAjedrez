import java.util.ArrayList;
import java.util.List;

public class DeletedPieceManagerListImp{

    List<Piece> pieceList;
    public DeletedPieceManagerListImp(){
        pieceList=new ArrayList<>();
    }
    public void addPiece(Piece piece){
        pieceList.add(piece);
    }
    public Piece removeLast(){
        return pieceList.remove(pieceList.size()-1);
    }
    public int count(Piece.Type pieceType){
        int counterPieces=0;
        for (Piece p:pieceList){
            if (p.getType()==pieceType){
                counterPieces++;
            }
        }
        return counterPieces;
    }
}
