package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Attribute;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

public interface RuleService {
	
	public void addRule(Rule rule);
	
	public List<Rule> getLastRule();
	
	public List<Rule> getAllRule();
	
	public List<Attribute> getAttributesByRule(int id_rule);
	
	public void addRuleProj(RuleProj ruleProj);
	
	public void addAttribute(Attribute attribute);
	
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);

}
