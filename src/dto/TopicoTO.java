package dto;

import java.util.ArrayList;
import java.util.List;

import model.Comentario;

public class TopicoTO
{
    private int numeroTopico;
    private String titulo;
    private String conteudo;
    private String nomeCriador;
    private List<Comentario> comentarios;

    public TopicoTO()
    {
	comentarios = new ArrayList<>();
    }

    public String getTitulo()
    {
	return titulo;
    }

    public void setTitulo(String titulo)
    {
	this.titulo = titulo;
    }

    public String getConteudo()
    {
	return conteudo;
    }

    public void setConteudo(String conteudo)
    {
	this.conteudo = conteudo;
    }

    public String getNomeCriador()
    {
	return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador)
    {
	this.nomeCriador = nomeCriador;
    }

    public List<Comentario> getComentarios()
    {
	return comentarios;
    }

    public void adicionarComentario(Comentario comentario)
    {
	comentarios.add(comentario);
    }

    public int getNumeroTopico()
    {
	return numeroTopico;
    }

    public void setNumeroTopico(int numeroTopico)
    {
	this.numeroTopico = numeroTopico;
    }

}
