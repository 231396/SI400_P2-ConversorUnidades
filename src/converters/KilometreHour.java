package converters;

public class KilometreHour extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.SPEED;
	}
	
	@Override
	public double toBasicUnit(double unit) {
		return unit/(3.6);
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 3.6;
	}
	
	public String toString() {
		return "SPEED - (k/h)";
	}


}
