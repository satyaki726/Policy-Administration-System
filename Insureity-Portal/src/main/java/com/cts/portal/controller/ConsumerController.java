package com.cts.portal.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.portal.feign.Consumerclient;
import com.cts.portal.model.ConsumerDetails;
import com.cts.portal.model.ConsumerRequest;
import com.cts.portal.model.FindConsumer;
import com.cts.portal.model.UpdateConsumer;
import com.cts.portal.service.InsureityService;

@Controller
@RequestMapping("/policy")
public class ConsumerController {

	@Autowired
	private Consumerclient client;

	@Autowired
	private InsureityService insureityService;

	@GetMapping("/consumers")
	public String showView(@ModelAttribute("consumerRequest") ConsumerRequest consumerRequest, BindingResult result) {
		return "create-consumer";
	}

	@PostMapping("/consumers")
	public ModelAndView createConsumer(@ModelAttribute("consumerRequest") ConsumerRequest consumerRequest,
			BindingResult result, HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-401");
			return login;
		}

		ModelAndView model = new ModelAndView("create-consumer");

		if (consumerRequest != null) {
			try {
				ConsumerDetails con = insureityService.getConsumerDetails(consumerRequest);
				client.createConsumer((String) request.getSession().getAttribute("Authorization"), con);
				model.addObject("success", "Consumer added successfully!!");

			} catch (Exception e) {
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error", "Please Add Details Properly!!!");
				return error;
			}
		}

		return model;
	}

	@GetMapping("/getallconsumers")
	public ModelAndView getAllConsumer(HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-401");
			return login;
		}

		ModelAndView model = new ModelAndView("view-consumer");

		try {
			List<ConsumerDetails> list = client.viewAllConsumer((String) request.getSession().getAttribute("Authorization"));
			model.addObject("list", list);

		} catch (Exception e) {
			ModelAndView error = new ModelAndView("error-401");
			error.addObject("error", "List is empty");
			return error;
		}

		return model;
	}
	@GetMapping(value = "/getconsumers")
	public ModelAndView getConsumer(
			@ModelAttribute("findconsumer") FindConsumer findConsumer,
			HttpServletRequest request) throws Exception {
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-401");
			return login;
		}
		/*
		 * if token is set, 
		 * then allow access to view
		 */
		ModelAndView model = new ModelAndView("get-consumer");
		if (findConsumer != null && findConsumer.getId() != null) {
			
				/*
				 * get the package details by Name 
				 * using feign client of IPOfferingMicroservice
				 */
			try {
				ConsumerDetails con = client.viewConsumer(
						(String) request.getSession().getAttribute("Authorization"),findConsumer.getId());
				List<ConsumerDetails> list = new ArrayList<>();
				list.add(con);
				model.addObject("list", list);
			}catch (Exception e) {
				// TODO: handle exception
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error","Enter Proper Id");
				return error;
			}
		}
		return model;
	}
	
	@GetMapping(value = "/updateConsumers")
	public String updateConsumer(@ModelAttribute("updateConsumer") UpdateConsumer updateConsumer, BindingResult result) {

		return "update-consumer";
		
	}
	
	
	
	@PostMapping(value = "/updateConsumers")
	public ModelAndView updateIPTreatmentPackages(@ModelAttribute("updateConsumer") UpdateConsumer updateConsumer, BindingResult result,
			HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-401");
			return login;
		}

		ModelAndView model = new ModelAndView("update-consumer");
		try {
			ConsumerDetails con = insureityService.updateConsumerDetails(updateConsumer);
			client.updateConsumer((String) request.getSession().getAttribute("Authorization"),con.getId(), con);
			model.addObject("success","Consumer Updated");
		}catch(Exception e) {
			ModelAndView error = new ModelAndView("error-401");
			error.addObject("error","Enter The Details Properly");
			return error;
		}
		
		
		return model;
	}
	
	@GetMapping(value = "/deleteconsumers")
	public String showDeleteSpecialist(@ModelAttribute("findconsumer") FindConsumer findconsumer,BindingResult result) {
		return "delete-consumer";
	}
	
	@PostMapping(value = "/deleteconsumers")
	public ModelAndView deleteSpecialist(
			@ModelAttribute("findconsumer") FindConsumer findConsumer,BindingResult result,
			HttpServletRequest request) throws Exception {
		
		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-401");
			return login;
		}
		/*
		 * if token is set, 
		 * then allow access to view
		 */
		ModelAndView model = new ModelAndView("delete-consumer");
		if (findConsumer != null ) {
			
				/*
				 * get the package details by Name 
				 * using feign client of IPOfferingMicroservice
				 */
			try {
				client.deleteConsumer((String) request.getSession().getAttribute("Authorization"),findConsumer.getId());
				model.addObject("msg", "Consumer is deleted!");
			}
			catch(Exception e) {
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error","Enter Proper Id");
				return error;
			}
		}
		return model;
	}
	
	@ModelAttribute("businessCategory")
	public List<String> populateCategoryList() {
		return Arrays.asList("Permissible");
	}
	
	@ModelAttribute("businessType")
	public List<String> businessTypeList() {
		return Arrays.asList("Real Estate");
	}
	@ModelAttribute("propertyType")
	public List<String> propertyTypeList() {
		return Arrays.asList("Factory Equipment");

	}
	@ModelAttribute("buildingType")
	public List<String> buildingTypeList() {
		return Arrays.asList("owned");

	}

}
