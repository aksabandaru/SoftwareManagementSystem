package com.example.Software.Implentaion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Software.InterfaceforDef.SoftwareIntforDef;
import com.example.Software.Model.Software;
import com.example.Software.SoftwareInterface.SoftwareInt;
@Service//to provide service to this class
public class SoftwareImpforInterface implements  SoftwareIntforDef{

	private SoftwareInt software;//bean creating to invoke jparepository methods
public SoftwareImpforInterface(SoftwareInt software) {
	
		this.software = software;
	}
@Override
public List<Software> fetchAllRecords() {
	
	return software.findAll();//findAll method for fetching all records
}
@Override
public Software saveSoftware(Software obj) {
		return software.save(obj);//to save record in database
}
public void deleteSoftwarebyId(int id) {
	 software.deleteById(id);//delete record by using id as a reference
}
public Software getSoftwareById(int id) {
	return	software.findById(id).get();//Fetch particular record from database
	}

}
