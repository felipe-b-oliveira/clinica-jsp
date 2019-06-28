package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.EnderecoDAO;
import modelo.dominio.Endereco;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletAbrirInclusao
 */
@WebServlet("/abrirInclusao")
public class ServletAbrirInclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirInclusao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// criar uma nova instância de paciente
		Paciente pcte = new Paciente();
		
		// guardar o novo paciente para ser usado na página
		request.setAttribute("pcte", pcte);
		
		// ler a lista de enderecos
		EnderecoDAO daoCat = new EnderecoDAO();
		List<Endereco> listaEnd = daoCat.listar();
		// guardar a lista de categorias no request
		request.setAttribute("listaCat", listaEnd);
		
		// enviar o processamento para a página
		RequestDispatcher desp = request.getRequestDispatcher("pacienteEditar.jsp");
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
