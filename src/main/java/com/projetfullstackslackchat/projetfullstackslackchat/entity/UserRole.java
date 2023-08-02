package com.projetfullstackslackchat.projetfullstackslackchat.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class UserRole {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long role_id;

	    @Column(name = "name")
	    private String name;
	    
	    @ManyToMany(mappedBy = "roles")
	    private List<User> users;

		public UserRole(String name) {
			super();
			this.name = name;
		}

		public UserRole() {
			super();
		}
	

        public Long getId() {
			return role_id;
		}

		public void setId(Long id) {
			this.role_id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "UserRole [role_id=" + role_id + ", name=" + name + ", users=" + users + "]";
		}
	    
	    
	
	
	
}
