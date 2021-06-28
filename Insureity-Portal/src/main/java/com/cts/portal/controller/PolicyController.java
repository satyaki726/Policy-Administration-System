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

import com.cts.portal.feign.PolicyClient;
import com.cts.portal.policymodel.BusinessDetails;
import com.cts.portal.policymodel.ConsumerDetails;
import com.cts.portal.policymodel.ConsumerPolicy;
import com.cts.portal.policymodel.ConsumerPolicyRequest;
import com.cts.portal.policymodel.FindPolicy;
import com.cts.portal.policymodel.PolicyMaster;
import com.cts.portal.policymodel.PropertyDetails;

@Controller
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	PolicyClient client;

	@GetMapping("/createPolicy")
	public String showView(@ModelAttribute("policyMaster") PolicyMaster policyMaster, BindingResult result) {
		return "create-policy";
	}

	@PostMapping("/createPolicy")
	public ModelAndView createPol(@ModelAttribute("policyMaster") PolicyMaster policyMaster, BindingResult result,
			HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-401");
			return login;
		}

		ModelAndView model = new ModelAndView("create-policy");

		// (String) request.getSession().getAttribute("Authorization")
		if (policyMaster != null) {
			try {
				client.createPolicy((String) request.getSession().getAttribute("Authorization"), policyMaster);
				model.addObject("success", "Policy added successfully!!");

			} catch (Exception e) {
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error", "Please Add Details Properly!!!");
				return error;
			}
		}

		return model;
	}

	@GetMapping("/issuePolicy")
	public String showPolicy(@ModelAttribute("consumerPolicyRequest") ConsumerPolicyRequest consumerPolicyRequest,
			BindingResult result) {
		return "issue-policy";
	}

	@PostMapping("/issuePolicy")
	public ModelAndView issuePolicy(
			@ModelAttribute("consumerPolicyRequest") ConsumerPolicyRequest consumerPolicyRequest, BindingResult result,
			HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {

			ModelAndView login = new ModelAndView("error-401");
			return login;
		}

		ModelAndView model = new ModelAndView("issue-policy");

		if (consumerPolicyRequest != null) {
			try {
				ConsumerDetails con = client.issuePolicy((String) request.getSession().getAttribute("Authorization"), consumerPolicyRequest);
				model.addObject("success", "Policy issued for Consumer!!");
				List<Long> cp = new ArrayList<>();
				List<BusinessDetails> business = con.getBusiness();
				for(BusinessDetails b: business)
				{
					List<PropertyDetails> property = b.getProperty();
					for(PropertyDetails p : property) {
						ConsumerPolicy co = p.getConsumerPolicy();
						cp.add(co.getId());
					}
				}
				model.addObject("success","Successfully issued");
				model.addObject("list",cp);

			} catch (Exception e) {
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error", "Please Add Details Properly!!!");
				return error;
			}
		}

		return model;
	}

	@GetMapping(value = "/viewPolicy")
	public ModelAndView getConsumer(@ModelAttribute("findPolicy") FindPolicy findPolicy,
			HttpServletRequest request) throws Exception {

		if ((String) request.getSession().getAttribute("Authorization") == null) {
			ModelAndView login = new ModelAndView("error-401");
			return login;
		}
		/*
		 * if token is set, then allow access to view
		 */
		ModelAndView model = new ModelAndView("view-policy");
		if (findPolicy != null && findPolicy.getCid() != null && findPolicy.getPid() != null) {

			/*
			 * get the package details by Name using feign client of IPOfferingMicroservice
			 */
			try {
				List<ConsumerPolicy> list = client.viewPolicyCon((String) request.getSession().getAttribute("Authorization"), findPolicy.getCid(), findPolicy.getPid());
				model.addObject("list", list);
			} catch (Exception e) {
				// TODO: handle exception
				ModelAndView error = new ModelAndView("error-401");
				error.addObject("error", "Enter Proper Id");
				return error;
			}
		}
		return model;
	}
	@ModelAttribute("propertyType")
	public List<String> propertyTypeList() {
		return Arrays.asList("Factory Equipment");

	}
	@ModelAttribute("consumerType")
	public List<String> consumerTypeList() {
		return Arrays.asList("owner");

	}
}
