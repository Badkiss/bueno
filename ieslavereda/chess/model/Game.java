package es.ieslavereda.chess.model;
import es.ieslavereda.view.Screen;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import  static  es.ieslavereda.view.Screen.*;
public class Game {
    private Board tablero;
    private String blancas;
    private String negras;
    PieceColor turno;

    public Game(){
        tablero=new Board();
        blancas = "Blancas";
        negras = "Negras";
        turno = PieceColor.WHITE;
        juegoStart();


    }

    public Board getTablero() {
        return tablero;
    }

    /**
     * metodo que simula una partida de ajedrez
     */
    public void juegoStart(){
        boolean ganador=false;
    do {
        show(tablero);
        System.out.println(CajaVivas(tablero));
        System.out.println(CajaMuertas(tablero.getStore()));
        Cell aux= Comprobador();
        tablero.cambioColor(aux.getPiece().getNextMovements());
        show(tablero);
        System.out.println(CajaVivas(tablero));
        System.out.println(CajaMuertas(tablero.getStore()));
        tablero.restaurarTablero();
        mover(aux);
       if (tablero.getStore().count(ChessType.WHITE_KING)==1){
           ganador=true;
           System.out.println("Ganador las negras");
       }else  if (tablero.getStore().count(ChessType.BLACK_KING)==1){
           ganador=true;
           System.out.println("Ganador las blancas");
       }else{
           cambiarturno();
       }
    }while (ganador==false);
    }

    /**
     * metodo que pide por teclado coordenadas
     * @return
     */
    public String  pillarC(){
        Scanner sc = new Scanner(System.in);
        String coordenada = sc.nextLine();
        return coordenada;
    }

    /**
     * metodo que cambia turno
     */
    public void cambiarturno(){
        if (turno==PieceColor.WHITE){
            turno=PieceColor.BLACK;
            System.out.println("Turno de las negras");
        }else {
            turno=PieceColor.WHITE;
            System.out.println("Turno de las blancas");
        }
    }

    /**
     * metodo que se asegura de que la coordenada esta bien y que  mueve la pieza anteriormente selecionada
     * @param celda celda en la que esta la pieza a mover
     */
    public void mover(Cell celda){
        List<Coordinate> lista= celda.getPiece().getNextMovements();
        System.out.println("Selecciona una coordenada de las celdas resaltadas");
        char letra;
        int numero;
        boolean bien =false;
        do {
            String coordenada = pillarC();
         if (coordenada.length()==2){
             letra= coordenada.toUpperCase().charAt(0);
             if (letra>='A'&& letra<='H') {
                 numero = Character.getNumericValue(coordenada.charAt(1));
                 if (numero >= 1 && numero <= 8) {
                     Coordinate aux = new Coordinate(letra,numero);
                    List<Coordinate> movimientos = celda.getPiece().getNextMovements();
                    Coordinate[] movimiento= movimientos.toArray(new Coordinate[movimientos.size()]);
                     int i=0;
                    boolean coincide = false;
                    do {
                       if (movimiento[i].equals(aux)){
                           coincide=true;
                       }
                        i++;
                    }while (coincide==false && i<movimiento.length);

                    if (coincide==true){

                        bien=true;
                        tablero.moverP(aux,celda);
                    }else {
                        System.out.println("Ponga una coordenada  respectiva a las celdas iluminadas");
                    }

                 } else {
                     System.out.println("Coordenada con el numero mal tecleada, vuelva teclear una coordenada ");
                 }
             }else{
                 System.out.println("Coordenada con la letra mal tecleada, vuelva teclear una coordenada ");
             }
         }else{
             System.out.println("Coordenada mal tecleada, vuelva a teclear otra coordenada");
         }
        }while (bien==false);
    }

    /**
     * pide una coordenada al jugador y comprueba si puede utilizar o si hay una pieza en la coordenada
     * @return
     */
    public Cell Comprobador(){
        Scanner sc = new Scanner(System.in);
        boolean bien =false;
        Cell  celda= null;
        char letra;

        int numero;
        System.out.println("Escriba una coordenada");
        System.out.println("Coordenada ejemplos:");
        System.out.println("A1 , B4 , C3");
        do {
           String coordenada = pillarC();
            if (coordenada.length()==2){
                letra= coordenada.toUpperCase().charAt(0);
                if (letra<='H' && letra>='A'){
                numero = Character.getNumericValue(coordenada.charAt(1));
                if (numero<=8 && numero>=1){
                    Coordinate aux=new Coordinate(letra,numero);
                if (tablero.containsPieceAt(aux)){
                    if (tablero.getCellAt(aux).getPiece().getColor()==turno){
                     if (tablero.getCellAt(aux).getPiece().getNextMovements().size()>=1){
                        celda = tablero.getCellAt(aux);
                        bien=true;
                     }else{
                         System.out.println("La pieza no puede moverse");
                     }
                    }else{
                        System.out.println("La pieza seleccionada no es de tu color, vuelva a teclear una coordenada");
                    }
                }else{
                    System.out.println("Coordenada sin ficha, vuelva a teclear una coordenada");
                }
                }else{
                    System.out.println("Numero de la coordenada invalido, vuelva a teclear otra coordenada");
                }
                }else{
                    System.out.println("Letra de la coordenada invalida, vuelva a teclear otra coordenada");
                }
            }else{
                System.out.println("Coordenada mal escrita, vuelva a teclear otra coordenada");
            }
        }while (bien==false);
        return celda;
    }
}
