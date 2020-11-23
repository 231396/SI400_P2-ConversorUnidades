package converters;

import base.Controller;
import base.Languages;

/**
 * Base class from all converter classes
 */
public abstract class AbstractConverter {

	/**
	 * Indicates the MeasureType, which the inherit converters belongs
	 */
	private MeasureType measureType = setMeasureType();
	
	/**
	 * Convert a unit value to their basic measure
	 * @param unit value to be converted
	 * @return value converted to basic measure type
	 */
	public abstract double toBasicUnit(double unit);

	/**
	 * Convert a unit value to the current class measure
	 * @param unit value to be converted
	 * @return value basic measure type value to the current measure type
	 */
	public abstract double fromBasicUnit(double unit);

	/**
	 * @return get propriety of measureType
	 */
	public MeasureType getMeasureType() {
		return this.measureType;
	}

	/**
	 * @return set propriety of measureType
	 */
	protected abstract MeasureType setMeasureType();
	
	
	public String toString() {
		if (Controller.programLanguage.equals(Languages.PORTUGUESE))
			return toStringBr();
		else
			return toStringNa();
	}
	
	/**
	 * Return a string in Br version
	 * @return toString method version Br
	 */
	protected abstract String toStringBr();
	
	/**
	 * Return a string in Na version
	 * @return toString method version Na
	 */
	protected abstract String toStringNa();
}
