package es.ieslavereda.chess.model;

public class Tool {
    public static Coordinate[] add(Coordinate[] array, Coordinate coordinate){
        Coordinate[] aux = new Coordinate[array.length+1];

        for(int i=0;i< array.length;i++)
            aux[i]=array[i];

        aux[array.length]=coordinate;
        return aux;
    }
    public static void show(Coordinate[] coordinates){
        for(Coordinate coordinate : coordinates)
            System.out.println(coordinate);
    }
}
