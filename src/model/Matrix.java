package model;

public class Matrix {
	private byte[][] matrix;

	/* Constructor que crea y llena la matriz con ceros */
	public Matrix() {
		matrix = new byte[10][10];
		for (byte i = 0; i < matrix.length; i++) {
			for (byte j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = 0; // 0 representa agua
			}
		}
	}

	/* Método para imprimir la matriz */
	public void getMatrix() {
		System.out.println("    1   2   3   4   5   6   7   8   9   10");
		for (byte i = 0; i < matrix.length; i++) {
			System.out.print((i + 1) + "- |");
			for (byte j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println("\n");
		}
	}

	/* Método para poner un barco (valor 1) en una posición */
	public void addBoat1(byte x, byte y) {
		matrix[y][x] += 1;
	}

	/* Método para obtener el valor en una posición específica */
	public byte getValue(byte x, byte y) {
		return matrix[y][x];
	}

}
