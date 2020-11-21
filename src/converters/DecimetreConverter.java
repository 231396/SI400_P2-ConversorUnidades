package converters;

public class DecimetreConverter extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*10;
	}
	
	@Override
	public String toStringBr() {
		return "Distancia - Decimetro (dm)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Decimetre (dm)";
	}

}
