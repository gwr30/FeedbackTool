package TestCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class Method_Test_Results {
	
	String methodName;
	Feedback feed;
	float ranking;
	//int number_of_answers;
	ArrayList<Answer> answers;
	
	
	public Method_Test_Results(String mn){
		
		methodName = mn;
		feed = new Feedback();
		ranking = (float)0.0;
		feed.addFeedbackln("For method "+methodName);
		//number_of_answers = 0;
		answers = new ArrayList<Answer>();
		
	}
	
	
	public void addAnswer(Answer a){
		//number_of_answers++;
		feed.addFeedbackln(a.getFeedback());
		answers.add(a);
		ranking = 0;
		Iterator it = answers.iterator();
		
		while (it.hasNext()){
			Answer current = (Answer) it.next();
			ranking = (float) (ranking +
					((1.0/answers.size())/current.getMax())*current.getLevel()) ;
		}
	}
	
	public float getRanking(){
		return ranking;
	}
	
	public Feedback getFeedback(){
		return feed;
	}
	
	public float getScore(float maxScore){
		Iterator ansIt = answers.iterator();
		float score =(float)0;
		while(ansIt.hasNext()){
			Answer current = (Answer) ansIt.next();
			float weight = (current.getWeight());
			score = score +(((maxScore*weight)*current.allCorrectInt()));
			
			
		}
		return score;
	}
	
	
	public float getGradiatedScore(float maxScore){
		Iterator ansIt = answers.iterator();
		float score =(float)0;
		while(ansIt.hasNext()){
			Answer current = (Answer) ansIt.next();
			float weight = (current.getWeight());
			score = score +(((maxScore*weight)/current.getMax())*current.getLevel());
			
			
		}
		return score;
	}

}
