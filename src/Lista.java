import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * La classe Lista contiene tutti i metodi che ci servono per organizzare i nostri Nodi,
 * il toString, in buona sostanza tutti i metodi utili alla lista e al main.
 * @author Francesco Moscardi
 * @version 1.0
 *
 */
public class Lista implements Serializable
{
	private Accesso[] elencoPattinatori;
	private final int MAX_NUM_PATTINATORI=100;
	
	private Nodo head;
	private int elementi;
	/**
	 * metodo Costruttore
	 */
	public Lista()
	{
		head=null;
		elementi=0;
	}
	/**
	 * metodo che consente di inserire in testa alla lista un nodo contenente 
	 * un partecipante.
	 * @param persona partecipante al pattinaggio
	 */
	public void inserisciPersona (Accesso persona)
	{
		
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
	}
	/**
	 * metodo chge ci consente di eliminare un aprtecipante in una determinata
	 * posizione
	 * @param posizione indica la poszione del partecipante da eliminare
	 */
	public void eliminaAccesso(int posizione) 
	{
		
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	/**
	 * ci consente di esportare la nostra lista in un file di testo
	 * @param nomeFile è il file nella quale vogliamo msalvare i nostri dati
	 * @throws IOException sceglie di non gestire ora l'eccezione di tipo I/O
	 */
	public void esportaCSV (String nomeFile) throws IOException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String personaCSV;
		Accesso persona;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			persona=getAccesso(i);
			personaCSV=persona.getNome()+";"+persona.getCognome()+";";
			//file.toFile(personaCSV);
		}
		file.closeFile();
		
	}
	/**
	 * ci consente di prelevare il nostro accesso
	 * @param posizione posizione del nostro partecipante
	 * @return p.getInfo() ritorna il getter dell'attributo info riferito al
	 * partecipante
	 */
	public Accesso getAccesso (int posizione) 
	{
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	
	/**
	 * crea un nodo nella lista
	 * @param persona partecipante al pattinaggio
	 * @param link puntatore del prossimo nodo
	 * @return nodo 
	 */
	private Nodo creaNodo(Accesso persona, Nodo link)
	{
		Nodo nodo= new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * preleva il link relativo alla posizione del partecipante
	 * @param posizione la poszione del nostro partecipante
	 * @return p il nostro partecipante
	 */
	private Nodo getLinkPosizione(int posizione) 
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;

		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	/**
	 * elimina un nodo alla testa della lista
	 */
	public void eliminaInTesta()
	{
		
		head=head.getLink();
		elementi--;
	}
	/**
	 * elimina un nodo in coda alla lista
	 */
	public void eliminaInCoda() 
	{
	
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	/**
	 * consente di cambiare le tariffe del pattinaggio
	 * @param tariffaAccesso la tariffa di entrata al pattinaggio
	 * @param tariffaSupplementare la tariffa per ogni ora aggiuntiva all'entrata
	 * @return tariffaAccesso ritorna la tariffa di accesso
	 * @return tariffaSupplementare ritorna la tariffa supplementare
	 */
	public int cambiaAccessoENoleggio(int tariffaAccesso, int tariffaSupplementare)
	{
		System.out.println("vuoi cambiare le tariffe? 1=si 2=no");
		int cambiaTariffe=0;
		Scanner tastiera5=new Scanner(System.in);
		cambiaTariffe=tastiera5.nextInt();
		
		switch (cambiaTariffe) 
		{
		case 1:
			System.out.println("vuoi cambiare la tariffa di Accesso(1) o quella supplementare(2)?");
			int tipoTariffa=0;
			Scanner tastiera6=new Scanner(System.in);
			tipoTariffa=tastiera6.nextInt();
			switch (tipoTariffa) 
			{
			case 1:
				System.out.println("inserisci la nuova tariffa di accesso:");
				int nuovaTariffaAccesso=0;
				Scanner tastiera=new Scanner(System.in);
				nuovaTariffaAccesso=tastiera.nextInt();
				
				tariffaAccesso=nuovaTariffaAccesso;
				return tariffaAccesso;
				
				
			case 2:
				System.out.println("inserisci la nuova tariffa supplementare");
				int nuovaTariffaSupplementare;
				Scanner tastiera1=new Scanner(System.in);
				nuovaTariffaSupplementare=tastiera1.nextInt();
				
				tariffaSupplementare=nuovaTariffaSupplementare;
				return tariffaSupplementare;
			default:
				return 0;
			
			}
			

		default:
			return 0;
			
		}
	}
	/**
	 * il metodo toString ci consente di restituire una sequenza degli attributi che ci servono
	 */
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * effettua la serializzazione della nostra lista in modo da renderla permanente e farla
	 * sopravvivere allo spegnimento del programma
	 * @param nomeFile
	 * @throws IOException
	 */
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	/*
	public Lista caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
	{
		String nomeFile = "file.txt";
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Lista l1;
		
		l1=(Lista)(reader.readObject());
		file.close();
		return l1;
	}
	*/
	/**
	 * getter dell'attributo elementi
	 * @return elementi il numero di nodi
	 */
	public int getElementi() 
	{
		return elementi;
	}
	/*
	public Accesso[] getElencoPattinatori() {
		return elencoPattinatori;
	}

	public void setElencoPattinatori(Accesso[] elencoPattinatori) {
		this.elencoPattinatori = elencoPattinatori;
	}

	public int getMAX_NUM_PATTINATORI() {
		return MAX_NUM_PATTINATORI;
	}*/

}
