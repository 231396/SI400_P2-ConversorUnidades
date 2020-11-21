package converters;

public class DeciLitreConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VOLUME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/10;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*10;
	}
	
	@Override
	public String toStringBr() {
		return "Volume - Decilitro (dl)";
	}
	
	@Override
	public String toStringNa() {
		return "Volume - Decilitre (dl)";
	}


}
