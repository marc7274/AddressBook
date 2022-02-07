import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Rubrica {

	private File myFile;
	
	private ArrayList<String> contatti = new ArrayList<String>();
	public Rubrica(String path) throws IOException {
		myFile = new File(path);
		if (myFile.createNewFile()) {
			System.out.println("File created: " + myFile.getName());
		} else {
			System.out.println("File " + myFile.getName() + " opened.");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				contatti.add(myReader.nextLine());
			}
			System.out.println(myFile.getAbsolutePath());
			System.out.println(contatti);
			myReader.close();
		}
		System.out.println();
	}

	public void add(String name, int num) {
		contatti.add(name + " " + Integer.toString(num));
	}

	public void show_list() {
		int i;
		for (i = 0; i < contatti.size(); i++)
			System.out.println(contatti.get(i));
	}

	public void remove(String rmname) {
		int i;
		String name;
		for (i = 0; i < contatti.size(); i++) {
			name = contatti.get(i).split(" ")[0];
			if (name.equals(rmname)) {
				contatti.remove(i);
			}
		}
	}

	public int get_number(String shname) {
		int i;
		String name;
		int num = -1;
		for (i = 0; i < contatti.size(); i++) {
			name = contatti.get(i).split(" ")[0];
			if (name.equals(shname)) {
				num = Integer.parseInt(contatti.get(i).split(" ")[1]);
			}
		}
		return num;
	}

	public void save() throws IOException
	{
		FileWriter myWriter = new FileWriter(myFile.getAbsolutePath());
		int i;
		for (i = 0; i < contatti.size(); i++)
		{
			myWriter.write(contatti.get(i));
			myWriter.write("\r\n");
		}
		myWriter.close();
	}
}
