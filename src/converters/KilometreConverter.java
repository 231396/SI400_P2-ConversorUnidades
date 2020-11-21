package converters;

public class KilometreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit / 1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 1000;
	}
	
	@Override
	public String toStringBr() {
		return "Distance - Quilometro (km)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Kilometre (km)";
	}

}
