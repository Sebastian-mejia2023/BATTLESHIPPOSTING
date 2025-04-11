package model;

import java.util.ArrayList;

public class Speedboat extends Boat {
	private byte x;
	private byte y;

	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;

	public Speedboat(byte size, String name) {
		super(size, name);

		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();

	}

	public void setPosition(byte x, byte y) {
		this.x = x;
		this.y = y;
	}

	public ArrayList getX() {
		return valuesX;
	}

	public ArrayList getY() {
		return valuesY;
	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {
		valuesX.add(x);
		valuesY.add(y);

		matrix.addBoat1(x, y);

	}
}
