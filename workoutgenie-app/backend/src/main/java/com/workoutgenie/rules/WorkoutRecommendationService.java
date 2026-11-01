package com.workoutgenie.rules;

import com.workoutgenie.validation.WorkoutRequest;

public class WorkoutRecommendationService {

	public String getPlan(WorkoutRequest req) {

		String experience = req.getExperience().toLowerCase();
		String goal = req.getGoal().toLowerCase();
		int days = req.getAvailableDays();

		// Beginner rules
		if (experience.equals("beginner")) {

			if (goal.equals("general_fitness")) {
				if (days == 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				if (days >= 4) return "CARDIO_STRENGTH";
			}

			if (goal.equals("muscle_gain")) {
				if (days == 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				else throw new InvalidWorkoutRequestException(
						"Beginners who want to gain muscle can train 2 or 3 days per week.");
			}

			if (goal.equals("fat_loss")) {
				if (days == 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				return "CARDIO_STRENGTH";
			}

			if (goal.equals("strength")) {
				if (days == 3) return "STRENGTH_3X";
				else throw new InvalidWorkoutRequestException(
						"Beginners who want to build strength can train 3 days per week.");
			}
		}

		// Intermediate rules
		if (experience.equals("intermediate")) {

			if (goal.equals("muscle_gain")) {
				if (days <= 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				if (days == 4) return "UPPER_LOWER_4X";
				if (days >= 5) return "PUSH_PULL_LEGS";
			}

			if (goal.equals("fat_loss")) {
				if (days <= 3) return "HIIT_FAT_LOSS";
				if (days >= 4) return "CARDIO_STRENGTH";
			}

			if (goal.equals("general_fitness")) {
				if (days == 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				if (days >= 4) return "CARDIO_STRENGTH";
			}

			if (goal.equals("strength")) {
				if (days == 3) return "STRENGTH_3X";
				if (days == 4) return "UPPER_LOWER_4X";
				else throw new InvalidWorkoutRequestException(
						"Intermediate lifters who want to build strength can train 3 or 4 days per week.");
			}
		}

		// Advanced rules
		if (experience.equals("advanced")) {

			if (goal.equals("muscle_gain")) {
				if (days == 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				if (days == 4) return "UPPER_LOWER_4X";
				if (days >= 5) return "PUSH_PULL_LEGS";
			}

			if (goal.equals("fat_loss")) {
				if (days <= 3) return "HIIT_FAT_LOSS";
				if (days >= 4) return "CARDIO_STRENGTH";
			}

			if (goal.equals("general_fitness")) {
				if (days <= 2) return "FULL_BODY_2X";
				if (days == 3) return "FULL_BODY_3X";
				if (days >= 4) return "CARDIO_STRENGTH";
			}

			if (goal.equals("strength")) {
				if (days == 3) return "STRENGTH_3X";
				if (days == 4) return "UPPER_LOWER_4X";
				else throw new InvalidWorkoutRequestException(
						"Advanced lifters who want to build strength can train 3 or 4 days per week.");
			}
		}

		// Fallback plan
		return "FULL_BODY_3X";
	}
}