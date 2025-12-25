package entities;

public class ExamQuestion {
    public Exam exam;
    public Question question;
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }



    public ExamQuestion(Exam exam, Question question) {
        this.exam = exam;
        this.question = question;
    }


}
