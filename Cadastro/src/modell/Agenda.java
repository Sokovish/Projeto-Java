package modell;

public class Agenda {
    private int id;
    private String responsavel;
    private String motivo;
    private String hrInicial;
    private String hrFinal;
    private String descricao;
    private String data;


    public Agenda(String responsavel, String motivo, String hrInicial, String hrFinal, String descricao, String data) {
        this.responsavel = responsavel;
        this.motivo = motivo;
        this.hrInicial = hrInicial;
        this.hrFinal = hrFinal;
        this.descricao = descricao;
        this.data = data;
    }


    public Agenda(int id, String responsavel, String motivo, String hrInicial, String hrFinal, String descricao, String data) {
        this.id = id;
        this.responsavel = responsavel;
        this.motivo = motivo;
        this.hrInicial = hrInicial;
        this.hrFinal = hrFinal;
        this.descricao = descricao;
        this.data = data;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHrInicial() {
        return hrInicial;
    }

    public void setHrInicial(String hrInicial) {
        this.hrInicial = hrInicial;
    }

    public String getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(String hrFinal) {
        this.hrFinal = hrFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
