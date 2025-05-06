package com.course_feedback_system.analytics_service.service;

import com.course_feedback_system.shared.model.Answer;
import com.course_feedback_system.shared.model.FeedbackSubmission;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService implements IAnalyticsService {

    private final RestTemplate restTemplate;

    @Value("${gateway.url}")
    private String gatewayUrl;  // API Gateway URL

    @Override
    public Map<String, Object> getCourseFeedbackSummary(Long courseId) {
        List<FeedbackSubmission> submissions = fetchSubmissionsByCourse(courseId);
        return buildSummary(submissions);
    }

    @Override
    public Map<String, Object> getInstructorFeedbackSummary(Long instructorId) {
        List<FeedbackSubmission> submissions = fetchSubmissionsByInstructor(instructorId);
        return buildSummary(submissions);
    }

    @Override
    public List<Map<String, Object>> getTopRatedCourses(int limit) {
        List<Answer> answers = fetchAllAnswers();
        return processRatings(answers, Answer::getCourseId, limit);
    }

    @Override
    public List<Map<String, Object>> getTopRatedInstructors(int limit) {
        List<Answer> answers = fetchAllAnswers();
        return processRatings(answers, Answer::getInstructorId, limit);
    }

    private Map<String, Object> buildSummary(List<FeedbackSubmission> submissions) {
        int count = submissions.size();
        double avgRating = submissions.stream()
                .flatMap(sub -> fetchAnswersBySubmission(sub.getId()).stream())
                .filter(ans -> ans.getRating() != null)
                .mapToDouble(Answer::getRating)
                .average()
                .orElse(0.0);

        Map<String, Object> summary = new HashMap<>();
        summary.put("count", count);
        summary.put("averageRating", avgRating);
        return summary;
    }

    private List<FeedbackSubmission> fetchSubmissionsByCourse(Long courseId) {
        FeedbackSubmission[] submissions = restTemplate.getForObject(
                gatewayUrl + "/api/submissions/form/" + courseId,
                FeedbackSubmission[].class
        );
        return Arrays.asList(submissions);
    }

    private List<FeedbackSubmission> fetchSubmissionsByInstructor(Long instructorId) {
        FeedbackSubmission[] submissions = restTemplate.getForObject(
                gatewayUrl + "/api/submissions/instructor/" + instructorId,
                FeedbackSubmission[].class
        );
        return Arrays.asList(submissions);
    }

    private List<Answer> fetchAnswersBySubmission(Long submissionId) {
        Answer[] answers = restTemplate.getForObject(
                gatewayUrl + "/api/answers/submission/" + submissionId,
                Answer[].class
        );
        return Arrays.asList(answers);
    }

    private List<Answer> fetchAllAnswers() {
        Answer[] answers = restTemplate.getForObject(
                gatewayUrl + "/api/answers",
                Answer[].class
        );
        return Arrays.asList(answers);
    }

    private List<Map<String, Object>> processRatings(List<Answer> answers,
                                                     java.util.function.Function<Answer, Long> keyExtractor,
                                                     int limit) {
        return answers.stream()
                .filter(a -> a.getRating() != null)
                .collect(Collectors.groupingBy(
                        keyExtractor,
                        Collectors.averagingDouble(Answer::getRating)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
                .limit(limit)
                .map(e -> {
                    Map<String, Object> summary = new HashMap<>();
                    summary.put("id", e.getKey());
                    summary.put("averageRating", e.getValue());
                    return summary;
                })
                .collect(Collectors.toList());
    }
}
