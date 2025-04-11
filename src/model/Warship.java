package model;

import java.util.ArrayList;

public class Warship extends Boat {
	private boolean vertical;
	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;

	public Warship(byte size, String name, boolean vertical) {
		super(size, name);
		this.vertical = vertical;
		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();
	}

	public boolean getvertical() {
		return vertical;
	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		// Este método se deja como está para mantener compatibilidad con la clase base
		throw new UnsupportedOperationException("Unimplemented method 'Addboat1'");
	}

	public void addboat4(Matrix matrix, byte x, byte y) {
		matrix.addBoat1(x, y);
		valuesX.add(x);
		valuesY.add(y);
	}

	@Override
	public ArrayList<Byte> getX() {
		return valuesX;
	}

	@Override
	public ArrayList<Byte> getY() {
		return valuesY;
	}
}