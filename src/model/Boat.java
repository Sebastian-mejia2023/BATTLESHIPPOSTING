package model;

import java.util.ArrayList;

public abstract class Boat {
	protected byte size;
	protected String name;
	private ArrayList<Byte> valuesX;
	private ArrayList<Byte> valuesY;

	public Boat(byte size, String name) {
		this.size = size;
		this.size = size;
		this.valuesX = new ArrayList<Byte>();
		this.valuesY = new ArrayList<Byte>();

		/* Inicializar todas las casillas como vivas (valor 1) */

	}

	public void setname(String name) {
		this.name = name;
	}

	public void parts() {

	}

	public ArrayList<Byte> getX() {
		return valuesX;
	}

	public ArrayList<Byte> getY() {
		return valuesY;
	}

	public String getName() {
		return name;
	}

	public byte getSize() {
		return size;
	}

	public abstract void Addboat1(Matrix matrix, byte x, byte y);

}