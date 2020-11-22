package converters;

public class Decawatt extends AbstractConverter {

	@Override
	protected MeasureType setMeasureType() {
		return MeasureType.POWER;
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
		return "Pot�ncia - Decawatt (daW)";
	}
	
	@Override
	public String toStringNa() {
		return "Power - Decawatt (daW)";
	}

	
}
