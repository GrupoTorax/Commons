package org.torax.commons;

import java.util.ArrayList;
import java.util.List;

/**
 * An exam representation
 */
public class Exam {
    
    /** List of exam slices */
    private final List<ExamSlice> examSlices;

    public Exam() {
        this.examSlices = new ArrayList();
    }
    
    public void addExamSlice(ExamSlice examSlice) {
        examSlices.add(examSlice);
    }

    public int getNumberOfSlices() {
        return this.examSlices.size();
    }

    public ExamSlice getExamSlice(int index) {
        return examSlices.get(index);
    }
    
}
