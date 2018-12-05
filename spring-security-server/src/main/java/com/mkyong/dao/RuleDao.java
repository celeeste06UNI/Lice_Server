package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Attribute;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

public interface RuleDao {
	
	public void addRule(Rule rule);
	
	public List<Rule> getLastRule();
	
	public List<Rule> getAllRule();
	
	public void addRuleProj(RuleProj ruleProj);
	
	public void addAttribute(Attribute attribute);
	
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);
	
	public List<Attribute> getAttributesByRule(int id_rule);

}
