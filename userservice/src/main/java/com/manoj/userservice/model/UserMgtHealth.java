package com.manoj.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USER_MGT_HEALTH")
@Getter @Setter @ToString
public class UserMgtHealth extends DateAudit{
	private static final long serialVersionUID = 2874318451291991178L;
	
	@Id
	@Column(name = "health_id")
	private long healthId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	
}
