package model;

import java.util.ArrayList;

public class Player {
	private String name;
	private byte points;
	public Matrix matrix;
	public ArrayList<Boat> boats;

	public Player(String name, byte points, Matrix matrix) {
		this.name = name;
		this.points = points;
		this.matrix = matrix;
		this.boats = new ArrayList<>();
	}

	public void removeBoat(Boat boat) {
		// Verifica si el barco existe en la lista antes de intentar eliminarlo
		if (boats.contains(boat)) {
			boats.remove(boat);
		} else {
			System.out.println("El barco no se encuentra en la lista.");
		}
	}

	public ArrayList<Boat> getList() {
		return boats;
	}

	// Getters opcionales para acceder desde otras clases
	public String getName() {
		return name;
	}

	public byte getPoints() {
		return points;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void addPoint() {
		this.points++;
	}

}
