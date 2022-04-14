
package Model;

public class Atendimento {
    private int idAtendimento;
    private String tipoEquipamento;
    private String idEquipamento;
    private String descricao;
    private Integer urgencia;
    private Setor setorAtendimento;
    private String horaChamado;
    private Integer status;
    private Admin adminResponsavel;
    public Atendimento(){
        this.idAtendimento = 0;
        this.tipoEquipamento = null;
        this.idEquipamento = null;
        this.descricao = null;
        this.urgencia = null;
        this.horaChamado = null; 
        this.setorAtendimento = new Setor();
        this.status = null; 
        this.adminResponsavel = new Admin();
    }
    public Atendimento(String tipoEquipamento, String idEquipamento, String descricao, Integer urgencia,Setor setorAtendimento){
        this.idAtendimento = 0;
        this.tipoEquipamento = tipoEquipamento;
        this.idEquipamento = idEquipamento;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.horaChamado = null;
        this.setorAtendimento = setorAtendimento;
        this.status = 0; 
        this.adminResponsavel = new Admin();
    }
    public int getIdAtendimento() {
        return idAtendimento;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "idAtendimento=" + idAtendimento + ", tipoEquipamento=" 
                + tipoEquipamento + ", idEquipamento=" + idEquipamento + ", descricao=" 
                + descricao + ", urgencia=" + urgencia + ", setorAtendimento=" + setorAtendimento.getIdSetor() + 
                ", horaChamado=" + horaChamado + ", status=" + status + ", Admin="+adminResponsavel.getIdAdmin() +"}";
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(Integer urgencia) {
        this.urgencia = urgencia;
    }

    public Setor getSetorAtendimento() {
        return setorAtendimento;
    }

    public void setSetorAtendimento(Setor setorAtendimento) {
        this.setorAtendimento = setorAtendimento;
    }

    public String getHoraChamado() {
        return horaChamado;
    }

    public void setHoraChamado(String horaChamado) {
        this.horaChamado = horaChamado;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Admin getAdminResponsavel() {
        return adminResponsavel;
    }

    public void setAdminResponsavel(Admin adminResponsavel) {
        this.adminResponsavel = adminResponsavel;
    }

    
}
