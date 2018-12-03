package com.mkyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;
import com.mkyong.service.RuleService;
import com.mkyong.model.Attribute;

@RestController
@RequestMapping(value = "/rule")
public class RuleController {
	
	@Autowired
	private RuleService ruleService;

	@RequestMapping(value = "/addRule", method = RequestMethod.POST)
	public void addRule(@RequestParam(value = "id_rule") int id_rule, @RequestParam(value = "property") String property,
			@RequestParam(value = "state") String state, @RequestParam(value = "criticity") String criticity,
			@RequestParam(value = "priority") String priority, @RequestParam(value = "version") String version)
			throws ServletException, IOException, Exception {
		Rule rule = new Rule(id_rule, property, state, criticity, priority, version);
		ruleService.addRule(rule);
	}

	@RequestMapping(value = "/addRuleProj", method = RequestMethod.POST)
	public void addRuleProj(@RequestParam(value = "id_rule") int id_rule,
			@RequestParam(value = "id_project") int id_project) throws ServletException, IOException, Exception {
		RuleProj ruleProj = new RuleProj(id_rule, id_project);
		ruleService.addRuleProj(ruleProj);
	}

	@RequestMapping(value = "/addAttribute", method = RequestMethod.POST)
	public void addAttribute(@RequestParam(value = "id_attribute") int id_attribute,
			@RequestParam(value = "id_rule") int id_rule, @RequestParam(value = "modal_operator") String modal_operator,
			@RequestParam(value = "term") String term, @RequestParam(value = "verb") String verb,
			@RequestParam(value = "logical_operator") String logical_operator,
			@RequestParam(value = "term_value") String term_value) throws ServletException, IOException, Exception {
		Attribute attribute = new Attribute(id_attribute, id_rule, modal_operator, term, verb, logical_operator,
				term_value);
		ruleService.addAttribute(attribute);
	}

	@RequestMapping(value = "/addRuleProjCatalogue", method = RequestMethod.POST)
	public void addRuleProjCatalogue(@RequestParam(value = "id_rule") int id_rule,
			@RequestParam(value = "id_project") int id_project, @RequestParam(value = "id_catalogue") int id_catalogue)
			throws ServletException, IOException, Exception {
		RuleProjCatalogue ruleProjectCatalogue = new RuleProjCatalogue(id_rule, id_project, id_catalogue);
		ruleService.addRuleProjCatalogue(ruleProjectCatalogue);
	}
	
	@RequestMapping(value = "/getLastRule", method = RequestMethod.GET, produces = "application/json")
	public List<Rule> getLastRule() {
		List<Rule> list = new ArrayList<Rule>();
		list = ruleService.getLastRule();
		return list;

	}

}
