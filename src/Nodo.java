import java.io.Serializable;
/**
 * La classe Nodo serve per organizzare la Lista, anziché in array, in Nodi. 
 * @author Francesco Moscardi
 * @version 1.0
 *
 */
public class Nodo implements Serializable
{
	private Accesso info;
	private Nodo link;
	
	/**
	 * Metodo costruttore
	 * @param persona rappresenta il nostro utente
	 */
	public Nodo(Accesso persona)
	{
		setInfo(persona);
		link=null;
	}
	
	
	/**
	 * getter dell'attributo info
	 */
	public Accesso getInfo() 
	{
		return info;
	}
	
	/**
	 *setter dell'attributo info
	 */
	public void setInfo(Accesso info) 
	{
		this.info = info;
	}
	/**
	 *getter dell'attributo link
	 */
	public Nodo getLink() 
	{
		return link;
	}
	/**
	 * setter dell'attributo link
	 */
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
}
