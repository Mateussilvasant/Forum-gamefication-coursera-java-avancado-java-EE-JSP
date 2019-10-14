package dto;

/**
 * @author mateussilva
 *
 */
public class ComentarioTO
{
    private String conteudo;
    private String nomeCriador;

    public ComentarioTO()
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

    public String getNomeCriador()
    {
	return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador)
    {
	this.nomeCriador = nomeCriador;
    }
}
