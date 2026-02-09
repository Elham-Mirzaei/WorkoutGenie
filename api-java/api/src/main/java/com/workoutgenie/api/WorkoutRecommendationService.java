package com.workoutgenie.api;

public class WorkoutRecommendationService {

	    public String getPlan(WorkoutRequest req) {
	        String experience = req.getExperience().toLowerCase();
	        String goal = req.getGoal().toLowerCase();
	        int days = req.getAvailableDays();

	        // Beginner: always full body
	        if (experience.equals("beginner")) {
	            return "FULL_BODY_3X";
	        }

	        // Intermediate rules
	        if (experience.equals("intermediate")) {
	            if (goal.equals("muscle_gain")) {
	                if (days == 3) return "FULL_BODY_3X";
	                if (days == 4) return "UPPER_LOWER_4X";
	                if (days >= 5) return "PUSH_PULL_LEGS";
	            } else if (goal.equals("fat_loss")) {
	                if (days <= 4) return "HIIT_FAT_LOSS";
	                if (days >= 5) return "FULL_BODY_3X";
	            }
	        }

	        // Advanced rules
	        if (experience.equals("advanced")) {
	            if (goal.equals("muscle_gain")) {
	                if (days < 5) return "UPPER_LOWER_4X";
	                if (days >= 5) return "PUSH_PULL_LEGS";
	            } else if (goal.equals("fat_loss")) {
	                if (days <= 3) return "HIIT_FAT_LOSS";
	                if (days >= 4) return "UPPER_LOWER_4X";
	            }
	        }

	        // Fallback plan
	        return "FULL_BODY_3X";
	    }
	}
