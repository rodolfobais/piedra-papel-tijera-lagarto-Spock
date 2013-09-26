package edu.tallerweb.pptls;

import java.util.ArrayList;

/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {

	private final Forma forma;
	private final ArrayList<Integer> venceA = new ArrayList<Integer>();
	
	/**
	 * Toda Mano debe crearse con una forma dada, que será
	 * la que determine su condición en el juego.
	 * @param forma, la Forma que adopta la Mano.
	 */
	public Mano(final Forma forma) {
		this.forma=forma;
		//Agrego al vector de vence las posibles manos ganadas
		//Una forma gana siempre a las 2 anteriores. El problema que debe ser ciclico el enum.
		this.venceA.add(getAnterior(1));
		this.venceA.add(getAnterior(2));
	}

	/**
	 * Evaluará el resultado de la partida según las reglas
	 * del juego.
	 * @param otra, la otra Mano.
	 * @return un Resultado, de acuerdo al estado del juego.
	 */
	public Resultado jugarCon(final Mano otra) {
		if(this.forma.getValor().equals(otra.forma.getValor()))
			return Resultado.EMPATA;
		if(this.venceA.contains(otra.forma.getValor()))
			return Resultado.GANA;
		return Resultado.PIERDE;
	}
	
	private Integer getAnterior(int offset){
		
		if(this.forma.getValor()-offset<0){ //Si es negativo hay que dar la vuelta al array
			return (this.forma.getValor()-offset+5); // Se hace la correccion de 5, el total del array			
		}
		return this.forma.getValor()-offset;
	}

}
