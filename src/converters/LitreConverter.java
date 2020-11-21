package converters;

public class LitreConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VOLUME;
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
		return "Volume - Litro (l)";
	}
	
	@Override
	public String toStringNa() {
		return "Volume - Litre (l)";
	}


}
