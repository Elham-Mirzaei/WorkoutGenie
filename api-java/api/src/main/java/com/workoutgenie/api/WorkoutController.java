package com.workoutgenie.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommend")
public class WorkoutController {
	private WorkoutRecommendationService service = new WorkoutRecommendationService();

    @PostMapping
    public WorkoutResponse recommendWorkout(@RequestBody WorkoutRequest req) {
        String plan = service.getPlan(req);
        return new WorkoutResponse(plan);
	}
}
