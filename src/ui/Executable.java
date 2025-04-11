package ui; /*  Asegúrate de que esta línea esté presente */

import java.util.Scanner;
import model.Controller;
import model.EstadoAtaque;

public class Executable {
	private static final Controller controller = new Controller();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		System.out.println("Ingresa tu nombre de usuario: ");
		String username = input.nextLine();
		controller.register(username);
		System.out.println("Usuario registrado: " + username);
		do {
			System.out.println(controller.getname((byte) 0) + " Bienvenid@ a Battleship\n");
			System.out.println("Elije una de las siguientes opciones\n");
			System.out.println("(1). Jugar");
			System.out.println("(2). Salir");
			byte option = input.nextByte();
			/* clear buffer */
			input.nextLine();
			switch (option) {
				case 1:

					byte option2;
					System.out.println("ELIJE EL MODO DE JUEGO \n (1). estandar \n (2). personalizado ");
					option2 = input.nextByte();
					switch (option2) {
						case 1:
							while (true) {

								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco tipo lancha");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x1 = input.nextByte();
								System.out.println("ingresa la coordenada Y o el numero de la fila");
								byte y1 = input.nextByte();

								if (!controller.addboat1((byte) 0, x1, y1)) {
									System.out.println("\n barco añadido con exito \n");
									System.out.println("tu lista de barcos es " + controller.getlistboats((byte) 0));
									break;
								} else {
									System.out.println(" \n coordenada invalida intentalo de nuevo \n ");
								}

							}
							/* barco medico */

							while (true) {

								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco tipo Medico (vertical, 2 unidades)");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x1 = input.nextByte();
								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira una de las partes del barco");
								byte y1 = input.nextByte();
								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y2 = input.nextByte();
								if (!controller.addboat2((byte) 0, x1, (byte) 0, y1, y2, true)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;
								} else {
									System.out.println("\n coordenada invalida \n ");
								}

							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco de proviciones (horizontal) ");
								System.out.println(
										"ingresa la coordenada X donde ira una  de las 2 puntas del barcos  el numero de la columna");
								byte x1 = input.nextByte();

								System.out.println(
										"ingresa la coordenada X donde ira la otra punta  el numero de la columna");
								byte x2 = input.nextByte();

								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y1 = input.nextByte();

								if (!controller.addboat3((byte) 0, x1, x2, y1, y1, false)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;

								} else {
									System.out.println("Coordenada invalida");
								}

							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco de Municiones (vertical) ");
								System.out.println(
										"ingresa la coordenada X o el numero de la columna donde estara ubicado el barco");
								byte x1 = input.nextByte();

								System.out.println("ingresa la coordenada Y donde estara una de las puntas del barco ");
								byte y1 = input.nextByte();

								System.out.println(
										"ingresa la coordenada Y o el numero de la fila donde ira la otra parte del barco");
								byte y2 = input.nextByte();

								if (!controller.addboat3((byte) 0, x1, x1, y1, y2, true)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;

								} else {
									System.out.println("Coordenada invalida");
								}

							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El Barco de Guerra (vertical, 4 unidades)");
								System.out.println("ingresa la coordenada X o el numero de la columna");
								byte x1 = input.nextByte();

								System.out.println("ingresa la coordenada Y donde estara una de las puntas del barco");
								byte y1 = input.nextByte();

								System.out.println("ingresa la coordenada Y donde estara la otra punta del barco");
								byte y2 = input.nextByte();

								if (!controller.addboat4((byte) 0, x1, x1, y1, y2, true)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;
								} else {
									System.out.println("Coordenada invalida");
								}
							}

							// También podría agregar la opción horizontal como lo tiene para otros barcos
							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El Barco de Guerra (horizontal, 4 unidades)");
								System.out.println("ingresa la coordenada X donde estara una de las puntas del barco");
								byte x1 = input.nextByte();

								System.out.println("ingresa la coordenada X donde estara la otra punta del barco");
								byte x2 = input.nextByte();

								System.out.println("ingresa la coordenada Y o el numero de la fila");
								byte y1 = input.nextByte();

								if (!controller.addboat4((byte) 0, x1, x2, y1, y1, false)) {
									System.out.println(" \n barco añadido con exito \n ");
									break;
								} else {
									System.out.println("Coordenada invalida");
								}
							}

							while (true) {
								System.out.println(controller.getname((byte) 0)
										+ " ingresa las coordenadas para ubicar El barco de 5 unidades (vertical)");
								System.out.println("Ingresa la coordenada X o el número de la columna (1-10):");
								byte x1 = input.nextByte();
								System.out.println(
										"Ingresa la coordenada Y o el número de la fila (1-10) donde ira una de las:");
								byte y1 = input.nextByte();
								System.out.println(
										"Ingresa la coordenada Y o el número de la fila (1-10) donde ira la otra punta");
								byte y2 = input.nextByte();

								// Llamar al método para añadir el barco
								if (!controller.addboat5((byte) 0, x1, x1, y1, y2, true)) {
									System.out.println(" \n Barco añadido con éxito \n ");
									System.out.println("Tu lista de barcos es: " + controller.getlistboats((byte) 0));
									break; // Salir del bucle si el barco se añade correctamente
								} else {
									System.out.println(" \n Coordenada inválida, intenta de nuevo \n ");
								}
							}

							System.out.println(" empieza el juego");
							while (true) {
								System.out.println(" ingresa la coordenada X que deseas atacar ");
								byte xa = input.nextByte();
								System.out.println(" ingresa la coordenada y que deseas atacar");
								byte ya = input.nextByte();
								EstadoAtaque estadoAtaqueUsuario = controller.atack((byte) 0, xa, ya);
								System.out.println("Resultado de tu ataque: " + estadoAtaqueUsuario);

								Byte ganador = controller.getWinner();

								if (ganador != null) {
									if (ganador == 0) {
										System.out.println("¡Felicidades, has ganado!");
										System.out.print(" tienes  ");
										controller.addPointToWinner((byte) 0);
										System.out.print(" puntos");
										break;
									} else if (ganador == 1) {
										System.out.println("La máquina ha ganado.");
										System.out.print(" tienes  ");
										controller.addPointToWinner((byte) 0);
										System.out.print(" puntos");
										System.out.println("");
										System.out.print("la maquina tiene ");
										controller.addPointToWinner((byte) 0);
										System.out.print(" puntos");

										break;
									}
								}

								// La máquina ataca automáticamente en el método atack
								EstadoAtaque estadoAtaqueMaquina = controller.atack((byte) 1, (byte) 0, (byte) 0);
								System.out.println("Resultado del ataque de la máquina: " + estadoAtaqueMaquina);

								ganador = controller.getWinner();

								if (ganador != null) {
									if (ganador == 0) {
										System.out.println("¡Felicidades, has ganado!");
										break;
									} else if (ganador == 1) {
										System.out.println("La máquina ha ganado.");
										break;
									}
								}
							}
							break;

						case 2:
							// Aquí iría el código para el modo personalizad
							// Modo personalizado
							System.out.println("Modo personalizado - Elige el número de barcos (máximo 10):");
							byte numBarcos = input.nextByte();
							if (numBarcos < 1 || numBarcos > 10) {
								System.out.println("Número inválido. Se configurará a un máximo de 10 barcos.");
								numBarcos = 10;
							}

							byte barcosAgregados = 0;
							while (barcosAgregados < numBarcos) {
								System.out.println("\nBarco #" + (barcosAgregados + 1) + " de " + numBarcos);
								System.out.println("Selecciona el tipo de barco:");
								System.out.println("1. Lancha (1 casilla)");
								System.out.println("2. Barco Médico (2 casillas)");
								System.out.println("3. Barco de Municiones/Provisiones (3 casillas)");
								System.out.println("4. Barco de Guerra (4 casillas)");
								System.out.println("5. Barco Stepwife (5 casillas)");
								byte tipoBarco = input.nextByte();

								if (tipoBarco < 1 || tipoBarco > 5) {
									System.out
											.println("Tipo de barco inválido. Por favor selecciona una opción válida.");
									continue;
								}

								boolean posicionValida = false;

								// Para barcos que no son lanchas, preguntar por orientación
								if (tipoBarco > 1) {
									System.out.println("¿Orientación del barco?");
									System.out.println("1. Vertical");
									System.out.println("2. Horizontal");
									byte orientacion = input.nextByte();
									boolean vertical = (orientacion == 1);

									switch (tipoBarco) {
										case 2: // Barco Médico
											while (!posicionValida) {
												if (vertical) {
													System.out.println("Ingresa coordenada X (columna):");
													byte x = input.nextByte();
													System.out.println("Ingresa coordenada Y inicial (fila):");
													byte y1 = input.nextByte();
													System.out.println("Ingresa coordenada Y final (fila):");
													byte y2 = input.nextByte();

													posicionValida = !controller.addboat2((byte) 0, x, (byte) 0, y1, y2,
															true);
												} else {
													System.out.println("Ingresa coordenada X inicial (columna):");
													byte x1 = input.nextByte();
													System.out.println("Ingresa coordenada X final (columna):");
													byte x2 = input.nextByte();
													System.out.println("Ingresa coordenada Y (fila):");
													byte y = input.nextByte();

													posicionValida = !controller.addboat2((byte) 0, x1, x2, y, y,
															false);
												}

												if (!posicionValida) {
													System.out.println("Posición inválida. Intenta de nuevo.");
												} else {
													System.out.println("Barco médico añadido correctamente.");
													barcosAgregados++;
												}
											}
											break;

										case 3: // Barco de Municiones/Provisiones
											while (!posicionValida) {
												if (vertical) {
													System.out.println("Ingresa coordenada X (columna):");
													byte x = input.nextByte();
													System.out.println("Ingresa coordenada Y inicial (fila):");
													byte y1 = input.nextByte();
													System.out.println("Ingresa coordenada Y final (fila):");
													byte y2 = input.nextByte();

													posicionValida = !controller.addboat3((byte) 0, x, x, y1, y2, true);
												} else {
													System.out.println("Ingresa coordenada X inicial (columna):");
													byte x1 = input.nextByte();
													System.out.println("Ingresa coordenada X final (columna):");
													byte x2 = input.nextByte();
													System.out.println("Ingresa coordenada Y (fila):");
													byte y = input.nextByte();

													posicionValida = !controller.addboat3((byte) 0, x1, x2, y, y,
															false);
												}

												if (!posicionValida) {
													System.out.println("Posición inválida. Intenta de nuevo.");
												} else {
													System.out.println(
															"Barco de municiones/provisiones añadido correctamente.");
													barcosAgregados++;
												}
											}
											break;

										case 4: // Barco de Guerra
											while (!posicionValida) {
												if (vertical) {
													System.out.println("Ingresa coordenada X (columna):");
													byte x = input.nextByte();
													System.out.println("Ingresa coordenada Y inicial (fila):");
													byte y1 = input.nextByte();
													System.out.println("Ingresa coordenada Y final (fila):");
													byte y2 = input.nextByte();

													posicionValida = !controller.addboat4((byte) 0, x, x, y1, y2, true);
												} else {
													System.out.println("Ingresa coordenada X inicial (columna):");
													byte x1 = input.nextByte();
													System.out.println("Ingresa coordenada X final (columna):");
													byte x2 = input.nextByte();
													System.out.println("Ingresa coordenada Y (fila):");
													byte y = input.nextByte();

													posicionValida = !controller.addboat4((byte) 0, x1, x2, y, y,
															false);
												}

												if (!posicionValida) {
													System.out.println("Posición inválida. Intenta de nuevo.");
												} else {
													System.out.println("Barco de guerra añadido correctamente.");
													barcosAgregados++;
												}
											}
											break;

										case 5: // Barco Stepwife
											while (!posicionValida) {
												if (vertical) {
													System.out.println("Ingresa coordenada X (columna):");
													byte x = input.nextByte();
													System.out.println("Ingresa coordenada Y inicial (fila):");
													byte y1 = input.nextByte();
													System.out.println("Ingresa coordenada Y final (fila):");
													byte y2 = input.nextByte();

													posicionValida = !controller.addboat5((byte) 0, x, x, y1, y2, true);
												} else {
													System.out.println("Ingresa coordenada X inicial (columna):");
													byte x1 = input.nextByte();
													System.out.println("Ingresa coordenada X final (columna):");
													byte x2 = input.nextByte();
													System.out.println("Ingresa coordenada Y (fila):");
													byte y = input.nextByte();

													posicionValida = !controller.addboat5((byte) 0, x1, x2, y, y,
															false);
												}

												if (!posicionValida) {
													System.out.println("Posición inválida. Intenta de nuevo.");
												} else {
													System.out.println("Barco Stepwife añadido correctamente.");
													barcosAgregados++;
												}
											}
											break;
									}
								} else { // Lancha (tamaño 1)
									while (!posicionValida) {
										System.out.println("Ingresa coordenada X (columna):");
										byte x = input.nextByte();
										System.out.println("Ingresa coordenada Y (fila):");
										byte y = input.nextByte();

										posicionValida = !controller.addboat1((byte) 0, x, y);

										if (!posicionValida) {
											System.out.println("Posición inválida. Intenta de nuevo.");
										} else {
											System.out.println("Lancha añadida correctamente.");
											barcosAgregados++;
										}
									}
								}
							}

							// Inicia el juego después de colocar todos los barcos
							System.out.println("¡Todos los barcos colocados! Comienza el juego.");

							// Bucle de juego igual que en modo estándar
							while (true) {
								System.out.println(" ingresa la coordenada X que deseas atacar ");
								byte xa = input.nextByte();
								System.out.println(" ingresa la coordenada y que deseas atacar");
								byte ya = input.nextByte();
								EstadoAtaque estadoAtaqueUsuario = controller.atack((byte) 0, xa, ya);
								System.out.println("Resultado de tu ataque: " + estadoAtaqueUsuario);

								Byte ganador = controller.getWinner();

								if (ganador != null) {
									if (ganador == 0) {
										System.out.println("¡Felicidades, has ganado!");
										controller.addPointToWinner((byte) 0);
										System.out.println("Tienes " + controller.getpoins((byte) 0) + " puntos");
										break;
									} else if (ganador == 1) {
										System.out.println("La máquina ha ganado.");
										controller.addPointToWinner((byte) 1);
										System.out.println("Tienes " + controller.getpoins((byte) 0) + " puntos");
										System.out.println(
												"La máquina tiene " + controller.getpoins((byte) 1) + " puntos");
										break;
									}
								}

								// La máquina ataca automáticamente en el método atack
								EstadoAtaque estadoAtaqueMaquina = controller.atack((byte) 1, (byte) 0, (byte) 0);
								System.out.println("Resultado del ataque de la máquina: " + estadoAtaqueMaquina);

								ganador = controller.getWinner();

								if (ganador != null) {
									if (ganador == 0) {
										System.out.println("¡Felicidades, has ganado!");
										controller.addPointToWinner((byte) 0);
										System.out.println("Tienes " + controller.getpoins((byte) 0) + " puntos");
										break;
									} else if (ganador == 1) {
										System.out.println("La máquina ha ganado.");
										controller.addPointToWinner((byte) 1);
										System.out.println("Tienes " + controller.getpoins((byte) 0) + " puntos");
										System.out.println(
												"La máquina tiene " + controller.getpoins((byte) 1) + " puntos");
										break;
									}
								}
							}
							break;

						default:
							System.out.println("Opción no válida");
					}
					break;
				case 2:
					run = false; // Cambia run a false para salir del bucle
					break;
				default:
					System.out.println("Opción no válida. Intenta de nuevo.");
			}

		} while (run);
		System.out.println("¡Gracias por jugar!");
		input.close();
	}
}