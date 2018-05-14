import java.time.LocalTime;

public class Accesso 
{
	private String nome;
	private String cognome;
	private int codice;
	private LocalTime oraIngresso;
	private boolean noleggioSiNo;
	private int tariffaAccesso=5;
	private int tariffaSupplementare=2;
	
	
	public Accesso(String nome, String cognome, int codice, int ore, int minuti, int secondi, boolean ingressoSiNo)
	{
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCodice(codice);
		setOraIngresso(ore,  minuti,  secondi);
		this.noleggioSiNo=noleggioSiNo;
		
	}
	


	public LocalTime getOraIngresso() 
	{
		return oraIngresso;
	}

	public void setOraIngresso(int ore, int minuti, int secondi) 
	{
		oraIngresso=LocalTime.of(ore, minuti, secondi);
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getNoleggioSiNo()
	{
		return noleggioSiNo;
	}
	
	public String toString()
	{
		return(getNome()+" "+getCognome()+" "+getCodice()+" "+getOraIngresso()+" "+getNoleggioSiNo());
	}



	public int getTariffaAccesso() {
		return tariffaAccesso;
	}



	public void setTariffaAccesso(int tariffaAccesso) {
		this.tariffaAccesso = tariffaAccesso;
	}



	public int getTariffaSupplementare() {
		return tariffaSupplementare;
	}



	public void setTariffaSupplementare(int tariffaSupplementare) {
		this.tariffaSupplementare = tariffaSupplementare;
	}
	
}
