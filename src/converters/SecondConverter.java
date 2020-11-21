package converters;

public class SecondConverter extends AbstractConverter{
    
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.TIME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit;
	}

	public String toString() {
		return "Time - Second (s)";
	}

	
}
