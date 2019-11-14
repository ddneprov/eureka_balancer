package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;



@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private static Integer task() {
        System.out.println(" ============  ВВЕДИ ДАННЫЕ ============= ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() + scanner.nextInt();
    }

    @RequestMapping(value= "/check", method = RequestMethod.GET)
    @ResponseBody
    public Integer getMyData(/*@PathVariable long time*/) {
        int result = task();
        return result;
    }

    //http://10.8.77.22:8889/test
    @GetMapping(value = "/test")
    public String test() {
        return " test 2.0";
    }
}
