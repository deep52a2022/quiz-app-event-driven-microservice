package com.quiz.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QnAPair{

    private int questionId;
    private int selectedOptionId;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        QnAPair qnAPair = (QnAPair) o;
//        return questionId == qnAPair.questionId && selectedOptionId == qnAPair.selectedOptionId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(questionId, selectedOptionId);
//    }
}
