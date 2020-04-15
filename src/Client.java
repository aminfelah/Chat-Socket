import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.UnsupportedLookAndFeelException;

public class Client {
	public Socket S;
	public String name;
	public BufferedReader Bf;
	public static String message = "";
	public static String juset = "noinput";

	public static WindowFrame Wf;

	public Client(String name, int port) throws UnknownHostException, IOException {
		this.name = name;
		this.S = new Socket("127.0.0.1", port);

	}

	public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException,
			InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException {
		Scanner Sc = new Scanner(System.in);
		// UIManager.setLookAndFeel(new NimbusLookAndFeel());
		Wf = new WindowFrame();
		Wf.JT.setText("Quelle votre nom ? ");
		while (message == "") {
			juset = "testing";
		}
		String username = message;
		message = "";
		Wf.JT.setText("Bonjour " + username + "\r\n");
		Client Client = new Client(username, 5000);
		Thread.sleep(1000);
		ServerThread serverThread = new ServerThread(Client.S, Client.name);
		serverThread.start();
		Client.Bf = new BufferedReader(new InputStreamReader(System.in));
		while (serverThread.isAlive()) {
			// serverThread.addMessage(Client.Bf.readLine());
			if (message != "") {
				serverThread.addMessage(message);
				message = "";
			}

		}

	}

}