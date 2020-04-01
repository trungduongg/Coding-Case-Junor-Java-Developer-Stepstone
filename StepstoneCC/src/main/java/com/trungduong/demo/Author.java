package com.trungduong.demo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Author implements Serializable {
	@XmlElement
	public int authorid;
	@XmlElement
	public String authorlast;
	@XmlElement(nillable = true)
	public Title titles;
	@XmlElement
	public String authordisplay;
	@XmlElement
	public String approved;
	@XmlElement
	public String authorfirst;
	@XmlElement
	public String authorfirstlc;
	@XmlElement
	public String authorlastfirst;
	@XmlElement
	public String authorlastlc;
	@XmlElement
	public String lastinitial;
	@XmlElement(nillable = true)
	public String photocredit;
	@XmlElement(nillable = true)
	public int photodate;
	@XmlElement(nillable = true)
	public String spotlight;
	@XmlElement
	public Work works;

	public String toString() {
		return "" + authorid + ";" + authorlast + ", " + authorfirst + ";" + titles.sizeisbn() + "\n";

	}

}
