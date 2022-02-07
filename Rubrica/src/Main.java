import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		String name;
		int num;
		String text = " ";
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire il percordo del file: ");
		text = sc.next();
		Rubrica rubr = new Rubrica(text);
		
		while (!".".equals(text)) {
			System.out.print("Inserire un comando: ");
			text = sc.next();
			switch(text) {
			case "add":
				System.out.print("Nome: ");
				name = sc.next();
				System.out.print("Numero: ");
				num = sc.nextInt();
				rubr.add(name, num);
				break;
			case "showlist":
				rubr.show_list();
				break;
			case "remove":
				System.out.print("Nome: ");
				name = sc.next();
				rubr.remove(name);
				break;
			case "getnumber":
				System.out.print("Nome: ");
				name = sc.next();
				System.out.println(rubr.get_number(name));
				break;
			case ".":
				rubr.save();
				System.out.println("Programma terminato.");
				break;
			default:
				System.out.println("Comando non riconosciuto. Inserire di nuovo");
			}
			
		}
		sc.close();
	}
}
