package converters;

public class HourConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.TIME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit * 60*60;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit/(60*60);
	}

	public String toString() {
		return "Time - Hour (h)";
	}


}
