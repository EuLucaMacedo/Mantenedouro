package mantenedouro;


import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class AnimalDao {
    
    public static boolean cadastrar(Animal a){
        String sql = "INSERT INTO Animal (nome, especie, DataResgate, responsavel, receita) VALUES (?, ?, ?, ? ,?)";
        
        try{
            ConexaoJDBA jdba = new ConexaoJDBA();
            jdba.conectar();
            
            PreparedStatement ps = jdba.getConexao().prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setString(2, a.getEspecie());
            ps.setString(3, a.getData());
            ps.setString(4, a.getResponsavel());
            ps.setString(5, a.getReceita());
            
            int AtualizacaoTabela = ps.executeUpdate();
            System.out.println("Animal Cadastrado com Sucesso!");
            jdba.desconectar();         
            return AtualizacaoTabela > 0;
        }catch (SQLException se){
            System.out.println("Erro ao Cadastrar Animal: " + se.getMessage());
            return false;
        }
    }
    
    public static List<Animal> listarTodos(){
        List<Animal> ani = new ArrayList();
        
        try{
            ConexaoJDBA conexao = new ConexaoJDBA();
            conexao.conectar();
            
            String sql = "SELECT a.id, a.nome, a.especie, a.DataResgate, a.responsavel, a.receita "
                    + "FROM Animal a";
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setEspecie(rs.getString("especie"));
                a.setData(rs.getString("DataResgate"));
                a.setResponsavel(rs.getString("responsavel"));
                a.setReceita(rs.getString("receita"));
                
                ani.add(a);
                
            }
            
            conexao.desconectar();
            
        }catch(SQLException se){
            System.err.println("Erro ao Listar Animais: " + se.getMessage());
        }
        
        return ani;
    }
    
    
    public static boolean excluir(int id){
        try{
            ConexaoJDBA jdba = new ConexaoJDBA();
            jdba.conectar();
            
            String sql = "DELETE FROM Animal WHERE id=?;";
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
