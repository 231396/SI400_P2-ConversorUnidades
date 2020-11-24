package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import base.Controller;
import base.Languages;

public class ViewHelp extends JFrame {

	/**
	 * JFrame necessary serial version
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ViewHelp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 862, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewHelp.class.getResource("/resources/Unicamp.png")));
		lblNewLabel.setBounds(10, 11, 188, 219);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrVocTotalmente = new JTextArea();
		if(Controller.programLanguage.equals(Languages.PORTUGUESE)) {
			txtrVocTotalmente.setText("Este programa foi escrito para ser um projeto educacional simples que mostra como usar alguns recursos da Interface Gr\u00E1fica do Usu\u00E1rio (Swing) da linguagem Java e algumas t\u00E9cnicas de engenharia de software. O objetivo do programa \u00E9 realizar a convers\u00E3o entre duas unidades de medida.\r\n\r\nToda a a\u00E7\u00E3o \u00E9 colocada no painel de fundo da tela principal. O usu\u00E1rio interage com esta tela na maioria das vezes.\r\n\r\nAs op\u00E7\u00F5es do menu s\u00E3o muito simples:\r\n* No menu \"Arquivo\", pode-se optar por finalizar o programa;\r\n* No menu \"Ajuda\", pode-se escolher ver os textos padr\u00E3o: \"Ajuda\", \"Aviso Legal\" e \"Sobre\"");
				
		}else {
			txtrVocTotalmente.setText("This program was written to be a simple educational project that shows how to use some resources of Graphical User Interface (Swing) from Java language and some software engineering techniques. The aim of the program is performing the conversion between two measure units.\r\n\r\nAll the action is placed int the background panel of the main screen. The user interacts woth this screen most of time.\r\n\r\nThe menu options are very straight:\r\n* From the \"File\" menu, one can choose to finish the program;\r\n* From the \"Help\" menu, one can choose see standard texts: \"Help\"");
			
		}
		txtrVocTotalmente.setWrapStyleWord(true);
		txtrVocTotalmente.setLineWrap(true);
		txtrVocTotalmente.setBounds(208, 11, 638, 219);
		contentPane.add(txtrVocTotalmente);
	}
}
