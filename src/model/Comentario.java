package model;

public class Comentario
{

    private String conteudo;
    private int numeroTopico;

    public Comentario()
    {
	super();
    }

    public String getConteudo()
    {
	return conteudo;
    }

    public void setConteudo(String conteudo)
    {
	this.conteudo = conteudo;
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
