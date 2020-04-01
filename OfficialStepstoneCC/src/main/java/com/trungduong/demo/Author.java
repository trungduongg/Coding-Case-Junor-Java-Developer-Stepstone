package com.trungduong.demo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Author implements Serializable {
	@XmlElement
	public String approved;
	@XmlElement
	public String authordisplay;
	@XmlElement
	public String authorfirst;
	@XmlElement
	public String authorfirstlc;
	@XmlElement
	public int authorid;
	@XmlElement
	public String authorlast;
	@XmlElement
	public String authorlastfirst;
	@XmlElement
	public String authorlastlc;
	@XmlElement
	public Titles titles;
	@XmlElement
	public String lastinitial;
	@XmlElement
	public String photocredit;
	@XmlElement
	public int photodate;
	@XmlElement
	public String spotlight;
	@XmlElement
	public String works;

	public String toString() {
		return "" + authorid + ";" + authorlast + ", " + authorfirst + ";" + titles.sizeisbn() + "\n";
	}

}
