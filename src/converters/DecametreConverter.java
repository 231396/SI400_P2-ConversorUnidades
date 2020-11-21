package converters;

public class DecametreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit*10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit/10;
	}
	
	@Override
	public String toStringBr() {
		return "Distance - Decametro (dam)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Decametre (dam)";
	}

}
