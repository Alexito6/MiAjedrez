import java.util.ArrayList;
import java.util.List;
import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;
public class DeletedPieceManagerListImp{

    List<Piece> pieceList;
    public DeletedPieceManagerListImp(){
        pieceList=new ArrayList<>();
    }
    public List<Piece> getPieceList(){
        return pieceList;
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
