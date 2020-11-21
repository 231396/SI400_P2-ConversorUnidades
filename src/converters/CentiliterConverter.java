package converters;

public class CentiliterConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.VOLUME;
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
		return "Volume - Centilitro (cl)";
	}
	
	@Override
	public String toStringNa() {
		return "Volume - Centilitre (cl)";
	}

}
