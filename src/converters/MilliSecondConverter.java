package converters;

public class MilliSecondConverter extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.TIME;
	}

	@Override
	public double toBasicUnit(double unit) {
		return unit/1000;
	}

	@Override
	public double fromBasicUnit(double unit) {
		return unit*1000;
	}

	@Override
	public String toStringBr() {
		return "Tempo - Milisegundos (ms)";
	}
	
	@Override
	public String toStringNa() {
		return "Time - Millisecond (ms)";
	}


}
