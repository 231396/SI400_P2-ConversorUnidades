package converters;

public class NanometreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/(1000*1000*1000);
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*1000*1000*1000;
	}

	public String toString() {
		return "Distance - Nanometre (nm)";
	}

}
