package entities;

public class Answer {
    public  int id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public  String content;

    public Answer(String content, int id, boolean isCorrect, Question question) {
        this.content = content;
        this.id = id;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public  Question question;
    public boolean isCorrect;
}
