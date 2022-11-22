package hu.webuni.studentregister202210.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class FinancedSemesterRequestDTO {

    private final long studentId;
    private long remainingFreeSemesters;

}
