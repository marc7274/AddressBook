import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import com.google.gson.*;
import java.util.Arrays;

public class Rubrica {
	private File myFile;
	ArrayList<Contatto> contatti = new ArrayList<Contatto>();

	public Rubrica(String path) throws IOException {
		String json;
		myFile = new File(path);

		if (myFile.createNewFile()) {
			System.out.println("File created: " + myFile.getName());
		} else {
			System.out.println("File " + myFile.getName() + " opened.");
			Scanner myReader = new Scanner(myFile);
			json = myReader.nextLine();
			Contatto[] contatti_arr = new Gson().fromJson(json, Contatto[].class);
			contatti = new ArrayList<>(Arrays.asList(contatti_arr));
			System.out.println(new Gson().toJson(contatti));
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

	public void change_email(String nome, String cognome, String new_email) {
		int i;
		for (i = 0; i < contatti.size(); i++) {
			if (nome.equals(contatti.get(i).nome) && cognome.equals(contatti.get(i).cognome)) {
				contatti.get(i).email = new_email;
			}
		}
	}

	public void get_telefono(String nome, String cognome) {
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
		}
	}

	public void save() throws IOException {
		FileWriter myWriter = new FileWriter(myFile.getAbsolutePath());
		myWriter.write(new Gson().toJson(contatti));
		myWriter.close();
	}
}
// ciaociaociaociao.json add Leo Nardo 183 no add Dona Tello 729 forse .