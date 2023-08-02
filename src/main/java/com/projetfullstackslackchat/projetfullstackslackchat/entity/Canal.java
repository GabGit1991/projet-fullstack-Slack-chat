package com.projetfullstackslackchat.projetfullstackslackchat.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "canals")
public class Canal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String canalName;

	@OneToMany(fetch = FetchType.EAGER)
	private List<User> assignedUsers;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Message> assignedMessages;

	public Canal() {
	}

	public Canal(String canalName, List<User> assignedUsers, List<Message> assignedMessages) {
		this.canalName = canalName;
		this.assignedUsers = assignedUsers;
		this.assignedMessages = assignedMessages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCanalName() {
		return canalName;
	}

	public void setCanalName(String canalName) {
		this.canalName = canalName;
	}

	public List<User> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(List<User> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}

	public List<Message> getAssignedMessages() {
		return assignedMessages;
	}

	public void setAssignedMessages(List<Message> assignedMessages) {
		this.assignedMessages = assignedMessages;
	}

	@Override
	public String toString() {
		return "Canal [id=" + id + ", canalName=" + canalName + ", assignedUsers=" + assignedUsers
				+ ", assignedMessages=" + assignedMessages + "]";
	}

}
