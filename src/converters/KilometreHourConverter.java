package converters;

public class KilometreHourConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.SPEED;
	}
	
	@Override
	public double toBasicUnit(double unit) {
		return unit/(3.6);
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit * 3.6;
	}
	
	@Override
	public String toStringBr() {
		return "Velocidade - Quilometro (k/h)";
	}
	
	@Override
	public String toStringNa() {
		return "Speed - Kilometre (k/h)";
	}


}
