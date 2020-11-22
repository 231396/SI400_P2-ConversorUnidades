package converters;

public class NewtonConvert extends AbstractConverter{
	
	@Override
	protected MeasureType setMeasureType() {
		
		return MeasureType.FORCE;
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
		return "Força - Newton (N)";
	}
	
	@Override
	public String toStringNa() {
		return "Force - Newton (N)";
	}

}
