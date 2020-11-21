package views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.ClassFinder;
import comboBoxModel.ConverterComboBoxModel;
import converters.AbstractConverter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewConverter extends JFrame {

	private JPanel contentPane;
	private JTextField txtConvertFrom;
	private JTextField txtConvertTo;
	private JComboBox comboConvertFrom;
	private JComboBox comboConvertTo;
	
	
	public void setAllComboBox(ArrayList<AbstractConverter> listConvertFrom, ArrayList<AbstractConverter> listConvertTo){
		
		ConverterComboBoxModel convertFromComboBoxModel   = new ConverterComboBoxModel(listConvertFrom);
		ConverterComboBoxModel   convertToComboBoxModel   = new ConverterComboBoxModel(listConvertTo);
		
		comboConvertFrom.setModel(convertFromComboBoxModel);
		comboConvertTo.setModel(convertToComboBoxModel);
	}
	
	private void setComboConvertTo(ActionEvent arg0) {
		System.out.println("Clicou - ");
		
		AbstractConverter converterSelected = (AbstractConverter) comboConvertFrom.getModel().getSelectedItem();
		converterSelected.getMeasureType().getTypeString();
		
		String typeMeasureSelected = converterSelected.getMeasureType().getTypeString();
		
		String path = "C:\\Users\\Vitor\\Desktop\\converters";
		
		ArrayList<AbstractConverter> listConvertTo = ClassFinder.loadClasses(path);
		
		for (AbstractConverter itemConverter : listConvertTo) {
			if(!itemConverter.getMeasureType().getTypeString().equals(typeMeasureSelected)) {
				listConvertTo.remove(itemConverter);
			}
		}
		

		ConverterComboBoxModel convertToComboBoxModel   = new ConverterComboBoxModel(listConvertTo);
		comboConvertTo.setModel(convertToComboBoxModel);
		
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
		
		comboConvertFrom = new JComboBox();
		comboConvertFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setComboConvertTo(arg0);
			}
		});
		comboConvertFrom.setBounds(244, 60, 180, 22);
		contentPane.add(comboConvertFrom);
		
		comboConvertTo = new JComboBox();
		comboConvertTo.setBounds(244, 158, 180, 22);
		contentPane.add(comboConvertTo);
		
	}
}
