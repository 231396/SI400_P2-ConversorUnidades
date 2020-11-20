package converters;

public class CentimetreConverter extends AbstractConverter{

	@Override
	public AbstractConverter toBasicUnit(AbstractConverter unit) {
		return unit;
	}

	@Override
	public AbstractConverter fromBasicUnit(AbstractConverter unit) {
		return unit;
	}


}
