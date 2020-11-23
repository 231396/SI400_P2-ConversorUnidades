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
	
	@Override
	public String toStringBr() {
		return "Distancia - Centimetro (cm)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Centimetre (cm)";
	}

}
