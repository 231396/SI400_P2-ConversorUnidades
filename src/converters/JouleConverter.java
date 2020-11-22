package converters;

public class JouleConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.ENERGY;
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
		return "Energy - Joule (J)";
	}
	
	@Override
	public String toStringNa() {
		return "Energia - Metre (J)";
	}


}
