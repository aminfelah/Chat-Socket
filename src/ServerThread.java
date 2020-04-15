import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	public Socket S;
	public String name;
	public String Msg;
	boolean hasMsg = false;

	public ServerThread(Socket S, String name) {
		this.S = S;
		this.name = name;

	}

	public void addMessage(String msg) {
		synchronized (this) {
			hasMsg = true;
			Msg = msg;
		}

	}

	@Override
	public void run() {
		System.out.println("Bonjour :" + name + "\n");

		try {
			PrintWriter serverOut = new PrintWriter(S.getOutputStream(), true);
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(S.getInputStream()));
			while (!S.isClosed()) {
				if (serverIn.ready()) {
					String input = "input not assigned";
					input = serverIn.readLine();
					System.out.println(input);
					Client.Wf.JT.append(input + "\n");

				}
				if (hasMsg) {
					String output = "" + Msg;
					hasMsg = false;
					serverOut.println(name + " > " + output + "");
					serverOut.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}