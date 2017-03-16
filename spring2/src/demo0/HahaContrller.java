package demo0;

public class HahaContrller { 
	HahaService service;
	public void setService(HahaService service) {
		this.service=service;
	}
	void handle(){
		service.go();
	}
}
