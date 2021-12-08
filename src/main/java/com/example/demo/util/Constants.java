package com.example.demo.util;

public class Constants {

	public static final String APPSMITH_DEMO_DEVELOPED_BY = "This is demo application developed by Jaydeep Dhameliya";
    public static final String TITLE = "Appsmith Talks Application";

    // User Constants
    public static final String USER_SUMMARY = "Create speakers and attendee";
    public static final String USER_CREATE_DESCRIPTION = "Use this API to create speakers and attendee. You must need to specifiy role for it. Please use 0 - Speaker and 1 - Attendee";
    public static final String USER_TAGS = "User";
    public static final String USER_DTO_EMAIL_ADDRESS_MESSAGE = "Please enter valid email address";
    public static final String USER_DTO_MOBILE_NUMBER_MESSAGE = "Enter mobile number of 10 digits";
    public static final String USER_DTO_FIRST_NAME_MESSAGE = "First name can not be blank";
    public static final String USER_DTO_LAST_NAME_MESSAGE = "Last name can not be blank";
    public static final String USER_DTO_ROLE_MESSAGE = "Must specify role";

    // Talks Constants
    public static final String TALKS_SUMMARY = "Create talks";
    public static final String TALKS_CREATE_DESCRIPTION = "Use this API to create a new talk";
    public static final String TALKS_RETRIEVE_SUMMARY = "Retrieve talks";
    public static final String TALKS_RETRIEVE_DESCRIPTION = "Use this API to retrieve talks by speaker and search by title or description";
    public static final String TALKS_TAGS = "Talks";
    public static final String TALKS_DTO_TITLE_MESSAGE = "Please add title";
    public static final String TALKS_DTO_DESCRIPTION_MESSAGE = "Please add description";
    public static final String TALKS_DTO_START_DATE_MESSAGE = "Please add start date";
    public static final String TALKS_DTO_END_DATE_MESSAGE = "Please add end date";
    public static final String TALKS_DTO_SPEAKER_ID_MESSAGE = "Please add speakerId";

    // Attendee Constants
    public static final String ATTENDEE_SUMMARY = "Register attendee for talks";
    public static final String ATTENDEE_CREATE_DESCRIPTION = "Register attendee for talks";
    public static final String ATTENDEE_TAGS = "Attendee";
    public static final String ATTENDEE_DTO_TALKS_ID_MESSAGE = "talksId is required";
    public static final String ATTENDEE_DTO_USER_ID_MESSAGE = "userId is required";

}