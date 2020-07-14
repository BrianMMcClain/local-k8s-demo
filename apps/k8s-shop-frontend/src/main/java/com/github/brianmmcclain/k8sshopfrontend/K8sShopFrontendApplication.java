package com.github.brianmmcclain.k8sshopfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class K8sShopFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sShopFrontendApplication.class, args);
	}

}
