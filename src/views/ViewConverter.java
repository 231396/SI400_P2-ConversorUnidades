package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConverter.class.getResource("/views/Unicamp.png")));
		setTitle("Unit Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 237);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtConvertFrom = new JTextField();
		txtConvertFrom.setBounds(129, 61, 111, 20);
		contentPane.add(txtConvertFrom);
		txtConvertFrom.setColumns(10);
		
		txtConvertTo = new JTextField();
		txtConvertTo.setBounds(129, 117, 111, 20);
		contentPane.add(txtConvertTo);
		txtConvertTo.setColumns(10);
		
		JComboBox comboConvertFrom = new JComboBox();
		comboConvertFrom.setBounds(250, 60, 211, 22);
		contentPane.add(comboConvertFrom);
		
		JComboBox comboConvertTo = new JComboBox();
		comboConvertTo.setBounds(250, 116, 211, 22);
		contentPane.add(comboConvertTo);
		
		JLabel lblNewLabel = new JLabel("Convert from");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaptionText, null));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 57, 96, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaptionText, null));
		lblTo.setBackground(Color.WHITE);
		lblTo.setBounds(23, 113, 96, 28);
		contentPane.add(lblTo);
	}
}
