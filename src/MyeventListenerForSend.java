
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyeventListenerForSend implements ActionListener {
	WindowFrame F;

	public MyeventListenerForSend(WindowFrame F) {
		this.F = F;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Client.message = this.F.JF.getText();
		this.F.JF.setText("");
	}

}
