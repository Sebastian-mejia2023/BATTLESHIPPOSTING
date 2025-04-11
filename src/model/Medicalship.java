package model;

import java.util.ArrayList;

public class Medicalship extends Boat {
	private byte p1;
	private byte p2;
	private byte p3;
	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;
	private boolean vertical;

	public Medicalship(byte size, String name) {
		super(size, name);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.vertical = vertical;
		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	/* cambiar metodo addboat al metodo abstracto */

	public void addboat2(Matrix matrix, byte x1, byte x2, byte y1, byte y2) {

		matrix.addBoat1(x1, y2);
		matrix.addBoat1(x1, y1);
		valuesX.add(x1);
		valuesX.add(x2);
		valuesY.add(y1);
		valuesY.add(y2);

	}

	@Override
	public void Addboat1(Matrix matrix, byte x, byte y) {

	}

}
