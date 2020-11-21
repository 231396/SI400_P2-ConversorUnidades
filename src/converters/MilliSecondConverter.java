package converters;

public class MilliSecondConverter extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.TIME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*1000;
	}

	public String toString() {
		return "Time - Millisecond (ms)";
	}


}
