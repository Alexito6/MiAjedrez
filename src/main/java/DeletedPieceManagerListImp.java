import java.util.ArrayList;
import java.util.List;
import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;
public class DeletedPieceManagerListImp{
    private Attribute color;
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
    public enum ColorCaja {
        WHITE(Attribute.BACK_COLOR(180,180,180)),
        BLACK(Attribute.BACK_COLOR(100,100,100));

        private Attribute color;

        ColorCaja(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }
    }
}
