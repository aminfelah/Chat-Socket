import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	public Socket So;
	public Server server;
	public PrintWriter serverOut;

	public ClientThread(Socket S, Server server) {
		this.So = S;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			this.serverOut = new PrintWriter(So.getOutputStream(), true);
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(So.getInputStream()));

			while (!So.isClosed()) {
				if (serverIn.ready()) {
					String input = serverIn.readLine();
					System.out.println("le serveur a recu " + input);

					for (ClientThread thatClient : server.Clients) {
						PrintWriter thatClientOut = thatClient.serverOut;
						if (thatClientOut != null) {
							thatClientOut.write(input + "\r\n");
							thatClientOut.flush();
						}
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}