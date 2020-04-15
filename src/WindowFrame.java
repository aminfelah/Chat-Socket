import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel PanelNorth = new JPanel();
	public JPanel PanelSouth = new JPanel();
	public JPanel PanelMain = new JPanel();
	public JTextArea JT = new JTextArea();
	public JTextField JF = new JTextField();
	public JButton LogOFF = new JButton("LogOFF");
	public JButton Send = new JButton("Send");
	public JScrollPane scroll = new JScrollPane(JT);

	// scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	public WindowFrame() {
		super("ChatRoom");
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.add(PanelNorth, BorderLayout.NORTH);
		this.add(PanelMain);

		this.add(PanelSouth, BorderLayout.SOUTH);
		PanelNorth.setBackground(new Color(211, 187, 242));
		PanelSouth.setBackground(new Color(131, 46, 242));

		PanelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		PanelNorth.add(LogOFF);
		PanelMain.add(JT);
		scroll = new JScrollPane(JT);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
		JT.setPreferredSize(new Dimension(600, 9275));
		JT.setEditable(false);
		PanelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		PanelSouth.add(JF);
		PanelSouth.add(Send);
		JF.setPreferredSize(new Dimension(450, 30));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		MyeventListenerForLogOFF x1 = new MyeventListenerForLogOFF(this);
		LogOFF.addActionListener(x1);
		MyeventListenerForSend x2 = new MyeventListenerForSend(this);
		Send.addActionListener(x2);

	}

}
