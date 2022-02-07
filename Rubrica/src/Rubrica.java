import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Rubrica {
	private File myFile;
	private ArrayList<Contatto> contatti = new ArrayList<Contatto>();
	private String ln;
	private String[] ln_s;

	public Rubrica(String path) throws IOException {
		myFile = new File(path);
		if (myFile.createNewFile()) {
			System.out.println("File created: " + myFile.getName());
		} else {
			System.out.println("File " + myFile.getName() + " opened.");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				ln = myReader.nextLine();
				ln_s = ln.split(";");
				contatti.add(new Contatto(ln_s[0], ln_s[1], Integer.parseInt(ln_s[2]), ln_s[3]));
			}
			System.out.println(myFile.getAbsolutePath());
			System.out.println("Sono presenti " + Integer.toString(contatti.size()) + " contatti.");
			myReader.close();
		}
		System.out.println();
	}

	public void add(String nome, String cognome, int telefono, String email) {
		contatti.add(new Contatto(nome, cognome, telefono, email));
	}

	public void remove(String nome, String cognome) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) && cognome.equals(contatti.get(i).cognome)) {
				contatti.remove(i);
			}
		}
	}
	
	public void change_email(String nome,String cognome,String new_email) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) &&  cognome.equals(contatti.get(i).cognome)) {
				contatti.get(i).email = new_email;
			}
		}
	}
	
	public void get_telefono(String nome,String cognome) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) && cognome.equals(contatti.get(i).cognome)) {
				System.out.println(contatti.get(i).telefono);
			}
		}
	}

	public void get_email(String nome, String cognome) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) && cognome.equals(contatti.get(i).cognome)) {
				System.out.println(contatti.get(i).email);
			}
		}
	}

	public void change_number(String nome, String cognome, int new_num) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) && cognome.equals(contatti.get(i).cognome)) {
				contatti.get(i).telefono = new_num;
			}
		}
	}

	public void showlist() {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			System.out.println("Nome: " + contatti.get(i).nome);
			System.out.println("Cogome: " + contatti.get(i).cognome);
			System.out.println("Telefono: " + Integer.toString(contatti.get(i).telefono));
			System.out.println("Email: " + contatti.get(i).email);
			System.out.println();
		}
	}

	public void save() throws IOException {
		FileWriter myWriter = new FileWriter(myFile.getAbsolutePath());
		int i;
		for (i = 0; i < contatti.size(); i++) {
			myWriter.write(contatti.get(i).nome);
			myWriter.write(";");
			myWriter.write(contatti.get(i).cognome);
			myWriter.write(";");
			myWriter.write(Integer.toString(contatti.get(i).telefono));
			myWriter.write(";");
			myWriter.write(contatti.get(i).email);
			myWriter.write("\r\n");
		}
		myWriter.close();
	}
}
