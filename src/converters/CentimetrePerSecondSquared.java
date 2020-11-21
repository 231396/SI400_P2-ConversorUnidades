package converters;

public class CentimetrePerSecondSquared extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.ACCELERATION;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit / 100;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 100;
	}

	public String toString() {
		return "Acceleration -  (cm/s\u00b2)";
	}


}
