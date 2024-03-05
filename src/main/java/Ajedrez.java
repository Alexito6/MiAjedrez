import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import com.diogonunes.jcolor.Attribute;
import static com.diogonunes.jcolor.Ansi.colorize;
public class Ajedrez {
    public static void main(String[] args) {
        String jugadorBlanco,jugadorNegro;
        Scanner sc=new Scanner(System.in);
        String check="CHECK";
        check=colorize(check,Attribute.BACK_COLOR(0,255,0));
        System.out.println("Please insert the name of the player who will play with the white pieces.");
        jugadorBlanco= sc.nextLine();
        System.out.println("Please insert the name of the player who will play with the black pieces.");
        jugadorNegro= sc.nextLine();
        Board board=new Board();
        board.inicialice();
        DeletedPieceManagerListImp listaPiezas=new DeletedPieceManagerListImp();
        listaPiezas.getPieceList().addAll(board.getPiezas());
        boolean reyesVivos=true;
        while (reyesVivos){
            System.out.println("------------------------------------------------"+jugadorBlanco+"'turn--------------------------------------------------------------------------");
            System.out.println(board);
            System.out.println(listaPiezas.cajaRestantes());
            System.out.println(listaPiezas.cajaBorradas());
            if (board.check()){
                System.out.println(check);
            }
            String mov=Input.pedirCoordenada(jugadorBlanco+" tell me the coordinate of the piece you want to move please. Example(G6)");
            Input.movePiece(mov,board);
            listaPiezas.setPieceList(board.getPiezas());
            if (!board.hayReyes()){
                reyesVivos=false;
            }
            else {
                System.out.println("------------------------------------------------"+jugadorNegro+"'turn--------------------------------------------------------------------------");
                System.out.println(board);
                System.out.println(listaPiezas.cajaRestantes());
                System.out.println(listaPiezas.cajaBorradas());
                if (board.check()){
                    System.out.println(check);
                }
                mov=Input.pedirCoordenada(jugadorNegro+" tell me the coordinate of the piece you want to move please. Example(C3)");
                Input.movePiece(mov,board);
                listaPiezas.setPieceList(board.getPiezas());
                if (!board.hayReyes()){
                    reyesVivos=false;
                }
            }
        }
        if (!board.reyNegroVivo()){
            System.out.println(jugadorBlanco+" wins");
        }
        if (!board.reyBlancoVivo()){
            System.out.println(jugadorBlanco+" wins");
        }
    }
}
