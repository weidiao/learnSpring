package demo0;

public class HahaServiceImpl implements HahaService {
	String haha;
	
	public String getHaha() {
		return haha;
	}

	public void setHaha(String haha) {
		this.haha = haha;
	}

	@Override
	public void go() {
		System.out.println(haha);
	}
}
