package converters;

public class DecalitreConverter extends AbstractConverter {
	

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VOLUME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit*10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit/10;
	}

	@Override
	public String toStringBr() {
		return "Volume - Decalitro (dal)";
	}
	
	@Override
	public String toStringNa() {
		return "Volume - Decalitre (dal)";
	}
}
