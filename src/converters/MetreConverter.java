package converters;



public class MetreConverter extends AbstractConverter{

	@Override
	public AbstractConverter toBasicUnit(AbstractConverter unit) {
		return unit;
	}

	@Override
	public AbstractConverter fromBasicUnit(AbstractConverter unit) {
		return unit;
	}

}
