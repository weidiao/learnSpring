package demo4;

public class BServiceImpl implements BService {

	@Override
	public void fooB() {
		System.out.println("fooB");
	}

	@Override
	public void barB(String s) {
		System.out.println("barB " + s);

	}

}
