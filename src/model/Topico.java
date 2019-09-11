package model;

public class Topico
{
    private String titulo;
    private String conteudo;
    private String login;

    public Topico()
    {
	super();
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

    public String getLogin()
    {
	return login;
    }

    public void setLogin(String login)
    {
	this.login = login;
    }

}
