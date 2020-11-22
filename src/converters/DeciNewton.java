package converters;

public class DeciNewton extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.FORCE;
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
		return "Força - Newton (dN)";
	}
	
	@Override
	public String toStringNa() {
		return "Force - Newton (dN)";
	}

}
