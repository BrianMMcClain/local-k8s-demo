package com.github.brianmmcclain.k8sshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class K8sShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(K8sShopBackendApplication.class, args);
	}

}
