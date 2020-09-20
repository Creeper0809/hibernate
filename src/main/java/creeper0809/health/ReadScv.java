package creeper0809.health;

import java.io.IOException;

import org.hibernate.Session;

import creeper0809.data.SiNum;

public class ReadScv {
	Session session;
	ReadSiNum SiNum;
	ReadSiDoGunNum SiDoGunNum;
	ReadInfectName InfectName;
	ReadInfectInfo InfectInfo;

	public ReadScv(Session session) {
		this.session = session;
		SiNum = new ReadSiNum();
		SiDoGunNum = new ReadSiDoGunNum(this);
		InfectName = new ReadInfectName();
		InfectInfo = new ReadInfectInfo(this);
	}
	public void readSiNum() {
		try {
			SiNum.readScv(session);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readSiDoGunNum() {
		try {
			SiDoGunNum.readScv(session);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readInfectName() {
		try {
			InfectName.readScv(session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readInfectInfo() {
		try {
			InfectInfo.readScv(session);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
