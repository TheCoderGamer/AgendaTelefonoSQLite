package io;

import java.util.Scanner;

/**
 * <p>
 * Clase estática para leer de teclado con comprobación de tipo de datos y
 * escribir en pantalla.
 * </p>
 * 
 * <p>
 * <b>USO EDUCATIVO</b>
 * </p>
 * 
 * <p>
 * Los tipos de dato que maneja son:
 * </p>
 * 
 * <ul>
 * <li>entero (int)
 * <li>decimal (double)
 * <li>caracter (char)
 * <li>byte
 * <li>short
 * <li>int
 * <li>long
 * <li>float
 * <li>double
 * <li>boolean (true, false)
 * <li>char
 * <li>String (admite tira vacía)
 * </ul>
 * 
 * @author Amadeo & TheCo
 * @version 1.0
 * @since 2018-07-01
 */
public class IO {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor
	 */
	IO() {
		sc.useDelimiter("\n");
	}

	/**
	 * Pausa el programa
	 */
	static public void pause() {
		sc.nextLine();
	}
	
	/**
	 * Muestra un objeto
	 * 
	 * @param o
	 * Objeto a mostrar
	 */
	static public void print(Object o) {
		System.out.print(o);
	}

	/**
	 * Muestra un objeto y salta de linea
	 * 
	 * @param o
	 * Objeto a mostrar
	 */
	static public void println(Object o) {
		System.out.println(o);
	}

	/**
	 * Lee un byte
	 * @return byte
	 */
	static public byte readByte() {
		while (true) {
			try {
				return Byte.parseByte(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo byte $ ");
			}
		}
	}
	static public byte readByte(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Byte.parseByte(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo byte $ ");
			}
		}
	}

	/**
	 * Lee un short
	 * @return short
	 */
	static public short readShort() {
		while (true) {
			try {
				return Short.parseShort(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo short $ ");
			}
		}
	}
	static public short readShort(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Short.parseShort(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo short $ ");
			}
		}
	}

	/**
	 * Lee un int
	 * @return int
	 */
	static public int readInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo int $ ");
			}
		}
	}
	static public int readInt(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo int $ ");
			}
		}
	}

	/**
	 * Lee un long
	 * @return long
	 */
	static public long readLong() {
		while (true) {
			try {
				return Long.parseLong(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo long $ ");
			}
		}
	}
	static public long readLong(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Long.parseLong(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo long $ ");
			}
		}
	}

	/**
	 * Lee un float
	 * @return float
	 */
	static public float readFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo float $ ");
			}
		}
	}
	static public float readFloat(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo float $ ");
			}
		}
	}

	/**
	 * Lee un double
	 * @return double
	 */
	static public double readDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo double $ ");
			}
		}
	}
	static public double readDouble(String message) {
		System.out.print(message);
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Error: Valor introducido no es tipo double $ ");
			}
		}
	}

	/**
	 * Lee un boolean
	 * @return Boolean (true/false)
	 */
	static public boolean readBoolean() {
		while (true) {
			switch (sc.nextLine()) {
			case "true":
				return true;
			case "false":
				return false;
			default:
				System.err.print("Error: Valor introducido no es tipo bool $ ");
			}
		}
	}
	static public boolean readBoolean(String message) {
		System.out.print(message);
		while (true) {
			switch (sc.nextLine()) {
			case "true":
				return true;
			case "false":
				return false;
			default:
				System.err.print("Error: Valor introducido no es tipo bool $ ");
			}
		}
	}

	/**
	 * Lee un caracter
	 * @return Char
	 */
	static public char readChar() {
		while (true) {
			String s = sc.nextLine();
			if (s.length() == 1) {
				return s.toCharArray()[0];
			}
			System.err.print("Error: Valor introducido no es tipo char $ ");
		}
	}
	static public char readChar(String message) {
		System.out.print(message);
		while (true) {
			String s = sc.nextLine();
			if (s.length() == 1) {
				return s.toCharArray()[0];
			}
			System.err.print("Error: Valor introducido no es tipo char $ ");
		}
	}


	/**
	 * Lee un String
	 * @return String
	 */
	static public String readString() {
		return sc.nextLine();
	}
	static public String readString(String message) {
		System.out.print(message);
		return sc.nextLine();
	}
}
