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

import hello.GFG;

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

    private static String task() {
        System.out.println(" ============ ВВЕДИ ДАННЫЕ ============= \n");
        Scanner scanner = new Scanner(System.in);
        return GFG.encryptThisString(scanner.next());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getMyData() {
        String result = task();
        return result;
    }
}