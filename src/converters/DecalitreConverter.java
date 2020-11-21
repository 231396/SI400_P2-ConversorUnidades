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

	public String toString() {
		return "Volume - Decalitre (dal)";
	}

}
