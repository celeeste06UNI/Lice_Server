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
	
	public List<Rule> getRule(int id_rule);
	
	public List<RuleProj> getRulesByProject(int id_project);
	
	public void addRuleProj(RuleProj ruleProj);
	
	public void addAttribute(Attribute attribute);
	
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);
	
	public List<Attribute> getAttributesByRule(int id_rule);
	
	public void deleteRule(int id_rule);
	
	public void updateRule(Rule rule);
	
	public void updateRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue);
	
	public List<RuleProjCatalogue> getRuleProjCatalogue(int id_rule);

}
