package converters;


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

}
