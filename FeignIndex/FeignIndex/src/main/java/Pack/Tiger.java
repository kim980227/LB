package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {

	@RequestMapping("/")
	public String func00() { 
		System.out.println("index controller");
		return "index";
	}
	
	@RequestMapping("/t1")
	public String func01() { 
		System.out.println("func01 call");
		return "TigerView";
	}
}
