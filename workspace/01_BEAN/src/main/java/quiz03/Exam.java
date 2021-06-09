package quiz03;

import java.util.List;

public class Exam {

	private List<Integer> scores;	// 5개의 점수
	private double average;			// 평균
	private char grade;				// A ~ F

	
	public void info() {
		// 평균과, 학점을 구하고 (호출)
		setAverage();
		setGrade();
		// 여기서 보여준다.
		System.out.println("scores: " + scores.toString());
		System.out.println("average: " + average);
		System.out.println("grade: " + grade);
	}
	
	
	public List<Integer> getScores() {
		return scores;
	}	
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	
	// Average를 구해야 하니까 setAverage를 하나 더 만들어 준다.
	public void setAverage() {		// 이름이 같지만 매개변수가 없는걸 통해서 두개 다 존재할 수 있다. (override)
		int total = 0;
		for (Integer score : scores) {
			total += score;
		}
		this.average = total / scores.size();
	}
	
	
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
	// grade도 구해야 하니까 하나 더 만들어준다.
	public void setGrade() {			// 얘도 직접 구해야 하니까 매개변수가 없게.
		if (average >= 90) grade = 'A';
		else if (average >= 80) grade = 'B';
		else if (average >= 70) grade = 'C';
		else if (average >= 60) grade = 'D';
		else grade = 'F';
		
	}
	
	
	
}
