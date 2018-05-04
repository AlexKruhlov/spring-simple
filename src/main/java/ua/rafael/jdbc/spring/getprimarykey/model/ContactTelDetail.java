package ua.rafael.jdbc.spring.getprimarykey.model;

public class ContactTelDetail {
	private Integer id;
	private Integer contactId;
	private String telType;
	private String telNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getTelType() {
		return telType;
	}

	public void setTelType(String telType) {
		this.telType = telType;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "ContactTelDetail [id=" + id + ", contactId=" + contactId + ", telType=" + telType + ", telNumber="
				+ telNumber + "]";
	}
}
