package com.yh.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="COST")
public class Cost implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cost_seq1")
	@SequenceGenerator(name="cost_seq1",sequenceName="COST_SEQ",initialValue=1,allocationSize=1)
	@Column(name="COST_ID")
	private Integer costId;
	@Column(name="NAME")
	private String name;
	@Column(name="BASE_DURATION")
	private Integer baseDuration;
	@Column(name="BASE_COST")
	private Double baseCost;
	@Column(name="UNIT_COST")
	private Double unitCost;
	@Column(name="STATUS")
	private String status;
	@Column(name="DESCR")
	private String descr;
	@Column(name="CREATIME")
	private Date creatime;
	@Column(name="STARTIME")
	private Date startime;
	@Column(name="COST_TYPE")
	private String costType;
	
	public Cost(){}

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseDuration() {
		return baseDuration;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}
	
}
