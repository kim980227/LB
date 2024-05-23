package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@FeignClient(name = "LION")
interface AppClient{
    @RequestMapping("/app2")
    String myFunc();
}
//@FeignClient(name = "bpp", url = "http://192.168.0.83:8765")
//interface BppClient{
//    @RequestMapping("/lion")
//    String myFunc();
//}
//추가코드
@RestController
class AppController {
    @Autowired
    AppClient ac;

    @GetMapping("lion")
    public String f1() {
        String str = ac.myFunc();
        System.out.println("Feign Controller : " + str);
        return str;
    }
//    @Autowired
//    BppClient bc;
//
//    @GetMapping("bpp1")
//    public String f2() {
//        System.out.println("bpp1 : ");
//        String str = bc.myFunc();
//        return "BppCont1 : " + "<br/>" + str;
//    }
}

//@RestController
//@RequestMapping("/bpp1")
//class AppController {
//    @GetMapping
//    String f1(){
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("bpp1");
//        return "bpp1";
//    }
//}
//@RestController
//@RequestMapping("/bpp2")
//class AppController2 {
//    @GetMapping
//    String f1() {
//        System.out.println("bpp2");
//        return "bpp2";
//    }
//}
//@RestController
//@RequestMapping("/bpp3")
//class AppController3 {
//    @GetMapping("/{num}")
//    String f1(@PathVariable Integer num) {
//        System.out.println("bpp3");
//        return "bpp3: " + num;
//    }
//}