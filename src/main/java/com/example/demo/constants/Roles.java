package com.example.demo.constants;

public enum Roles {

	SPEAKER(0, "Speaker"),
	ATTENDEE(1, "Attendee");

	public int  key;
	public String value;

	Roles(int key, String value) {
		this.key = key;
		this.value = value;
	}

}