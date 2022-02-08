import io.IO;

public class UI {

    private Agenda agenda;


    public UI(Agenda agenda) {
        this.agenda = agenda;
        Inicio();
    }


    private String RequestInput(){
		String input = IO.readString().trim();
		input.substring(0, Math.min(20,input.length()));
		return input;
	}
	
	private void Inicio() {
		Boolean repeat = true;
		while(repeat){
			int option = 0;
			System.out.println("---- AGENDA TELEFONICA ----");
			System.out.println("Elige una opcion:");
			System.out.println("1: Listar todo");
			System.out.println("2: Añadir contacto");
			System.out.println("3: Modificar contacto");
			System.out.println("4: Borrar contacto");
			System.out.println("5: Salir");
			option = IO.readInt();
			
			switch (option){
				case 1:
				ListarTodo();
				break;
				case 2:
				AñadirContacto();
				break;
				case 3:
				ModificarContacto();
				break;
				case 4:
				BorrarContacto();
				break;
				case 5:
				repeat = false;
				break;
				default:
				System.out.println("Opcion no correcta");
				repeat = true;
			}
		}
	}
	
	private void ListarTodo() {
        agenda.ListContacts();
	}
	
	private void AñadirContacto() {
		while(true){
			System.out.println("----- AÑADIR CONTACTO -----");
			System.out.println("Introduce los siguientes datos");
			System.out.println("Usuario:");
			String usuario = RequestInput();
			System.out.println("Nombre:");
			String nombre = RequestInput();
			System.out.println("Telefono:");
			String telefono = RequestInput();
			
			Boolean done = agenda.AddUser(usuario, nombre, telefono);
			if (done){return;}
			
			System.out.println("Error al crear el usuario");
			System.out.println("Reintentar?");
			Boolean reintentar = IO.readBoolean();
			if (!reintentar){return;}
		}
		
	}
	
	

	private void ModificarContacto() {
		System.out.println("----- MODIFICAR CONTACTO -----");
		System.out.println("Introduce el usuario del contacto a modificar:");
		
		String oldUser = RequestInput();
		String usuario = oldUser;
		String nombre = agenda.GetName(oldUser);
		String telefono = agenda.GetTel(oldUser);
		
		System.out.println("Modificando '" + usuario + "' '" + nombre + "' '" + telefono + "'");
		System.out.println("Seleccione el dato a modificar.");
		System.out.println("1: Usuario");
		System.out.println("2: Nombre");
		System.out.println("3: Telefono");
		
		Boolean repeat = true;
		while(repeat){
			repeat = false;
			Boolean noError = true;
			int opcion = IO.readInt();

			switch(opcion){
				case 1:
				System.out.println("Introducir usuario nuevo");
				usuario = RequestInput();
				noError = agenda.ModifyUsername(oldUser, usuario);
				break;
				case 2:
				System.out.println("Introducir nombre nuevo");
				nombre = RequestInput();
				noError = agenda.ModifyName(oldUser, nombre);
				break;
				case 3:
				System.out.println("Introducir telefono nuevo");
				telefono = RequestInput();
				noError = agenda.ModifyTel(oldUser, telefono);
				break;
				default:
				System.out.println("Opcion no correcta");
				repeat = true;
				break;
			}
			if(!noError){
				System.out.println("Error encontrado al modificar.. Volviendo a inicio.");
			}
		}
	}
	
	private void BorrarContacto() {
			System.out.println("----- BORRAR CONTACTO -----");
			System.out.println("Introduce el usuario del contacto a eliminar:");
			String usuario = RequestInput();

			
			Boolean noError = agenda.RemoveUser(usuario);
			
			if (!noError){			
			System.out.println("Error, no se ha podido borrar el usuario: " + usuario);
		}
	}
}
