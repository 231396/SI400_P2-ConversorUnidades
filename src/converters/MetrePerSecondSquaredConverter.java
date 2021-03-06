package converters;

public class MetrePerSecondSquaredConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.ACCELERATION;
	}
	
	@Override
	public double toBasicUnit(double unit) {
		return unit;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit;
	}
	
	@Override
	public String toStringBr() {
		return "Aceleracao - Metro p/ segundo ao quadrado (m/s\u00b2)";
	}
	
	@Override
	public String toStringNa() {
		return "Acceleration - Metre p/ second squared (m/s\u00b2)";
	}


}
