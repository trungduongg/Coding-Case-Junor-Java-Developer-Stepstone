package com.trungduong.demo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Titles implements Serializable {
	@XmlElement
	public List<String> isbn;

	public int sizeisbn() {
		if (isbn != null) {
			return isbn.size();
		} else {
			return 0;
		}
	}

}
