package converters;

public class CentimetreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
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
		return "Distance - Centimetre (cm)";
	}

}
