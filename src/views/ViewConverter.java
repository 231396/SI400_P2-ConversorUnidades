package views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.Controller;
import comboBoxModel.ConverterComboBoxModel;
import converters.AbstractConverter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewConverter extends JFrame {

	/**
	 * JFrame necessary serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtConvertFrom;
	private JTextField txtConvertTo;
	private JComboBox<AbstractConverter> comboConvertFrom;
	private JComboBox<AbstractConverter> comboConvertTo;

	/**
	 * Set comboBox comboConvertFrom from the given list
	 * @param listConvertFrom list of AbstractConverter objects
	 */
	public void setComboConvertFrom(ArrayList<AbstractConverter> listConvertFrom) {

		ConverterComboBoxModel convertFromComboBoxModel = new ConverterComboBoxModel(listConvertFrom);
		comboConvertFrom.setModel(convertFromComboBoxModel);
	}

	/**
	 * Set comboConvertTo from the comboConvertFrom
	 */
	public void setComboConvertTo() {
		AbstractConverter converterSelected = (AbstractConverter) comboConvertFrom.getModel().getSelectedItem();
		ArrayList<AbstractConverter> listConvertTo = Controller
				.getListConvertByMeasureType(converterSelected.getMeasureType());

		ConverterComboBoxModel convertToComboBoxModel = new ConverterComboBoxModel(listConvertTo);
		comboConvertTo.setModel(convertToComboBoxModel);
	}

	/**
	 * Set txtConvertTo to the correct measure.
	 */
	private void convertMeasure() {

		AbstractConverter selectedConvertFrom = (AbstractConverter) comboConvertFrom.getModel().getSelectedItem();
		AbstractConverter selectedConvertTo = (AbstractConverter) comboConvertTo.getModel().getSelectedItem();
		
		String stringConvertFrom = txtConvertFrom.getText().toString();
		
		String stringMeasureConverted = Controller.convertMeasure(selectedConvertFrom,selectedConvertTo, stringConvertFrom);
		
		txtConvertTo.setText(stringMeasureConverted);
	}

	/**
	 * Verify if char is a number
	 * @param c given char
	 * @return is valid number or not
	 */
	private boolean isValidNumber(char c) {
		if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_COMMA) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			return false;
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public ViewConverter() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewConverter.class.getResource("/resources/Unicamp.png")));
		setTitle("Unit Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 237);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtConvertFrom = new JTextField();
		txtConvertFrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!isValidNumber(c)) {
					e.consume();
					getToolkit().beep();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				convertMeasure();
			}
		});
		txtConvertFrom.setBounds(129, 61, 111, 20);
		contentPane.add(txtConvertFrom);
		txtConvertFrom.setColumns(10);

		txtConvertTo = new JTextField();
		txtConvertTo.setEditable(false);
		txtConvertTo.setBounds(129, 117, 111, 20);
		contentPane.add(txtConvertTo);
		txtConvertTo.setColumns(10);

		comboConvertFrom = new JComboBox<>();
		comboConvertFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setComboConvertTo();
				convertMeasure();
			}
		});
		comboConvertFrom.setBounds(250, 60, 211, 22);
		contentPane.add(comboConvertFrom);

		comboConvertTo = new JComboBox<>();
		comboConvertTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				convertMeasure();
			}
		});
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
