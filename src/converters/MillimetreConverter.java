package converters;

public class MillimetreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*1000;
	}
	
	@Override
	public String toStringBr() {
		return "Distancia - Milimetro (mm)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Millimetre (mm)";
	}

}
