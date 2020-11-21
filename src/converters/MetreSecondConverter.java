package converters;

public class MetreSecondConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.SPEED;
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
		return "Velocidade - metros por segundo (m/s)";
	}
	
	@Override
	public String toStringNa() {
		return "Speed - meter per second (m/s)";
	}


}
