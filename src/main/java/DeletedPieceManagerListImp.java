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
    public void setPieceList(List<Piece> pieceList){
        this.pieceList=pieceList;
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
    public String cajaBorradas(){
        String cajaArribaBlanca=Piece.Type.WHITE_PAWN.getShape()+" "+Piece.Type.WHITE_ROOK.getShape()+" "+Piece.Type.WHITE_BISHOP.getShape()+
                " "+Piece.Type.WHITE_KING.getShape()+" "+Piece.Type.WHITE_KNIGHT.getShape()+" "+Piece.Type.WHITE_QUEEN.getShape();
        String cajaArribaNegra=" "+Piece.Type.BLACK_PAWN.getShape()+" "+Piece.Type.BLACK_ROOK.getShape()+" "+Piece.Type.BLACK_BISHOP.getShape()+
                " "+Piece.Type.BLACK_KING.getShape()+" "+Piece.Type.BLACK_KNIGHT.getShape()+" "+Piece.Type.BLACK_QUEEN.getShape();
        cajaArribaNegra=colorize(cajaArribaNegra,Attribute.TEXT_COLOR(0,0,0));
        String cajaCompleta=cajaArribaBlanca+cajaArribaNegra;
        cajaCompleta=colorize(cajaCompleta,Attribute.BACK_COLOR(100,100,100));
        int peonBlanco = 0,torreBlanca=0,alfilBlanco=0,reyBlanco=0,caballoBlanco=0,reinaBlanca=0,peonNegro=0,torreNegra=0,alfilNegro=0,reyNegro=0,caballoNegro=0,reinaNegra=0;
        for (Piece p:pieceList){
            if (p.getType()== Piece.Type.BLACK_KING){
                reyNegro=count(p.getType());
                if (reyNegro!=1){
                    reyNegro=1;
                }
                else {
                    reyNegro=0;
                }
            }
            if (p.getType()== Piece.Type.BLACK_PAWN){
                peonNegro=count(p.getType());
                if (peonNegro!=8){
                    peonNegro=8-peonNegro;
                }
                else {
                    peonNegro=0;
                }
            }
            if (p.getType()== Piece.Type.BLACK_QUEEN){
                reinaNegra=count(p.getType());
                if (reinaNegra!=1){
                    reinaNegra=0;
                }
                else {
                    reinaNegra=0;
                }
            }
            if (p.getType()== Piece.Type.BLACK_ROOK){
                torreNegra=count(p.getType());
                if (torreNegra!=2){
                    torreNegra=2-torreNegra;
                }
                else {
                    torreNegra=0;
                }
            }
            if (p.getType()== Piece.Type.BLACK_KNIGHT){
                caballoNegro=count(p.getType());
                if (caballoNegro!=2){
                    caballoNegro=2-caballoNegro;
                }
                else {
                    caballoNegro=0;
                }
            }
            if (p.getType()== Piece.Type.BLACK_BISHOP){
                alfilNegro=count(p.getType());
                if (alfilNegro!=2){
                    alfilNegro=2-alfilNegro;
                }
                else {
                    alfilNegro=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_KING){
                reyBlanco=count(p.getType());
                if (reyBlanco!=1){
                    reyBlanco=0;
                }
                else {
                    reyBlanco=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_PAWN){
                peonBlanco=count(p.getType());
                if (peonBlanco!=8){
                    peonBlanco=8-peonBlanco;
                }
                else {
                    peonBlanco=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_QUEEN){
                reinaBlanca=count(p.getType());
                if (reinaBlanca!=1){
                    reinaBlanca=0;
                }
                else {
                    reinaBlanca=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_ROOK){
                torreBlanca=count(p.getType());
                if (torreBlanca!=2){
                    torreBlanca=2-torreBlanca;
                }
                else {
                    torreBlanca=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_KNIGHT){
                caballoBlanco=count(p.getType());
                if (caballoBlanco!=2){
                    caballoBlanco=2-caballoBlanco;
                }
                else {
                    caballoBlanco=0;
                }
            }
            if (p.getType()== Piece.Type.WHITE_BISHOP){
                alfilBlanco=count(p.getType());
                if (alfilBlanco!=2){
                    alfilBlanco=2-alfilBlanco;
                }
                else {
                    alfilBlanco=0;
                }
            }

        }
        String cajaAbajo=peonBlanco+" "+torreBlanca+" "+alfilBlanco+" "+reyBlanco+" "+caballoBlanco+" "+reinaBlanca+
                " "+peonNegro+" "+torreNegra+" "+alfilNegro+" "+reyNegro+" "+caballoNegro+" "+reinaNegra;
        cajaAbajo=colorize(cajaAbajo,Attribute.BACK_COLOR(180,180,180));
        cajaAbajo=colorize(cajaAbajo,Attribute.TEXT_COLOR(0,0,0));
        return "DELETED PIECES:"+"\n"+cajaCompleta+"\n"+cajaAbajo;
    }
    public String cajaRestantes(){
        String cajaArribaBlanca=Piece.Type.WHITE_PAWN.getShape()+" "+Piece.Type.WHITE_ROOK.getShape()+" "+Piece.Type.WHITE_BISHOP.getShape()+
                " "+Piece.Type.WHITE_KING.getShape()+" "+Piece.Type.WHITE_KNIGHT.getShape()+" "+Piece.Type.WHITE_QUEEN.getShape();
        String cajaArribaNegra=" "+Piece.Type.BLACK_PAWN.getShape()+" "+Piece.Type.BLACK_ROOK.getShape()+" "+Piece.Type.BLACK_BISHOP.getShape()+
                " "+Piece.Type.BLACK_KING.getShape()+" "+Piece.Type.BLACK_KNIGHT.getShape()+" "+Piece.Type.BLACK_QUEEN.getShape();
        cajaArribaNegra=colorize(cajaArribaNegra,Attribute.TEXT_COLOR(0,0,0));
        String cajaCompleta=cajaArribaBlanca+cajaArribaNegra;
        cajaCompleta=colorize(cajaCompleta,Attribute.BACK_COLOR(100,100,100));
        int peonBlanco = 0,torreBlanca=0,alfilBlanco=0,reyBlanco=0,caballoBlanco=0,reinaBlanca=0,peonNegro=0,torreNegra=0,alfilNegro=0,reyNegro=0,caballoNegro=0,reinaNegra=0;
        for (Piece p:pieceList){
            if (p.getType()== Piece.Type.BLACK_KING){
                reyNegro=count(p.getType());
            }
            if (p.getType()== Piece.Type.BLACK_PAWN){
                peonNegro=count(p.getType());
            }
            if (p.getType()== Piece.Type.BLACK_QUEEN){
                reinaNegra=count(p.getType());
            }
            if (p.getType()== Piece.Type.BLACK_ROOK){
                torreNegra=count(p.getType());
            }
            if (p.getType()== Piece.Type.BLACK_KNIGHT){
                caballoNegro=count(p.getType());
            }
            if (p.getType()== Piece.Type.BLACK_BISHOP){
                alfilNegro=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_KING){
                reyBlanco=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_PAWN){
                peonBlanco=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_QUEEN){
                reinaBlanca=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_ROOK){
                torreBlanca=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_KNIGHT){
                caballoBlanco=count(p.getType());
            }
            if (p.getType()== Piece.Type.WHITE_BISHOP){
                alfilBlanco=count(p.getType());
            }
        }
        String cajaAbajo=peonBlanco+" "+torreBlanca+" "+alfilBlanco+" "+reyBlanco+" "+caballoBlanco+" "+reinaBlanca+
                " "+peonNegro+" "+torreNegra+" "+alfilNegro+" "+reyNegro+" "+caballoNegro+" "+reinaNegra;
        cajaAbajo=colorize(cajaAbajo,Attribute.BACK_COLOR(180,180,180));
        cajaAbajo=colorize(cajaAbajo,Attribute.TEXT_COLOR(0,0,0));
        return "REMAINING PIECES:"+"\n"+cajaCompleta+"\n"+cajaAbajo;

    }
}
