package org.web.api.beans;

public class Search {
	
	
	private String flatNo;
	private String name;
	private String blockNo;
	private String email;
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "search [flatNo=" + flatNo + ", name=" + name + ", blockNo=" + blockNo + ", email=" + email + "]";
	}

	
}
