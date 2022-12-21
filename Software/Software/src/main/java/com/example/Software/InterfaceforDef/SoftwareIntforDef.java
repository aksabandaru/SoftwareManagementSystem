package com.example.Software.InterfaceforDef;

import java.util.List;

import com.example.Software.Model.Software;

public interface SoftwareIntforDef {
	List<Software> fetchAllRecords();//method to fetch all records from database
 Software saveSoftware(Software obj);//method to save record
void deleteSoftwarebyId(int id);//method to delete specific record by using id as a reference
Software getSoftwareById(int id);//to fetch specific record by using id
	

}
