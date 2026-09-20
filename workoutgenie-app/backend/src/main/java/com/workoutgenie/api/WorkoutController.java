package com.workoutgenie.api;

import com.workoutgenie.presentation.WorkoutResponse;
import com.workoutgenie.rules.WorkoutRecommendationService;
import com.workoutgenie.validation.WorkoutRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommend")
@CrossOrigin(origins = "https://nice-forest-04041ed10.2.azurestaticapps.net")
public class WorkoutController {
	private WorkoutRecommendationService service = new WorkoutRecommendationService();

    @PostMapping
    public WorkoutResponse recommendWorkout(@RequestBody WorkoutRequest req) {
        String plan = service.getPlan(req);
        return new WorkoutResponse(plan);
	}
}
