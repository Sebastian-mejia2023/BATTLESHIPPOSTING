
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * quitar getmatrix del metodo añadir bote para que no se muestre la matriz de
 * la maquina
 * agregar despues del metodo añadir bote de subclase bote
 * añadir metodo random para la maquina y crear 2 clases de botes que faltan
 * ANTES DE MEDIO DIA
 * para la noche tener listo ataque, verificacion y hundimiento
 * 
 * 
 */
public class Controller {
	Player[] playerslist = new Player[2];
	ArrayList<Boat> boats = new ArrayList<>();
	Random range = new Random();

	/* metodos de inicializacion */
	public void register(String username) {
		byte points_user = 0;
		playerslist[0] = new Player(username, points_user, new Matrix());
		playerslist[1] = new Player(" MAQUINA ", points_user, new Matrix());
	}

	public ArrayList getlistboats(byte user) {
		return playerslist[user].getList();

	}

	public Player[] getplayerlist() {
		return playerslist;
	}

	/* metodos de player */
	public String getname(byte user) {
		return playerslist[user].getName();
	}

	public byte getpoins(byte user) {
		return playerslist[user].getPoints();
	}

	public Matrix getmatrix(byte user) {
		/* Validar que el índice del usuario esté dentro de los límites */
		if (user < 0 || user >= playerslist.length) {
			System.out.println("Usuario no válido");
			return null; // O lanzar una excepción, dependiendo de cómo quieras manejarlo
		}
		return playerslist[user].getMatrix();
	}

	/* metodos de speadboat */

	public boolean addboat1(byte user, byte x, byte y) {
		if ((x <= 10 && x > 0) && (y <= 10 && y > 0)) {
			x--;
			y--;
			/* parametros? */

			if (playerslist[user].getMatrix().getValue(x, y) == 0) {
				Speedboat speedboat = new Speedboat((byte) 0, " Lancha ");
				speedboat.Addboat1(playerslist[user].matrix, x, y); /* Llama al método addboat1 de Speedboat */
				/* aqui iba */
				playerslist[user].boats.add(speedboat);
				playerslist[user].matrix.getMatrix();
				while (true) {
					x = (byte) range.nextInt(10);
					y = (byte) range.nextInt(10);
					if (playerslist[(byte) 1].getMatrix().getValue(x, y) == 0) {
						Speedboat speedboat1 = new Speedboat((byte) 1, " LANCHA ");
						speedboat1.Addboat1(playerslist[(byte) 1].matrix, x, y);
						playerslist[(byte) 1].boats.add(speedboat1);

						return false;

					}
				}

			} else {

				return true;
			}
		} else {

			return true;
		}

	}

