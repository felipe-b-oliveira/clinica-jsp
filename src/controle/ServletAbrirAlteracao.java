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
import modelo.dao.PacienteDAO;
import modelo.dominio.Endereco;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/editar")
public class ServletAbrirAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAbrirAlteracao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPacienteStr = request.getParameter("idPaciente");
		Integer idPaciente = Integer.parseInt(idPacienteStr);
		
		// criar instância do DAO para persistência
		PacienteDAO dao = new PacienteDAO();
		
		// carregar o paciente escolhido do banco
		Paciente pcte = dao.obter(idPaciente);
		
		// guardar o paciente no request para ser lido pela página
		request.setAttribute("pcte", pcte);
		
		// ler a lista de enderecos
		EnderecoDAO daoCat = new EnderecoDAO();
		List<Endereco> listaEnd = daoCat.listar();
		// guardar a lista de categorias no request
		request.setAttribute("listaCat", listaEnd);
		
		// criar um objeto para despachar a requisição
		RequestDispatcher desp = request.getRequestDispatcher("pacienteEditar.jsp");
		
		// encaminhar para o servlet ou página selecionada
		desp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
