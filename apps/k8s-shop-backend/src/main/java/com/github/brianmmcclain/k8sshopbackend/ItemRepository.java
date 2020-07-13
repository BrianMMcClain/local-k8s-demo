package com.github.brianmmcclain.k8sshopbackend;

import org.springframework.data.jpa.repository.JpaRepository;
 
interface ItemRepository extends JpaRepository<Item, Long> {

}