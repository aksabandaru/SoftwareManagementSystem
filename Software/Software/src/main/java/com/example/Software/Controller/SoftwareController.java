package com.example.Software.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Software.InterfaceforDef.SoftwareIntforDef;
import com.example.Software.Model.Admistrator;
import com.example.Software.Model.Software;

@Controller
public class SoftwareController{
	public SoftwareIntforDef service;//creating bean 

	public SoftwareController(SoftwareIntforDef service) {
		this.service = service;
	}
	@GetMapping("/viewAllSoftwares")//fetch records from database
	public String listOfsoftwares(Model model) {
	model.addAttribute("softwareList",service.fetchAllRecords());//store all the records in softwarelist
	return "software";  
	}

	@GetMapping("software/createNewSoftware")//for creating new software from user side
	public String createSoftware(Model model) {
		Software emptyObj=new Software();
		model.addAttribute("softobj", emptyObj);
		return "createSoftware";
	}
	@PostMapping("/insertSoftwares")	//to save given records in database
	public String InsertIntoDataBase(@ModelAttribute("softobj") Software obj) {
		service.saveSoftware(obj);
		return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/delete/{id}")//to delete particular rceord from database
	public String deleteSoftware(@PathVariable int id) {
		service.deleteSoftwarebyId(id);
		return "redirect:/viewAllSoftwares";
	}
	@GetMapping("/update/{id}")//upadate a record
	public String updateSoftwareRecr(@PathVariable int id, Model model) {
		model.addAttribute("updateSoftware", service.getSoftwareById(id));
		return "update_software";
	}
	@PostMapping("/updateAndSave/{id}")//to save updated record
	public String updateNewValIntoDb(@PathVariable int id,
			@ModelAttribute("updateSoftware") Software newVal) {
	Software existingSof = service.getSoftwareById(id);
existingSof.setSoftwarename(newVal.getSoftwarename());
existingSof.setCompanyname(newVal.getCompanyname());
existingSof.setDescription(newVal.getDescription());
existingSof.setStock(newVal.getStock());
existingSof.setPrice(newVal.getPrice());

	service.saveSoftware(existingSof);
	return "redirect:/viewAllSoftwares";
	}
	@GetMapping("software/logout")//for logout mapping
	public String toLogout() {
		return "logout";
		
	}
	
	@GetMapping("software/ceo")//mapping for ceo
		public String detailsOfCeo() {
		return "ceo";
		
	}
	@GetMapping("software/contact")//mapping for contact
	public String tocontact() {
	return "contact";
	
}
	@GetMapping("software/about")//mapping for about
	public String toknowcompany() {
	return "about";
	
	
	}
	@GetMapping("software/rating")//mapping for rating
	public String togiverating() {
	return "rating";
	
	
	}
	@GetMapping("/login")//to give user values from frontend
	public String tologin(Model model) {
		Admistrator admin=new Admistrator();
		model.addAttribute("adminObj",admin);
	return "login";

	}
	@GetMapping("/validatingData")//to check whether login details correct or not
	public String validateData(@ModelAttribute("adminObj") Admistrator admindata) {
		if(admindata.getUsername().equals("aksa")&& admindata.getPassword().equals("chandramma44")) {//username,password
			return "redirect:/viewAllSoftwares";

		}
		else {
			return "redirect:/login";
		}
		
	}
	
	
}

