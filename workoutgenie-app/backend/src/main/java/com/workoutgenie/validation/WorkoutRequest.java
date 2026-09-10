package com.workoutgenie.validation;

public class WorkoutRequest {
	int age;
	String gender;
	double weight;
	double height;
	String goal;
	String experience;
	int availableDays;

	// Default constructor (required by Spring)
	public WorkoutRequest() {
	}

	// Getters and Setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getAvailableDays() {
		return availableDays;
	}

	public void setAvailableDays(int availableDays) {
		this.availableDays = availableDays;
	}
}
