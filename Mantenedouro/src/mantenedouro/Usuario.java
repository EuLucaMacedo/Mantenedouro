package mantenedouro;
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String permissao;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String permissao) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.permissao = permissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
    
}
