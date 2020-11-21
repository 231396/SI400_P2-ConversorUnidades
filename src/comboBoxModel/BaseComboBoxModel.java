package comboBoxModel;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Class that has a generic implementation of the ComboBoxModel to be used by other classes
 */
public abstract class BaseComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
	
	private static final long serialVersionUID = 8089116544555428084L;

	/*
	 * List of the model 
	 * */
	protected List<T> list;  
	/*
	 * Value of the list that is selected
	 * */
	private T selected;

	/**
	 * Method Constructor of the class
	 * 
	 * @param list that contains the values of the model
	 */
    public BaseComboBoxModel(List<T> list) {
    	this.list = list;
    	if (getSize() > 0)
            setSelectedItem(this.list.get(0));
    }    

	/**
	 * Return the size of the list of the model
	 * 
	 * @return the size of the list of the model
	 */
	@Override
	public int getSize() {
		return list.size();
	}

	/**
	 * Return the element that is located in a given index
	 * 
	 * @return the element that is located in a given index
	 */
	@Override
	public T getElementAt(int index) {
		return list.get(index);
	}

	/**
	 * Set the item of the list of the model that is selected
	 * 
	 * @param anItem the item to be selected
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void setSelectedItem(Object anItem) {
		selected = (T) anItem;
	}

	/**
	 * Return the item of list of the model that is selected
	 * 
	 * @return the item of list of the model that is selected
	 */
	@Override
	public Object getSelectedItem() {
		return selected;
	}
}
