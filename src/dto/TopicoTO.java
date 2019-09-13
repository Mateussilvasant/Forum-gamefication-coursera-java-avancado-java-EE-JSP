package dto;

import java.util.List;

public class TopicoTO
{
    private int numeroTopico;
    private String titulo;
    private String conteudo;
    private String nomeCriador;
    private List<ComentarioTO> comentarios;

    public TopicoTO()
    {
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

    public List<ComentarioTO> getComentarios()
    {
	return comentarios;
    }

    public int getNumeroTopico()
    {
	return numeroTopico;
    }

    public void setNumeroTopico(int numeroTopico)
    {
	this.numeroTopico = numeroTopico;
    }

    public void setListaComentarios(List<ComentarioTO> comentarios)
    {
	this.comentarios = comentarios;
    }

}
