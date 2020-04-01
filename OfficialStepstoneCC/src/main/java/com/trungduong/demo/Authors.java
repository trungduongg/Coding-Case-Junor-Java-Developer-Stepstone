package com.trungduong.demo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Authors implements Serializable {
	@XmlElement
	public List<Author> author;

	public String toString() {
		String printout = "";
		for (Author au : author) {
			printout += au.toString();
		}
		return printout;
	}
}
