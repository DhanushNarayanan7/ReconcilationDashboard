package com.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.service.PremiumService;

@Controller
public class PremiumController {
	
	@Autowired
	private PremiumService service;
	
	//Page Number 1 For file select and File upload
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.GET)
	public String fileUpload(ModelMap map,@RequestParam(value="search", required=false) String name ) {
		if(name==null) {
	         map.addAttribute("premiumlist",service.extractPremiumDetails());
			}else {
				System.out.println(name+" "+service.searchByName(name,service.extractPremiumDetails()));
	         map.addAttribute("premium",service.searchByName(name,service.extractPremiumDetails()));
			}
		return "premiumDetails";	
	}
	
	//Page Number 2 for Upload Success or Failure
	
	@RequestMapping(value="/premiumDetails", method=RequestMethod.POST)
	public String premiumDetails(@RequestParam("file") MultipartFile file,ModelMap map,@RequestParam(value="search", required=false) String id) {
		
		if(file.isEmpty()) {
		 map.addAttribute("message", "Please select a file to upload");
		}else {
			if(service.addPremiumDetails(file)) {
				map.addAttribute("msg","You successfully uploaded '" + file.getOriginalFilename() + "'");
			}else {
				map.addAttribute("message", "error! not able to extract data");
			}
		}
		if(id==null) {
         map.addAttribute("premiumlist",service.extractPremiumDetails());
		}else {
         map.addAttribute("premium",service.searchByName(id,service.extractPremiumDetails()));
		}
		return "premiumDetails";	
	}

}
