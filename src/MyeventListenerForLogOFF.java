import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyeventListenerForLogOFF implements ActionListener {
	WindowFrame F;

	public MyeventListenerForLogOFF(WindowFrame F) {
		this.F = F;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);

	}

}
