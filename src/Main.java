import java.io.FileInputStream;
import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class Main {
	private static String dsn = null;
	private static Agenda agenda;
	private static Connection con;	
	
	public static void main(String[] args) {
		Init();

		new UI(agenda);
		
		Close();
	}
	
	private static void Init(){
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("config.ini"));
			dsn = props.getProperty("dsn");

			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(dsn);
			agenda = new Agenda(con);
		}
		catch (Exception e) {
			System.err.println("Error al iniciar la conexion con la base de datos");
			e.printStackTrace();
		}
	}
	
	private static void Close(){
		try {
			con.close();
		} 
		catch (Exception e) {
			System.err.println("Error al cerrar el programa");
			e.printStackTrace();
		}
	}
}
