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
	
	@Override
	public String toStringBr() {
		return "Distancia - Polegada (in)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Inch (in)";
	}

}
