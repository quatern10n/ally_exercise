package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_UNICORN")
public class Unicorn {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String hairColor;
	private int hornLength;
	private String hornColor;
	private int height;
	private String heightUnit;
	private int weight;
	private String weightUnit;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private List<IdentifiableMark> identifiableMarks;
	
	protected Unicorn() {
		//default constructor, for JPA
	}
	
    public Unicorn(String nm, String hairClr, int hrnLen, String hornClr, int ht, String htUnits, int wt, String wtUnits) {
    	identifiableMarks = new ArrayList<>();
    	this.name =nm;
    	this.hairColor = hairClr;
    	this.hornLength = hrnLen;
    	this.hornColor = hornClr;
    	this.height = ht;
    	this.heightUnit = htUnits;
    	this.weight = wt;
    	this.weightUnit = wtUnits;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public String getHornColor() {
		return hornColor;
	}

	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public List<IdentifiableMark> getIdentifiableMarks() {
		return identifiableMarks;
	}

	public void setIdentifiableMarks(List<IdentifiableMark> identifyingMarks) {
		this.identifiableMarks = identifyingMarks;
	}
	
	public void addIdentifiableMarks(IdentifiableMark mark) {
		this.identifiableMarks.add(mark);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Unicorn: [");
		buffer.append("name: "+this.name);
		buffer.append(", hairColor: "+this.hairColor);
		buffer.append(", hornColor: "+this.hornColor);
		buffer.append(", height: "+this.height);
		buffer.append(", weight: "+this.weight);
		return buffer.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
}
