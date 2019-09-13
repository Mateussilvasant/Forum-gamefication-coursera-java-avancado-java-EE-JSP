package dto;

public class UsuarioTO
{
    private int colocao;
    private String nome;
    private String login;
    private int pontos;

    public UsuarioTO()
    {
	super();
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public String getLogin()
    {
	return login;
    }

    public void setLogin(String login)
    {
	this.login = login;
    }

    public int getPontos()
    {
	return pontos;
    }

    public void setPontos(int pontos)
    {
	this.pontos = pontos;
    }

    public int getColocao()
    {
	return colocao;
    }

    public void setColocao(int colocao)
    {
	this.colocao = colocao;
    }
}
