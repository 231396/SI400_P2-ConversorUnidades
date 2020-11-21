package converters;

public class SecondConverter extends AbstractConverter{
    
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.TIME;
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
		return "Tempo - segundos (s)";
	}
	
	@Override
	public String toStringNa() {
		return "Time - Second (s)";
	}

	
}
