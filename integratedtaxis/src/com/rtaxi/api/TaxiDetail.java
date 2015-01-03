package com.rtaxi.api;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TaxiDetail {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long trequestid; // 0
	@Persistent
	String tpickupaddress;// 1
	@Persistent
	String tpickupgeotag;// 1

	@Persistent
	String tdropaddress;// 2
	@Persistent
	String tdropgeotag;// 1

	/**
	 * @return the tpickupgeotag
	 */
	public String getTpickupgeotag() {
		return tpickupgeotag;
	}

	/**
	 * @param tpickupgeotag the tpickupgeotag to set
	 */
	public void setTpickupgeotag(String tpickupgeotag) {
		this.tpickupgeotag = tpickupgeotag;
	}

	/**
	 * @return the tdropgeotag
	 */
	public String getTdropgeotag() {
		return tdropgeotag;
	}

	/**
	 * @param tdropgeotag the tdropgeotag to set
	 */
	public void setTdropgeotag(String tdropgeotag) {
		this.tdropgeotag = tdropgeotag;
	}

	@Persistent
	String tstartdate;// 3
	@Persistent
	String tstarttimehr;// 4
	@Persistent
	String tstarttimemin;// 4
	@Persistent
	String tclientname; // 5
	@Persistent
	String tclientemail; // 6
	@Persistent
	String tclientmobile;// 7
	@Persistent
	String tclientremarks;// 8
	@Persistent
	String tstarttag;// 10
	@Persistent
	String tclientipaddress;// 11
	@Persistent
	String tcliententrymode;// 12
	@Persistent
	String tagentname;// 13
	@Persistent
	String tagentmobile;// 14
	@Persistent
	String tagentemail;
	@Persistent
	String tagentvehileno;// 15
	/**
	 * @return the tagentemail
	 */
	public String getTagentemail() {
		return tagentemail;
	}

	/**
	 * @param tagentemail the tagentemail to set
	 */
	public void setTagentemail(String tagentemail) {
		this.tagentemail = tagentemail;
	}

	@Persistent
	String tagentremarks;// 16
	@Persistent
	String tagentotp;// 17
	@Persistent
	String tbookstatus;// 18
	@Persistent
	String tagentipaddress;// 19
	@Persistent
	String tagententrymode;// 20
	@Persistent
	String tagentvehiletype;// 21

	@Persistent
	String trecordtype;// 21

	
	/**
	 * @return the trecordtype
	 */
	public String getTrecordtype() {
		return trecordtype;
	}

	/**
	 * @param trecordtype the trecordtype to set
	 */
	public void setTrecordtype(String trecordtype) {
		this.trecordtype = trecordtype;
	}

	@Persistent
	boolean troundtrip;// 21

	@Persistent
	boolean tmorethanday;// 21

	/**
	 * @return the troundtrip
	 */
	public boolean isTroundtrip() {
		return troundtrip;
	}

	/**
	 * @param troundtrip
	 *            the troundtrip to set
	 */
	public void setTroundtrip(boolean troundtrip) {
		this.troundtrip = troundtrip;
	}

	/**
	 * @return the tmorethanday
	 */
	public boolean isTmorethanday() {
		return tmorethanday;
	}

	/**
	 * @param tmorethanday
	 *            the tmorethanday to set
	 */
	public void setTmorethanday(boolean tmorethanday) {
		this.tmorethanday = tmorethanday;
	}

	/**
	 * @return the tagentvehiletype
	 */
	public String getTagentvehiletype() {
		return tagentvehiletype;
	}

	/**
	 * @param tagentvehiletype
	 *            the tagentvehiletype to set
	 */
	public void setTagentvehiletype(String tagentvehiletype) {
		this.tagentvehiletype = tagentvehiletype;
	}

	/**
	 * @return the trequestid
	 */
	public Long getTrequestid() {
		return trequestid;
	}

	/**
	 * @param trequestid
	 *            the trequestid to set
	 */
	public void setTrequestid(Long trequestid) {
		this.trequestid = trequestid;
	}

	/**
	 * @return the tclientname
	 */
	public String getTclientname() {
		return tclientname;
	}

	/**
	 * @param tclientname
	 *            the tclientname to set
	 */
	public void setTclientname(String tclientname) {
		this.tclientname = tclientname;
	}

	/**
	 * @return the tclientemail
	 */
	public String getTclientemail() {
		return tclientemail;
	}

	/**
	 * @param tclientemail
	 *            the tclientemail to set
	 */
	public void setTclientemail(String tclientemail) {
		this.tclientemail = tclientemail;
	}

	/**
	 * @return the tclientmobile
	 */
	public String getTclientmobile() {
		return tclientmobile;
	}

	/**
	 * @param tclientmobile
	 *            the tclientmobile to set
	 */
	public void setTclientmobile(String tclientmobile) {
		this.tclientmobile = tclientmobile;
	}

	/**
	 * @return the tpickupaddress
	 */
	public String getTpickupaddress() {
		return tpickupaddress;
	}

	/**
	 * @param tpickupaddress
	 *            the tpickupaddress to set
	 */
	public void setTpickupaddress(String tpickupaddress) {
		this.tpickupaddress = tpickupaddress;
	}

	/**
	 * @return the tdropaddress
	 */
	public String getTdropaddress() {
		return tdropaddress;
	}

	/**
	 * @param tdropaddress
	 *            the tdropaddress to set
	 */
	public void setTdropaddress(String tdropaddress) {
		this.tdropaddress = tdropaddress;
	}

	/**
	 * @return the tstartdate
	 */
	public String getTstartdate() {
		return tstartdate;
	}

	/**
	 * @param tstartdate
	 *            the tstartdate to set
	 */
	public void setTstartdate(String tstartdate) {
		this.tstartdate = tstartdate;
	}

	/**
	 * @return the tclientremarks
	 */
	public String getTclientremarks() {
		return tclientremarks;
	}

	/**
	 * @param tclientremarks
	 *            the tclientremarks to set
	 */
	public void setTclientremarks(String tclientremarks) {
		this.tclientremarks = tclientremarks;
	}

	/**
	 * @return the tstarttag
	 */
	public String getTstarttag() {
		return tstarttag;
	}

	/**
	 * @param tstarttag
	 *            the tstarttag to set
	 */
	public void setTstarttag(String tstarttag) {
		this.tstarttag = tstarttag;
	}

	/**
	 * @return the tclientipaddress
	 */
	public String getTclientipaddress() {
		return tclientipaddress;
	}

	/**
	 * @param tclientipaddress
	 *            the tclientipaddress to set
	 */
	public void setTclientipaddress(String tclientipaddress) {
		this.tclientipaddress = tclientipaddress;
	}

	/**
	 * @return the tcliententrymode
	 */
	public String getTcliententrymode() {
		return tcliententrymode;
	}

	/**
	 * @param tcliententrymode
	 *            the tcliententrymode to set
	 */
	public void setTcliententrymode(String tcliententrymode) {
		this.tcliententrymode = tcliententrymode;
	}

	/**
	 * @return the tagentname
	 */
	public String getTagentname() {
		return tagentname;
	}

	/**
	 * @param tagentname
	 *            the tagentname to set
	 */
	public void setTagentname(String tagentname) {
		this.tagentname = tagentname;
	}

	/**
	 * @return the tagentmobile
	 */
	public String getTagentmobile() {
		return tagentmobile;
	}

	/**
	 * @param tagentmobile
	 *            the tagentmobile to set
	 */
	public void setTagentmobile(String tagentmobile) {
		this.tagentmobile = tagentmobile;
	}

	/**
	 * @return the tstarttimehr
	 */
	public String getTstarttimehr() {
		return tstarttimehr;
	}

	/**
	 * @param tstarttimehr
	 *            the tstarttimehr to set
	 */
	public void setTstarttimehr(String tstarttimehr) {
		this.tstarttimehr = tstarttimehr;
	}

	/**
	 * @return the tstarttimemin
	 */
	public String getTstarttimemin() {
		return tstarttimemin;
	}

	/**
	 * @param tstarttimemin
	 *            the tstarttimemin to set
	 */
	public void setTstarttimemin(String tstarttimemin) {
		this.tstarttimemin = tstarttimemin;
	}

	/**
	 * @return the tagentvehileno
	 */
	public String getTagentvehileno() {
		return tagentvehileno;
	}

	/**
	 * @param tagentvehileno
	 *            the tagentvehileno to set
	 */
	public void setTagentvehileno(String tagentvehileno) {
		this.tagentvehileno = tagentvehileno;
	}

	/**
	 * @return the tagentremarks
	 */
	public String getTagentremarks() {
		return tagentremarks;
	}

	/**
	 * @param tagentremarks
	 *            the tagentremarks to set
	 */
	public void setTagentremarks(String tagentremarks) {
		this.tagentremarks = tagentremarks;
	}

	/**
	 * @return the tagentotp
	 */
	public String getTagentotp() {
		return tagentotp;
	}

	/**
	 * @param tagentotp
	 *            the tagentotp to set
	 */
	public void setTagentotp(String tagentotp) {
		this.tagentotp = tagentotp;
	}

	/**
	 * @return the tbookstatus
	 */
	public String getTbookstatus() {
		return tbookstatus;
	}

	/**
	 * @param tbookstatus
	 *            the tbookstatus to set
	 */
	public void setTbookstatus(String tbookstatus) {
		this.tbookstatus = tbookstatus;
	}

	/**
	 * @return the tagentipaddress
	 */
	public String getTagentipaddress() {
		return tagentipaddress;
	}

	/**
	 * @param tagentipaddress
	 *            the tagentipaddress to set
	 */
	public void setTagentipaddress(String tagentipaddress) {
		this.tagentipaddress = tagentipaddress;
	}

	/**
	 * @return the tagententrymode
	 */
	public String getTagententrymode() {
		return tagententrymode;
	}

	/**
	 * @param tagententrymode
	 *            the tagententrymode to set
	 */
	public void setTagententrymode(String tagententrymode) {
		this.tagententrymode = tagententrymode;
	}

}
