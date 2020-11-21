package converters;

public class HectometreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit*100;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit/100;
	}
	
	@Override
	public String toStringBr() {
		return "Distance - Hectometro (hm)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Hectometre (hm)";
	}

}
