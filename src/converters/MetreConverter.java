package converters;



public class MetreConverter extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.DISTANCE;
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
		return "Distancia - Metro (m)";
	}
	
	@Override
	public String toStringNa() {
		return "Distance - Metre (m)";
	}

}
