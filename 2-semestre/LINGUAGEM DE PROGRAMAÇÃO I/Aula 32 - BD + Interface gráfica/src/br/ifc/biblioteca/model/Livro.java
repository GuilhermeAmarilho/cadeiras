package br.ifc.biblioteca.model;

public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private int edicao;
    private int categoriaId;
        
    public Livro(){
        this.id = 0;
        this.titulo = "";
        this.autor = "";
        this.editora = "";
        this.edicao = 0;
        this.categoriaId = 0;
    }

    public Livro(String titulo, String autor, String editora, int edicao, int categoriaId) {        
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.categoriaId = categoriaId;
    }
    
    public Livro(int id, String titulo, String autor, String editora, int edicao, int categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.categoriaId = categoriaId;
    }        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }        

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }        
}
