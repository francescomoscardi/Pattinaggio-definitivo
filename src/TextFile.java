

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile
{
	private char mode;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public TextFile(String fileName, char mode) throws IOException
	{
		this.mode = 'R';
		if(mode == 'w' || mode == 'W')
		{
			FileWriter f1 = new FileWriter(fileName);
			writer = new BufferedWriter(f1);
			this.mode = 'W';
		}
		else
		{
			FileReader f1 = new FileReader(fileName);
			reader = new BufferedReader(f1);
			this.mode = 'R';
		}
		
	}
	
	public void toFile(String line) throws FileException, IOException
	{
		if(mode == 'R')
			throw new FileException("File Aperto in Lettura;");
		writer.write(line);
		writer.newLine();
	}
	
	public String fromFile() throws FileException, IOException
	{
		String rigaLetta;
		if(mode == 'W')
			throw new FileException("File Aperto in Lettura;");
		rigaLetta = reader.readLine();
		if(rigaLetta == null)
			throw new FileException("End of File");
		return rigaLetta;
	}
	
	public void closeFile() throws IOException
	{
		if(mode == 'R')
			reader.close();
		else
			writer.close();
	}
	

}
