
package modell;

public class Usuario {
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;

 public Usuario (String email, String senha, String nome, String sobrenome) {
     this.email = email;
     this.senha = senha;
     this.nome = nome;
     this.sobrenome = sobrenome;
     
    }
 public Usuario (String email, String senha) {
     this.email = email;
     this.senha = senha;
    }
 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
}