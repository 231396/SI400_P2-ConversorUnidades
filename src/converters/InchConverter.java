package converters;

public class InchConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit*0.0254;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*39.3701;
	}

	public String toString() {
		return "Distance - Inch (in)";
	}

}
