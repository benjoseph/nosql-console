package org.tkm.backingbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.tkm.backingbeans.CRUD;
import org.tkm.backingbeans.ConfigManager;


@ManagedBean(name = "deviceService")
@ApplicationScoped
public class DeviceService {

	Device d=new Device();
	ConfigManager config=ConfigManager.get();
	CRUD db=config.connection();
	String UDID;

	public List<Device> createDevices(){
		db.createconn();
		List<Device> list = new ArrayList<Device>();
		for(int i = 1000000 ; i < 1000010 ; i++) {
			UDID = Integer.toString(i);
			d= db.read(UDID);
			list.add(d);
		}

		return list;
	}
}
