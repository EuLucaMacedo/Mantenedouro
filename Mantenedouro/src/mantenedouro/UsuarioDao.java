package mantenedouro;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class UsuarioDao {
    public static boolean cadastrar(Usuario u){
        String sql = "INSERT INTO Usuario (nome, senha, permissao) VALUES (?, ?, ?)";
        try{
            ConexaoJDBA conectar = new ConexaoJDBA();
            conectar.conectar();

            PreparedStatement ps = conectar.getConexao().prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.setString(3, u.getPermissao());

            int AtualizacaoTabela = ps.executeUpdate();
            System.out.println("Login e Senha Cadastrado com Sucesso! ");
            conectar.desconectar();
            return AtualizacaoTabela > 0;
        }catch(SQLException se){
            System.out.println("Erro ao Cadastrar Usuario e Senha: " + se.getMessage());
            return false;
        }
    }
    
    public static List<Usuario> listarTodos(){
        List<Usuario> usu = new ArrayList();
        
        try{
            ConexaoJDBA conexao = new ConexaoJDBA();
            conexao.conectar();
            
            String sql = "SELECT u.id, u.nome, u.senha, u.permissao "
                    + "FROM Usuario u";
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setPermissao(rs.getString("permissao"));
                
                
                usu.add(u);
                
            }
            conexao.desconectar();
            
        }catch(SQLException se){
            System.err.println("Erro ao Listar Cadastros: " + se.getMessage());
        }
        return usu;
    }
    
     public static boolean excluir (int id){
        try{
            ConexaoJDBA jdba = new ConexaoJDBA();
            jdba.conectar();
            
            String sql = "DELETE FROM Usuario WHERE id=?;";
            PreparedStatement consulta =jdba.getConexao().prepareStatement(sql);
            
            consulta.setInt(1, id);
            
            consulta.execute();
            
            jdba.desconectar();
            return true;
            
        }catch(SQLException s){
            System.out.println("Erro ao deletar registro no banco de dados!" + s);
            return false;
        }
    }
}
