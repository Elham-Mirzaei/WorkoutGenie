package com.workoutgenie.presentation;

public class WorkoutResponse {
	private String planType;

	// Default constructor (required by Spring)
	public WorkoutResponse() {
	}

	// Constructor with plan type
	public WorkoutResponse(String planType) {
		this.planType = planType;
	}

	// Getter and Setter
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}
}
