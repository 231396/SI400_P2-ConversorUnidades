package converters;

public abstract class AbstractConverter {
	
	private MeasureType measureType;
	
	public abstract AbstractConverter toBasicUnit(AbstractConverter unit);
	
	public abstract AbstractConverter fromBasicUnit(AbstractConverter unit);
	
	public MeasureType getMeasureType() {
		return this.measureType;
	}

}
