package es.ieslavereda.chess.model;

public class Coordinate  {

	private char letter;
	private int number;

	public Coordinate(char letter, int number) {
		String letterAsString = String.valueOf(letter);
		this.letter = (letterAsString.toUpperCase()).charAt(0);
		this.number = number;
	}

	public char getLetter() {
		return letter;
	}
	public int getNumber() {
		return number;
	}



	public int getLetterAsPosition() {
		return letter - 'A';
	}

	public int getNumberAsPosition() {
		return number - 1;
	}

	/**
	 * nos da una coordenada arriba  en funcion a la coordenada puesta
	 * @return
	 */
	public Coordinate up() {
		return new Coordinate(letter, number - 1);
	}
	/**
	 * nos da una coordenada abajo  en funcion a la coordenada puesta
	 * @return
	 */
	public Coordinate down() {
		return new Coordinate(letter, number + 1);
	}
	/**
	 * nos da una coordenada izquierda en funcion a la coordenada puesta
	 * @return
	 */
	public Coordinate left() {
		return new Coordinate((char) (letter - 1), number);
	}
	/**
	 * nos da una coordenada derecha  en funcion a la coordenada puesta
	 * @return
	 */
	public Coordinate right() {
		return new Coordinate((char) (letter + 1), number);
	}

	public Coordinate diagonalUpLeft() {
		return up().left();
	}

	public Coordinate diagonalUpRight() {
		return up().right();
	}

	public Coordinate diagonalDownLeft() {
		return down().left();
	}

	public Coordinate diagonalDownRight() {
		return down().right();
	}

	/**
	 * metodo para saber si una coordenada es igual que otra
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof Coordinate){
			Coordinate aux = (Coordinate) o;
			return aux.getLetter() == letter && aux.getNumber() == number;
		}else{
			return false;
		}
	}


	/**
	 * metodo para poder organizar un set
	 * @return
	 */
	@Override
	public int hashCode() {
		return number;
	}

//	@Override
//	public String toString() {
//		return "Letter: " + letter + " - Number: " + number;
//	}

	@Override
	public String toString() {
		return "(" + letter + "," + number+")";
	}
}
