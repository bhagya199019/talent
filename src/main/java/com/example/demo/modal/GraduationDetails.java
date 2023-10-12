package com.example.demo.modal;

import jakarta.persistence.Embeddable;

@Embeddable
public class GraduationDetails {
 // @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
 // private int  gid;
  private String gcollegeName;  // "gcollegeName" instead of "gcollegeName"
private String gboard;        // "gboard" instead of "gboard"
private String gprogram;      // "gprogram" instead of "gprogram"
private String gpercentage;   // "gpercentage" instead of "gpercentage"
private String gyearOfPassing;// "gyearOfPassing" instead of "gyearOfPassing"
private String gCity;         // "gCity" instead of "gCity"
private String gState;
public String getGcollegeName() {
	return gcollegeName;
}
public void setGcollegeName(String gcollegeName) {
	this.gcollegeName = gcollegeName;
}
public String getGboard() {
	return gboard;
}
public void setGboard(String gboard) {
	this.gboard = gboard;
}
public String getGprogram() {
	return gprogram;
}
public void setGprogram(String gprogram) {
	this.gprogram = gprogram;
}
public String getGpercentage() {
	return gpercentage;
}
public void setGpercentage(String gpercentage) {
	this.gpercentage = gpercentage;
}
public String getGyearOfPassing() {
	return gyearOfPassing;
}
public void setGyearOfPassing(String gyearOfPassing) {
	this.gyearOfPassing = gyearOfPassing;
}
public String getgCity() {
	return gCity;
}
public void setgCity(String gCity) {
	this.gCity = gCity;
}
public String getgState() {
	return gState;
}
public void setgState(String gState) {
	this.gState = gState;
}
@Override
public String toString() {
	return "GraduationDetails [gcollegeName=" + gcollegeName + ", gboard=" + gboard + ", gprogram=" + gprogram
			+ ", gpercentage=" + gpercentage + ", gyearOfPassing=" + gyearOfPassing + ", gCity=" + gCity + ", gState="
			+ gState + "]";
}


}
