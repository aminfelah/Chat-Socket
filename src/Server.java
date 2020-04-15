import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public ServerSocket SS;
	public Socket S;
	public ArrayList<ClientThread> Clients;

	public Server(int port) throws IOException {
		this.SS = new ServerSocket(port);
		Clients = new ArrayList<ClientThread>();
	}

	public void startServer() throws IOException {
		while (true) {
			System.out.println("le serveur en attente des Clients ....");
			S = SS.accept();
			System.out.println("le serveur a accepte" + S.getPort());
			ClientThread CT = new ClientThread(S, this);
			Clients.add(CT);
			CT.start();

		}
	}

	public static void main(String args[]) throws IOException {
		Server MyServer = new Server(5000);
		MyServer.startServer();

	}
}