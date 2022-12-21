package com.example.Software.SoftwareInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software.Model.Software;
//save, find, findAll.persist are avilable
public interface SoftwareInt extends JpaRepository<Software,Integer> {//<T,Id>

}
