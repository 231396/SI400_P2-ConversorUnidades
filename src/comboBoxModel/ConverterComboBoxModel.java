package comboBoxModel;

import java.util.ArrayList;

import converters.AbstractConverter;

/**
 * Class that has implementation of the ComboBoxModel to be used with AbstractConverter
 */
public class ConverterComboBoxModel extends BaseComboBoxModel<AbstractConverter>{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Method Constructor of the class
	 * 
	 * @param list that contains the values of the model
	 */
	public ConverterComboBoxModel(ArrayList<AbstractConverter> listAbstractConverter) {
		super(listAbstractConverter);
	}

}
