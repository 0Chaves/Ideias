package Ideias_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ideia {
	private String titulo;
	private String descricao;
	private int urgencia;
	private int id;
	
	public Ideia (String titulo, String descricao, int urgencia){
		if(urgencia < 1 || urgencia > 5) throw new IllegalArgumentException ("Urgencia deve ser de 1 a 5");
		setTitulo(titulo);
		setDescricao(descricao);
		setUrgencia(urgencia);
		setId();
	}

	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getUrgencia() {
		return urgencia;
	}

	private void setUrgencia(int urgencia) {
		this.urgencia = urgencia;
	}

	public int getId() {
		return id;
	}

	private void setId() {
		this.id = hashCode();
	}

	@Override
	public String toString() {
		return "Ideia [titulo=" + titulo + ", descricao=" + descricao + ", urgencia=" + urgencia + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, titulo, urgencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ideia other = (Ideia) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(titulo, other.titulo)
				&& urgencia == other.urgencia;
	}
	
}
