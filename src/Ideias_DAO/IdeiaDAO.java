package Ideias_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdeiaDAO {
	public boolean inserir(Ideia i)  {
		Connection c = ConnectionFactory.getConnection();
		String insert = "INSERT INTO ideia (titulo,descricao,urgencia,id) values(?,?,?,?)";
		PreparedStatement pstm = c.prepareStatement(insert);
		pstm.setString(1, i.getTitulo());
		pstm.setString(2, i.getDescricao());
		pstm.setInt(3, i.getUrgencia());
		pstm.setInt(4, i.getId());
		return pstm.execute();
	}
	
	public boolean deletar(int d){
		String delete = "DELETE FROM ideia WHERE id = ?";
		PreparedStatement pstm = c.prepareStatement(delete);
		pstm.setInt(1, id);
		return pstm.execute();
	}
	
	public boolean update (Ideia i) {
		return true;	
	}
	
	public Ideia get(int id) {
		return null;
	}
	
	public static List<Ideia> listar(){
		List<Ideia> lista = new ArrayList<>();
		String query = "SELECT * FROM ideia" + " LIMIT ? OFFSET ?";
		PreparedStatement pstm = c.prepareStatement(query);
		ResultSet res = pstm.executeQuery();
		pstm.setInt(1, 1);
		pstm.setInt(2, 0);
		while(res.next()) {
			String titulo = res.getString("titulo");
			String descricao = res.getString("descricao");
			int urgencia = res.getInt("urgencia");
			//int id = res.getInt("id");
			lista.add(new Ideia(titulo,descricao,urgencia));
		}
		
		return lista;
		
	}
}
