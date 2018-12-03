package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.RuleDao;
import com.mkyong.model.Attribute;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

@Service
@Transactional
public class RuleServiceImpl implements RuleService{
	
	@Autowired
	private RuleDao ruleDao;
	
	@Transactional
	public void addRule(Rule rule) {
		ruleDao.addRule(rule);
		
	}
	@Transactional
	public List<Rule> getLastRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = ruleDao.getLastRule();
		return listRule;
	}
	@Transactional
	public void addRuleProj(RuleProj ruleProj) {
		ruleDao.addRuleProj(ruleProj);
	}
	@Transactional
	public void addAttribute(Attribute attribute) {
		ruleDao.addAttribute(attribute);
		
	}
	@Transactional
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		ruleDao.addRuleProjCatalogue(ruleProjCatalogue);
	}

}
