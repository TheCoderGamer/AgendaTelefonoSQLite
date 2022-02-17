import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Agenda {

	Connection con;
	
	public Agenda(Connection con) throws SQLException {
		this.con = con;
		Statement st = con.createStatement();
		st.executeUpdate("CREATE TABLE IF NOT EXISTS agenda(usuario VARCHAR, nombre VARCHAR, telefono VARCHAR)");
	}	
	
	// ----- LISTAR -----
	public void ListContacts(){
		System.out.println("------ LISTA ------");
		try {
			String sql = "SELECT * FROM agenda";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.printf("%s %s %s %n",rs.getString(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ----- AÑADIR -----
	public Boolean AddUser(String usuario, String nombre, String telefono) {
		try {
			String sql = "INSERT INTO agenda VALUES (?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, usuario);
			st.setString(2, nombre);
			st.setString(3, telefono);
			st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
		return true;
	}

	// ----- OBTENER -----
    public String GetName(String user) {
		try {
			return Select("nombre", user);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

    public String GetTel(String user) {
        try {
			return Select("telefono", user);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }

	private String Select(String selection, String user) throws SQLException {
		String sql = "SELECT "+ selection + " FROM agenda WHERE usuario = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, user);
		ResultSet rs = st.executeQuery(sql);
		String result = rs.getString(1);
		rs.close();
		st.close();
		return result;
	}

	// ----- MODIFICAR -----
    public Boolean ModifyUsername(String oldUser, String newUser) {
        try {
			Modify("usuario", oldUser, newUser);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
    public Boolean ModifyName(String user, String nombre) {
		try {
			Modify("nombre", user, nombre);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
    public Boolean ModifyTel(String user, String telefono) {
		try {
			Modify("telefono", user, telefono);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
	private void Modify(String type, String user, String newData) throws SQLException {
		String sql = "UPDATE agenda SET "+ type + " = ? WHERE usuario = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, newData);
		st.setString(2, user);
		st.executeUpdate(sql);
		st.close();
	}
	
	// ----- ELIMINAR -----
    public Boolean RemoveUser(String user) {
        try {
			String sql = "DELETE FROM agenda WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);
			st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }
}
