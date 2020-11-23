package converters;

public class KilometrePerSecondSquaredConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.ACCELERATION;
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
		return "Aceleracao - Quilometro p/ segundo ao quadrado (k/s\u00b2)";
	}
	
	@Override
	public String toStringNa() {
		return "Acceleration - metre p/ second squared (m/s\u00b2)";
	}



}
