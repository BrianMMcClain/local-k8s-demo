package com.github.brianmmcclain.k8sshopfrontend;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ShopController {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String items(Model model) {
        List<Item> items = getItems();
        model.addAttribute("items", items);
        return "index";
    }

    private List<Item> getItems() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("k8s-shop-backend-service");
        String serviceURI = "http://localhost:8083";
        if (!instances.isEmpty()) {
            serviceURI = instances.get(0).getUri().toString();
        }
        System.out.println("Using Service URI: " + serviceURI);
        Item[] items = restTemplate.getForObject(serviceURI + "/item", Item[].class);
        return Arrays.asList(items);
    }
}