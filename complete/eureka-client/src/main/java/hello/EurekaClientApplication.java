package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
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

    private static BigInteger task() {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= 80000; i++)
            res = res.multiply(BigInteger.valueOf(i));
        return res;
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public BigInteger getMyData() {
        BigInteger result = task();
        return result;
    }


    @RequestMapping(value = "/actuator/info", method = RequestMethod.GET)
    @ResponseBody
    public String handler() {
        return "info";
    }
}