package com.hello.springboothello.ex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id		// PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// db에 값을 넣으면 id 자동 생성해줌
	private Long id;
	
	// @Column(name = "username")  	db의 컬럼명이 username이면 이렇게 써주고, 같으면 그냥 두기
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
