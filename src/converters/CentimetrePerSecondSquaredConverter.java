package converters;

public class CentimetrePerSecondSquaredConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.ACCELERATION;
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
		return "Aceleracao - centimetros p/ segundo ao quadrado (cm/s\u00b2)";
	}
	
	@Override
	public String toStringNa() {
		return "Acceleration - centimetre p/ second squared (cm/s\u00b2)";
	}


}
