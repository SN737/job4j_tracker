package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0;
        double qtySubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
               sumScore =  subject.score() + sumScore;
               qtySubjects++;
            }
        }
        return sumScore / qtySubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScore = new ArrayList<>();
        double avgScoreByPupil = 0;

        for (Pupil pupil : pupils) {
            double sumScore = 0;
            double qtySubjects = 0;
            for (Subject subject : pupil.subjects()) {
               sumScore +=  subject.score();
                qtySubjects++;
            }
            avgScoreByPupil = sumScore / qtySubjects;
            averageScore.add(new Label(pupil.name(), avgScoreByPupil));
        }
        return averageScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> averageScore = new ArrayList<>();
        double avgScoreBySubj = 0;
        for (Pupil pupil : pupils) {
            double sumScore = 0;
            double qtyStudents = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore +=  subject.score();

            }
            qtyStudents++;
            avgScoreBySubj = sumScore / qtyStudents;
            averageScore.add(new Label(pupil.name(), avgScoreBySubj));
        }
        return averageScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}