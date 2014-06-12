package org.tkm.backingbeans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dtBasicView")
@ViewScoped
public class BasicView implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private List<Device> devices;

@ManagedProperty("#{deviceService}")
private DeviceService service;

@PostConstruct
	public void init() {
	devices = service.createDevices();
}

public List<Device> getDevices() {
return devices;
}

public void setService(DeviceService service) {
	this.service = service;
}
}