package lab.springmvc.dataBind.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lab.springmvc.dataBind.model.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Locale locale, Model model) {
	 * logger.info("Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}

	@ModelAttribute
	public void commonData(Model model) {
		model.addAttribute("headerMessage", "Welcome to Starve Technology");

		List<String> techList = new ArrayList<String>();
		techList.add("Hibernate");
		techList.add("Spring");
		techList.add("JSP");
		techList.add("Servlet");
		techList.add("Struts");

		List<String> citiesList = new ArrayList<String>();
		citiesList.add("Pune");
		citiesList.add("Chennai");
		citiesList.add("Delhi");
		citiesList.add("Other");

		List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");

		model.addAttribute("technologyList", techList);
		model.addAttribute("citisList", citiesList);
		model.addAttribute("genderList", genderList);
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register");
		}
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("student", student);
		return modelAndView;
	}

}
