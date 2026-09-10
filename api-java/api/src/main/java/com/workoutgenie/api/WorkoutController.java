package com.workoutgenie.api;

import com.workoutgenie.presentation.WorkoutResponse;
import com.workoutgenie.rules.WorkoutRecommendationService;
import com.workoutgenie.validation.WorkoutRequest;
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
