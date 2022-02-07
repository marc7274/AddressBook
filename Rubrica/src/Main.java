import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		String nome;
		String cognome;
		int telefono;
		String email;
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
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				System.out.print("Telefono: ");
				telefono = sc.nextInt();
				System.out.print("Email: ");
				email = sc.next();
				rubr.add(nome,cognome,telefono,email);
				break;
			case "showlist":
				rubr.showlist();
				break;
			case "remove":
				System.out.print("Nome: ");
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				rubr.remove(nome,cognome);
				break;
			case "getnumber":
				System.out.print("Nome: ");
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				rubr.get_telefono(nome,cognome);
				break;
			case "getemail":
				System.out.print("Nome: ");
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				rubr.get_email(nome,cognome);
				break;
			case "changenumber":
				System.out.print("Nome: ");
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				System.out.print("Telefono: ");
				telefono = sc.nextInt();
				rubr.change_number(nome,cognome,telefono);
				break;
			case "changeemail":
				System.out.print("Nome: ");
				nome = sc.next();
				System.out.print("Cognome: ");
				cognome = sc.next();
				System.out.print("Email: ");
				email = sc.next();
				rubr.change_email(nome, cognome, email);
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
//Questo è un test
//Forse funziona