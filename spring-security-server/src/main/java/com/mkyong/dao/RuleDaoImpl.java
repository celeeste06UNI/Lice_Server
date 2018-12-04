package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Attribute;
import com.mkyong.model.Organization;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

@Repository
public class RuleDaoImpl implements RuleDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addRule(Rule rule) {
		sessionFactory.getCurrentSession().saveOrUpdate(rule);
		
	}

	public List<Rule> getLastRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = sessionFactory.getCurrentSession().createQuery("from Rule order by id_rule ASC").list();
		if (listRule != null) {
			return listRule;
		} else {
			return null;
		}
	}

	public void addRuleProj(RuleProj ruleProj) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruleProj);
		
	}

	public void addAttribute(Attribute attribute) {
		sessionFactory.getCurrentSession().saveOrUpdate(attribute);
		
	}

	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruleProjCatalogue);
		
	}

}
