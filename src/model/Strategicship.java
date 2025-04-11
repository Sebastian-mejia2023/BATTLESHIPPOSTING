package model;

import java.util.ArrayList;

public class Strategicship extends Boat {
	private boolean vertical;

	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;

	public Strategicship(byte size, String name, boolean vertical) {
		super(size, name); // Llama al constructor de la clase padre
		this.vertical = vertical; // Inicializa el atributo vertical
		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();

		// Establece el nombre basado en la orientación
		if (vertical) {
			super.name = "Barco de municiones"; // Cambia el nombre si es vertical
		} else {
			super.name = "Barco de provisiones"; // Cambia el nombre si es horizontal
		}
	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'Addboat1'");
	}

	public void addboat3(Matrix matrix, byte x, byte y) {
		matrix.addBoat1(x, y);
		valuesX.add(x);
		valuesY.add(y);

	}

}
