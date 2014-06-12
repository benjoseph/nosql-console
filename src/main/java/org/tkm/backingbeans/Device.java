package org.tkm.backingbeans;

public class Device {

	public String udid;
	public String friendlyName;
	public String serialnum;
	public String manDate;
	
	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getManDate() {
		return manDate;
	}

	public void setManDate(String manDate) {
		this.manDate = manDate;
	}

	

	public void display() {
		System.out.println(udid);
		System.out.println(friendlyName);
		System.out.println(serialnum);
		System.out.println(manDate);
	}

}
