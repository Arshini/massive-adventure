package com.rtaxi.api;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AgentDetail {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long tagentid; // 0

	@Persistent
	String tagentname;

	@Persistent
	String tagentemail;

	@Persistent
	String tagentmobile;

	@Persistent
	String tagentvehicle;

	@Persistent
	String tagentaddress;

	@Persistent
	String tagentremarks;

	@Persistent
	String tagentstatus;
	@Persistent
	String tagentpriority;

	public String getTagentpriority() {
		return tagentpriority;
	}

	public void setTagentpriority(String tagentpriority) {
		this.tagentpriority = tagentpriority;
	}

	/**
	 * @return the tagentgeotag
	 */
	public String getTagentgeotag() {
		return tagentgeotag;
	}

	/**
	 * @param tagentgeotag
	 *            the tagentgeotag to set
	 */
	public void setTagentgeotag(String tagentgeotag) {
		this.tagentgeotag = tagentgeotag;
	}

	@Persistent
	String tagentgeotag;

	/**
	 * @return the tagentid
	 */
	public Long getTagentid() {
		return tagentid;
	}

	/**
	 * @param tagentid
	 *            the tagentid to set
	 */
	public void setTagentid(Long tagentid) {
		this.tagentid = tagentid;
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
	 * @return the tagentemail
	 */
	public String getTagentemail() {
		return tagentemail;
	}

	/**
	 * @param tagentemail
	 *            the tagentemail to set
	 */
	public void setTagentemail(String tagentemail) {
		this.tagentemail = tagentemail;
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
	 * @return the tagentvehicle
	 */
	public String getTagentvehicle() {
		return tagentvehicle;
	}

	/**
	 * @param tagentvehicle
	 *            the tagentvehicle to set
	 */
	public void setTagentvehicle(String tagentvehicle) {
		this.tagentvehicle = tagentvehicle;
	}

	/**
	 * @return the tagentaddress
	 */
	public String getTagentaddress() {
		return tagentaddress;
	}

	/**
	 * @param tagentaddress
	 *            the tagentaddress to set
	 */
	public void setTagentaddress(String tagentaddress) {
		this.tagentaddress = tagentaddress;
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
	 * @return the tagentstatus
	 */
	public String getTagentstatus() {
		return tagentstatus;
	}

	/**
	 * @param tagentstatus
	 *            the tagentstatus to set
	 */
	public void setTagentstatus(String tagentstatus) {
		this.tagentstatus = tagentstatus;
	}

}
