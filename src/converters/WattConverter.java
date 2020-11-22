package converters;

public class WattConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		
		return MeasureType.POWER;
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
		return "Potência - Watt (W)";
	}
	
	@Override
	public String toStringNa() {
		return "Power - Watt (W)";
	}

}
