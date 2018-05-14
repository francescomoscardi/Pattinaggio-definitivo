import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * La classe MainClass contiene il Menu, e l'oupout dei nostri metodi.
 * @author Francesco Moscardi
 * @version 1.0
 *
 */

public class MainClass 
{

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		String[] elenco= {"Registra Accesso","Registra Uscita","Visualizza Elenco in ordine alfabetico","Visualizza elenco in ordine di accesso","Modifica tariffe", "Verifica se una persona è presente"};
	
		ConsoleInput console=new ConsoleInput();
		Scanner tastiera=new Scanner(System.in);
		int tariffaAccesso=5;
		int tariffaSupplementare=2;
		int tariffaTotale=0;
		int continuaAncora=0;
		int continuaMenu=0;
		
		
		System.out.println("Pattinaggio by Moscardi Francesco\n");
		Lista l1=new Lista();
		Accesso a1=new Accesso("", null, 0, 0, 0, 0, false);
		Menu m1=new Menu(elenco);
		String nomeFile = "file.txt";
//		l1.caricaLista(nomeFile);
		do {
			switch (m1.scelta()) 
			{
			case 1:
				
					System.out.println("Vuoi registrare un accesso? 1=Si, 2=No");
					int entrata=0;
					entrata=tastiera.nextInt();
					
					
					switch (entrata) 
					{
					case 1:
						do 
						{
						System.out.println("inserisci nome");
						a1.setNome(tastiera.next());
						
						System.out.println("inserisci cognome");
						a1.setCognome(tastiera.next());
						System.out.println("inserisci codice");
						a1.setCodice(tastiera.nextInt());
						System.out.println("acquisisco l'ora, attendere");
						LocalTime oraAttuale=LocalTime.now();
						System.out.println("ora acquisita");
						System.out.println("vuoi noleggiare i pattini? 1=si 2=no");
						int vuoiPattini;
						vuoiPattini=tastiera.nextInt();
						
						switch (vuoiPattini) 
						{
						case 1:
							a1.setTariffaAccesso(5);
							l1.inserisciPersona(a1);
							break;
						case 2:
							break;
						default:
							break;
							
						}
						
						l1.salvaLista(nomeFile);
						System.out.println("vuoi continuare 1=si 2=no");
						
						Scanner tastiera8=new Scanner(System.in);
						continuaAncora=tastiera8.nextInt();
						if (continuaAncora==2) 
						{
							continuaMenu=1;
						}
						} while (continuaAncora==1);
					case 2:
						continuaMenu=1;
						
							
					default:
						break;
					}
				
			case 2:
				System.out.println("Vuoi registrare un uscita? 1=Si, 2=No");
				int uscita=0;
				Scanner tastiera6=new Scanner(System.in);
				uscita=tastiera6.nextInt();
				
				switch (uscita) 
				{
				case 1:
					System.out.println("calcolo dell'importo:");
					tariffaTotale=tariffaAccesso+tariffaSupplementare;
					System.out.println("hai pagato esattamente: "+tariffaTotale);
					
					System.out.println("verrà eliminato l'elemento in coda");
					l1.eliminaInCoda();
					System.out.println("elemento eliminato");
					
					l1.esportaCSV(nomeFile);
					l1.salvaLista(nomeFile);
					break;
					
				case 2:
					System.out.println("continua");
					break;

				default:
					break;
				}
				
				l1.eliminaInCoda();
				
			case 3:
				System.out.println("Visualizza ordine alfabetico");
				continuaMenu=1;
			
			case 4:
				System.out.println("Visualizza in ordine di tempo");
				a1.toString();
				continuaMenu=1;
				
			case 5:
				
				l1.cambiaAccessoENoleggio(tariffaAccesso, tariffaSupplementare);
				l1.salvaLista(nomeFile);
				continuaMenu=1;
				
				case 6:
				System.out.println("verifica presenza nella lista");
				continuaMenu=1;

			default:
				break;
			
			
			}
		} while (continuaMenu==1);
		
		
		
		
		
		
		
		
		
	} 

}
