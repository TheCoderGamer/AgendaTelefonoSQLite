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


    public String GetName(String user) {
		try {
			String sql = "SELECT nombre FROM agenda WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);
			ResultSet rs = st.executeQuery(sql);
			String name = rs.getString(1);
			rs.close();
			st.close();
			return name;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }


    public String GetTel(String user) {
        try {
			String sql = "SELECT telefono FROM agenda WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user);
			ResultSet rs = st.executeQuery(sql);
			String tel = rs.getString(1);
			rs.close();
			st.close();
			return tel;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }


    public Boolean ModifyUsername(String oldUser, String newUser) {
        try {
			String sql = "UPDATE agenda SET usuario = ? WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, newUser);
			st.setString(2, oldUser);
			st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }


    public Boolean ModifyName(String user, String nombre) {
        try {
			String sql = "UPDATE agenda SET nombre = ? WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, user);
			st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }


    public Boolean ModifyTel(String user, String telefono) {
        try {
			String sql = "UPDATE agenda SET telefono = ? WHERE usuario = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, telefono);
			st.setString(2, user);
			st.executeUpdate(sql);
			st.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
    }


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
