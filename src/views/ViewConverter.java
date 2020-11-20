package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ViewConverter extends JFrame {

	private JPanel contentPane;
	private JTextField txtConvertFrom;
	private JTextField txtConvertTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConverter frame = new ViewConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtConvertFrom = new JTextField();
		txtConvertFrom.setBounds(10, 61, 180, 20);
		contentPane.add(txtConvertFrom);
		txtConvertFrom.setColumns(10);
		
		txtConvertTo = new JTextField();
		txtConvertTo.setBounds(10, 159, 180, 20);
		contentPane.add(txtConvertTo);
		txtConvertTo.setColumns(10);
		
		JComboBox comboConvertFrom = new JComboBox();
		comboConvertFrom.setBounds(244, 60, 180, 22);
		contentPane.add(comboConvertFrom);
		
		JComboBox comboConvertTo = new JComboBox();
		comboConvertTo.setBounds(244, 158, 180, 22);
		contentPane.add(comboConvertTo);
	}
}
