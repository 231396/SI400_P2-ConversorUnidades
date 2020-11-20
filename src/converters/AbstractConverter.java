package converters;

public abstract class AbstractConverter {

	private MeasureType measureType = setMeasureType();

	public abstract double toBasicUnit(double unit);

	public abstract double fromBasicUnit(double unit);

	public MeasureType getMeasureType() {
		return this.measureType;
	}

	protected abstract MeasureType setMeasureType();

}
