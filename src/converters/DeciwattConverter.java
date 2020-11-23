package converters;

public class DeciwattConverter extends AbstractConverter {
	
	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.POWER;
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
		return "Potencia - Deciwatt (dW)";
	}
	
	@Override
	public String toStringNa() {
		return "Power - Deciwatt (dW)";
	}


}
