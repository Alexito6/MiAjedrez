public class Comprobaciones {
    public static boolean coordenadaCorrecta(String coordenada){
        coordenada=coordenada.toUpperCase();
        if (coordenada.length()!=2 || (coordenada.charAt(0)<65 || coordenada.charAt(0)>90) || (coordenada.charAt(1)-48>8 || coordenada.charAt(0)-48<1)){
            return false;
        }
        return true;
    }
}