	public boolean addboat2(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {

			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 1) || (y1 - y2 == -1))) {
				x1--;
				y1--;
				y2--;
				if (playerslist[user].getMatrix().getValue(x1, y1) == 0
						&& playerslist[user].getMatrix().getValue(x1, y2) == 0) {

					Medicalship medicalship = new Medicalship((byte) 2, "Medico");

					medicalship.addboat2(playerslist[user].getMatrix(), x1, x2, y1, y2);
					playerslist[user].getList().add(medicalship);
					playerslist[user].matrix.getMatrix();
					while (true) {
						x1 = (byte) range.nextInt(9);
						y1 = (byte) range.nextInt(9);
						y2 = (byte) (y1 + 1);
						if (playerslist[(byte) 1].getMatrix().getValue(x1, y1) == 0
								&& playerslist[(byte) 1].getMatrix().getValue(x1, y2) == 0) {
							Medicalship medicalship1 = new Medicalship((byte) 2, " Medico ");
							medicalship1.addboat2(playerslist[(byte) 1].matrix, x1, x1, y1, y2);
							playerslist[(byte) 1].boats.add(medicalship1);

							return false;
						}

					}

				} else {

					return true;
				}

			} else {

				return true;
			}
		} else {

			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 1) || (x1 - x2 == -1))) {
				Medicalship medicalship = new Medicalship((byte) 2, " Medico ");
				x1--;
				x2--;
				y1--;
				if (playerslist[user].getMatrix().getValue(y1, x1) == 0
						&& playerslist[user].getMatrix().getValue(y1, x2) == 0) {

					medicalship.addboat2(playerslist[user].getMatrix(), y1, y1, x1, x2);
					playerslist[user].getList().add(medicalship);
					playerslist[user].matrix.getMatrix();
					while (true) {
						x1 = (byte) range.nextInt(9);
						x2 = (byte) (x1 + 1);
						y1 = (byte) range.nextInt(9);
						if (playerslist[user].matrix.getValue(x1, y1) == 0
								&& playerslist[user].matrix.getValue(x2, y1) == 0) {
							Medicalship medicalship1 = new Medicalship((byte) 2, " Medico ");
							medicalship1.addboat2(playerslist[(byte) 1].matrix, x1, x2, y1, y1);
							playerslist[(byte) 1].boats.add(medicalship1);

							return false;
						}

					}

				} else {

					return true;
				}

			} else {

				return true;
			}

		}

	}

	public boolean addboat3(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {
			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 2) || (y1 - y2 == -2))) {
				x1--;
				y1--;
				y2--;
				if ((playerslist[user].getMatrix().getValue(x1, y1) == 0
						&& playerslist[user].getMatrix().getValue(x1, y2) == 0)
						&& playerslist[user].getMatrix().getValue(x1, (byte) (y1 + 1)) == 0) {
					Strategicship strategicship = new Strategicship((byte) 3, " Municion ", vertical);
					for (byte a = y1; a <= y2; a++) {
						strategicship.addboat3(playerslist[user].matrix, x1, a);
					}

					playerslist[user].getList().add(strategicship);
					playerslist[user].matrix.getMatrix();
					while (true) {
						x1 = (byte) range.nextInt(8);
						y1 = (byte) range.nextInt(8);
						y2 = (byte) (y1 + 1);
						byte y3 = (byte) (y2 + 1);

						if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
								&& (playerslist[(byte) 1].matrix.getValue(x1, y2) == 0)
								&& (playerslist[(byte) 1].matrix.getValue(x1, y3) == 0)) {
							Strategicship strategicship1 = new Strategicship((byte) 3, " Municion ", vertical);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x1, y1);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x1, y2);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x1, y3);
							playerslist[(byte) 1].getList().add(strategicship1);
							return false;

						} else {
							return true;
						}

					}
				} else {
					return true;
				}

			} else {
				return true;

			}

		} else {
			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 2) || (x1 - x2 == -2))) {
				y1--;
				x1--;
				x2--;
				if ((playerslist[user].matrix.getValue(x1, y1) == 0
						&& playerslist[user].matrix.getValue(x2, y1) == 0)) {
					Strategicship strategicship = new Strategicship((byte) 3, " BARCO DE PROVICIONES ", vertical);
					for (byte a = x1; a <= x2; a++) {
						strategicship.addboat3(playerslist[user].matrix, a, y1);
					}

					playerslist[user].getList().add(strategicship);
					playerslist[user].matrix.getMatrix();
					while (true) {
						x1 = (byte) range.nextInt(8);
						x2 = (byte) (x1 + 1);
						byte x3 = (byte) (x2 + 1);
						y1 = (byte) range.nextInt(8);

						if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
								&& (playerslist[(byte) 1].matrix.getValue(x2, y1) == 0)
								&& (playerslist[(byte) 1].matrix.getValue(x3, y1) == 0)) {
							Strategicship strategicship1 = new Strategicship((byte) 3, " BA++rco de proviciones ",
									vertical);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x1, y1);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x2, y1);
							strategicship1.addboat3(playerslist[(byte) 1].matrix, x3, y1);
							playerslist[(byte) 1].getList().add(strategicship1);

							return false;

						} else {
							return true;
						}

					}

				} else {
					return true;
				}
			} else {
				return true;
			}

		}

	}

	public boolean addboat4(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {
			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 3) || (y1 - y2 == -3))) {
				x1--;
				y1--;
				y2--;
				// Verificar que todas las posiciones estén libres
				if (y1 < y2) {
					for (byte y = y1; y <= y2; y++) {
						if (playerslist[user].getMatrix().getValue(x1, y) != 0) {
							return true; // Posición ocupada
						}
					}
				} else {
					for (byte y = y2; y <= y1; y++) {
						if (playerslist[user].getMatrix().getValue(x1, y) != 0) {
							return true; // Posición ocupada
						}
					}
				}

				// Añadir el barco
				Warship warship = new Warship((byte) 4, " Barco de Guerra ", vertical);

				if (y1 < y2) {
					for (byte y = y1; y <= y2; y++) {
						warship.addboat4(playerslist[user].matrix, x1, y);
					}
				} else {
					for (byte y = y2; y <= y1; y++) {
						warship.addboat4(playerslist[user].matrix, x1, y);
					}
				}

				playerslist[user].getList().add(warship);
				playerslist[user].matrix.getMatrix();

				// Añadir barco para la máquina
				while (true) {
					x1 = (byte) range.nextInt(7);
					y1 = (byte) range.nextInt(7);
					byte y3 = (byte) (y1 + 1);
					byte y4 = (byte) (y3 + 1);
					byte y5 = (byte) (y4 + 1);

					if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y3) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y4) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y5) == 0)) {
						Warship warship1 = new Warship((byte) 4, " Barco de Guerra ", vertical);
						warship1.addboat4(playerslist[(byte) 1].matrix, x1, y1);
						warship1.addboat4(playerslist[(byte) 1].matrix, x1, y3);
						warship1.addboat4(playerslist[(byte) 1].matrix, x1, y4);
						warship1.addboat4(playerslist[(byte) 1].matrix, x1, y5);
						playerslist[(byte) 1].getList().add(warship1);
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			// Caso horizontal
			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 3) || (x1 - x2 == -3))) {
				y1--;
				x1--;
				x2--;

				// Verificar que todas las posiciones estén libres
				if (x1 < x2) {
					for (byte x = x1; x <= x2; x++) {
						if (playerslist[user].matrix.getValue(x, y1) != 0) {
							return true; // Posición ocupada
						}
					}
				} else {
					for (byte x = x2; x <= x1; x++) {
						if (playerslist[user].matrix.getValue(x, y1) != 0) {
							return true; // Posición ocupada
						}
					}
				}

				// Añadir el barco
				Warship warship = new Warship((byte) 4, " Barco de Guerra ", vertical);

				if (x1 < x2) {
					for (byte x = x1; x <= x2; x++) {
						warship.addboat4(playerslist[user].matrix, x, y1);
					}
				} else {
					for (byte x = x2; x <= x1; x++) {
						warship.addboat4(playerslist[user].matrix, x, y1);
					}
				}

				playerslist[user].getList().add(warship);
				playerslist[user].matrix.getMatrix();

				// Añadir barco para la máquina
				while (true) {
					x1 = (byte) range.nextInt(7);
					byte x3 = (byte) (x1 + 1);
					byte x4 = (byte) (x3 + 1);
					byte x5 = (byte) (x4 + 1);
					y1 = (byte) range.nextInt(7);

					if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x3, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x4, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x5, y1) == 0)) {
						Warship warship1 = new Warship((byte) 4, " Barco de Guerra ", vertical);
						warship1.addboat4(playerslist[(byte) 1].matrix, x1, y1);
						warship1.addboat4(playerslist[(byte) 1].matrix, x3, y1);
						warship1.addboat4(playerslist[(byte) 1].matrix, x4, y1);
						warship1.addboat4(playerslist[(byte) 1].matrix, x5, y1);
						playerslist[(byte) 1].getList().add(warship1);
						return false;
					}
				}
			} else {
				return true;
			}
		}
	}

	public boolean addboat5(byte user, byte x1, byte x2, byte y1, byte y2, boolean vertical) {
		if (vertical == true) {
			if (((x1 <= 10 && x1 > 0) && (y1 <= 10 && y1 > 0) && (y2 <= 10 && y2 > 0))
					&& ((y1 - y2 == 4) || (y1 - y2 == -4))) {
				x1--;
				y1--;
				y2--;

				// Verificar que todas las posiciones estén libres
				if (y1 < y2) {
					for (byte y = y1; y <= y2; y++) {
						if (playerslist[user].getMatrix().getValue(x1, y) != 0) {
							return true; // Posición ocupada
						}
					}
				} else {
					for (byte y = y2; y <= y1; y++) {
						if (playerslist[user].getMatrix().getValue(x1, y) != 0) {
							return true; // Posición ocupada
						}
					}
				}

				// Añadir el barco
				Stepwife stepwife = new Stepwife((byte) 5, " Barco Stepwife ", vertical);

				if (y1 < y2) {
					for (byte y = y1; y <= y2; y++) {
						stepwife.addboat5(playerslist[user].matrix, x1, y);
					}
				} else {
					for (byte y = y2; y <= y1; y++) {
						stepwife.addboat5(playerslist[user].matrix, x1, y);
					}
				}

				playerslist[user].getList().add(stepwife);
				playerslist[user].matrix.getMatrix();

				// Añadir barco para la máquina
				while (true) {
					x1 = (byte) range.nextInt(6);
					y1 = (byte) range.nextInt(6);
					byte y3 = (byte) (y1 + 1);
					byte y4 = (byte) (y3 + 1);
					byte y5 = (byte) (y4 + 1);
					byte y6 = (byte) (y5 + 1);

					if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y3) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y4) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y5) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x1, y6) == 0)) {
						Stepwife stepwife1 = new Stepwife((byte) 5, " Barco Stepwife ", vertical);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y1);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y3);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y4);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y5);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y6);
						playerslist[(byte) 1].getList().add(stepwife1);
						return false;
					}
				}
			} else {
				return true;
			}
		} else {
			// Caso horizontal
			if (((y1 <= 10 && y1 > 0) && (x1 <= 10 && x1 > 0) && (x2 <= 10 && x2 > 0))
					&& ((x1 - x2 == 4) || (x1 - x2 == -4))) {
				y1--;
				x1--;
				x2--;

				// Verificar que todas las posiciones estén libres
				if (x1 < x2) {
					for (byte x = x1; x <= x2; x++) {
						if (playerslist[user].matrix.getValue(x, y1) != 0) {
							return true; // Posición ocupada
						}
					}
				} else {
					for (byte x = x2; x <= x1; x++) {
						if (playerslist[user].matrix.getValue(x, y1) != 0) {
							return true; // Posición ocupada
						}
					}
				}

				// Añadir el barco
				Stepwife stepwife = new Stepwife((byte) 5, " Barco Stepwife ", vertical);

				if (x1 < x2) {
					for (byte x = x1; x <= x2; x++) {
						stepwife.addboat5(playerslist[user].matrix, x, y1);
					}
				} else {
					for (byte x = x2; x <= x1; x++) {
						stepwife.addboat5(playerslist[user].matrix, x, y1);
					}
				}

				playerslist[user].getList().add(stepwife);
				playerslist[user].matrix.getMatrix();

				// Añadir barco para la máquina
				while (true) {
					x1 = (byte) range.nextInt(6);
					byte x3 = (byte) (x1 + 1);
					byte x4 = (byte) (x3 + 1);
					byte x5 = (byte) (x4 + 1);
					byte x6 = (byte) (x5 + 1);
					y1 = (byte) range.nextInt(6);

					if ((playerslist[(byte) 1].matrix.getValue(x1, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x3, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x4, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x5, y1) == 0)
							&& (playerslist[(byte) 1].matrix.getValue(x6, y1) == 0)) {
						Stepwife stepwife1 = new Stepwife((byte) 5, " Barco Stepwife ", vertical);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x1, y1);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x3, y1);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x4, y1);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x5, y1);
						stepwife1.addboat5(playerslist[(byte) 1].matrix, x6, y1);
						playerslist[(byte) 1].getList().add(stepwife1);
						return false;
					}
				}
			} else {
				return true;
			}
		}
	}

	public EstadoAtaque atack(byte user, byte x, byte y) {
		if (user == 0) {
			x--;
			y--;
			for (Boat boat : playerslist[1].getList()) {
				for (byte a = 0; a < boat.getX().size(); a++) {
					byte x1 = boat.getX().get(a);
					byte y1 = boat.getY().get(a);

					// ✅ Si las coordenadas del disparo coinciden con una parte del barco
					if (x1 == x && y1 == y) {
						byte valorActual = playerslist[1].matrix.getValue(x1, y1);

						if (valorActual == 0) {
							return EstadoAtaque.AGUA;
						} else if (valorActual == 1) {
							// Cambia el valor de 1 ➝ 2 (golpeado)
							playerslist[1].matrix.addBoat1(x1, y1);

							// Verifica si todas las partes del barco están golpeadas
							boolean todosSonDos = true;
							for (byte b = 0; b < boat.getX().size(); b++) {
								byte x2 = boat.getX().get(b);
								byte y2 = boat.getY().get(b);
								if (playerslist[1].matrix.getValue(x2, y2) != 2) {
									todosSonDos = false;
									break;
								}
							}

							if (todosSonDos) {
								// Cambia todas las partes de 2 ➝ 3 (hundido visualmente)
								for (byte b = 0; b < boat.getX().size(); b++) {
									byte x2 = boat.getX().get(b);
									byte y2 = boat.getY().get(b);
									playerslist[1].matrix.addBoat1(x2, y2);
								}

								playerslist[1].removeBoat(boat);
								return EstadoAtaque.HUNDIDO;
							}

							return EstadoAtaque.GOLPE;
						}

						return EstadoAtaque.YA_ATACADO;
					}
				}
			}
		} else {
			byte xm = (byte) range.nextInt(10);
			byte ym = (byte) range.nextInt(10);
			// Imprimir las coordenadas de ataque de la máquina
			System.out.println("La máquina " + getcoordenadas(xm, ym));

			for (Boat boat : playerslist[0].getList()) {
				for (byte a = 0; a < boat.getX().size(); a++) {
					byte x1 = boat.getX().get(a);
					byte y1 = boat.getY().get(a);

					// ✅ Si las coordenadas del disparo coinciden con una parte del barco
					if (x1 == xm && y1 == ym) {
						byte valorActual = playerslist[0].matrix.getValue(x1, y1);

						if (valorActual == 0) {
							return EstadoAtaque.AGUA;
						} else if (valorActual == 1) {
							// Cambia el valor de 1 ➝ 2 (golpeado)
							playerslist[0].getMatrix().addBoat1(x1, y1);

							// Verifica si todas las partes del barco están golpeadas
							boolean todosSonDos = true;
							for (byte b = 0; b < boat.getX().size(); b++) {
								byte x2 = boat.getX().get(b);
								byte y2 = boat.getY().get(b);
								if (playerslist[1].matrix.getValue(x2, y2) != 2) {
									todosSonDos = false;
									break;
								}
							}

							if (todosSonDos) {
								// Cambia todas las partes de 2 ➝ 3 (hundido visualmente)
								for (byte b = 0; b < boat.getX().size(); b++) {
									byte x2 = boat.getX().get(b);
									byte y2 = boat.getY().get(b);
									playerslist[0].matrix.addBoat1(x2, y2);
								}

								playerslist[0].removeBoat(boat);
								return EstadoAtaque.HUNDIDO;
							}

							return EstadoAtaque.GOLPE;
						}

						return EstadoAtaque.YA_ATACADO;
					}
				}
			}

		}

		// Si no encontró coincidencia con ningún barco
		return EstadoAtaque.AGUA;

	}

	public String getcoordenadas(byte x, byte y) {
		String coordenada = "ataco la coordenada " + (x + 1) + "," + (y + 1);
		return coordenada;
	}

	/* metodos matrix */
	public byte getvalue(byte x, byte y) {
		return playerslist[0].getMatrix().getValue(x, y);

	}

	public Byte getWinner() {
		if (playerslist[0].getList().isEmpty())
			return 1;
		if (playerslist[1].getList().isEmpty())
			return 0;
		return null; // No hay ganador aún
	}

	public boolean winner() {
		// Devuelve true si ambos tienen barcos (el juego continúa)
		return !(playerslist[0].getList().isEmpty() || playerslist[1].getList().isEmpty());
	}

	public void addPointToWinner(byte winner) {
		if (winner == 0 || winner == 1) {
			playerslist[winner].addPoint();
		}
	}

}