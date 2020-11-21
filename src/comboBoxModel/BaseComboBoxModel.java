package comboBoxModel;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public abstract class BaseComboBoxModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
	
	private static final long serialVersionUID = 8089116544555428084L;

	protected List<T> list;  
	private T selected;
    
    public BaseComboBoxModel(List<T> list) {
    	this.list = list;
    	if (getSize() > 0)
            setSelectedItem(this.list.get(0));
    }    

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public T getElementAt(int index) {
		return list.get(index);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setSelectedItem(Object anItem) {
		selected = (T) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selected;
	}
}
