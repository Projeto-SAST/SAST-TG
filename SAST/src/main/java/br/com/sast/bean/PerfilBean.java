package br.com.sast.bean;

/**
 * Classe definida para controlar a comunição entre a classe PerfilDAO e sua Interface Web
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 25/10/2016
 */

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Perfil;

/**
 *
 * @author mstzao
 */
@ManagedBean
@ViewScoped
public class PerfilBean {
	
	private Perfil perfil;
	private List<Perfil> perfis;
	private Integer codigo;
	
	//GETS & SETS
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	//MÉTODOS CRUD
	
	//método que prepara a tela para inserir novo registro.
	public void novo(){
		
		perfil = new Perfil();
		
	}//fim do método novo
	
	//método para inserir dados no banco
	public void salvar(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.inserir(perfil);
		
		//FIXME: Classe PerfilBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Perfil inserido com sucesso!");
		
		novo();
		
	}//fim do método salvar
	
	//método para listar os registros do banco
	public void listar(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfis = perfilDAO.listar();
		
	}//fim do método listar
	
	//método para buscar um registro específico no banco.
	public void buscar(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfil = perfilDAO.buscar(codigo);
		
	}//fim do método buscar
	
	//método para editar um registro no específico no banco.
	public void editar(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.editar(perfil);
		
		//FIXME: Classe PerfilBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Perfil editado com sucesso!");
	
	}//fim do método editar
	
	//método para excluir um registro específico no banco.
	public void excluir(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfilDAO.excluir(perfil);
		
		//FIXME: Classe PerfilBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Perfil excluído com sucesso!");
		
	}//fim do método excluir
	
	
}
