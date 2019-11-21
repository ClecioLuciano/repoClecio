import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class TesteUsuarioBD {

	public static void main(String[] args) {
		
		UsuarioDAO uDAO = new UsuarioDAO();		
		System.out.println(uDAO.getHoraBDMySQL());

/*		for (int i = 0; i < 100; i++) {

			Usuario u = new Usuario(i+1, "Usuario " + (i+1));

			UsuarioDAO uDAO = new UsuarioDAO();

			uDAO.create(u);
		}*/
		
/*		UsuarioDAO uDAO = new UsuarioDAO();		
		System.out.println("*** RELAÇÃO DOS USUÁRIOS ***");
		for (Usuario usuario : uDAO.readAll()) {			
			System.out.println(usuario);			
		}*/
	}

}
