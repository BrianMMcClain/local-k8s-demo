package com.github.brianmmcclain.k8sshopfrontend;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ShopController {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/")
    @ResponseBody
    public String items() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body><table style=\"border: 1px solid black\">\n");
        sb.append("<tr>\n");
        sb.append("<th style=\"border: 1px solid black\">Name</th>\n");
        sb.append("<th style=\"border: 1px solid black\">Price</th>\n");
        sb.append("<th style=\"border: 1px solid black\">Count</th>\n");
        sb.append("</tr>\n");
        Item[] items = getItems();
        for (int i = 0; i < items.length; i++) {
            sb.append("<tr>\n");
            sb.append("<td style=\"border: 1px solid black\">").append(items[i].getName()).append("</td>\n");
            sb.append("<td style=\"border: 1px solid black\">$").append(items[i].getPrice()).append("</td>\n");
            sb.append("<td style=\"border: 1px solid black\">").append(items[i].getCount()).append("</td>\n");
            sb.append("</tr>\n");
        }
        sb.append("</table></body></html>");
        return sb.toString();
    }

    private Item[] getItems() {
        RestTemplate restTemplate = new RestTemplate();
        Item[] items = restTemplate.getForObject("http://localhost:8083/item", Item[].class);
        return items;
    }
}