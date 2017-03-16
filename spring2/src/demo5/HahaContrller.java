package demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class HahaContrller {
	@Autowired
	HahaService service;
	void handle() {
		service.go();
	}
}
