package TestLibrary;

import java.util.ArrayList;
import java.util.Iterator;

public class Method_Test_Results {
	
	String methodName;
	Feedback feed;
	float ranking;
	//int number_of_answers;
	ArrayList<Answer> answers;
	Boolean deal_breaker = false;
	
	
	public Method_Test_Results(String mn){
		
		methodName = mn;
		feed = new Feedback();
		ranking = (float)0.0;
		feed.addFeedbackln("For method "+methodName);
		answers = new ArrayList<Answer>();
		
	}
	
	
	public void addAnswer(Answer a){
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
		if(deal_breaker == false){return score;}
		else return (float)0;
	}
	
	
	public float getGradiatedScore(float maxScore){
		Iterator ansIt = answers.iterator();
		float score =(float)0;
		while(ansIt.hasNext()){
			Answer current = (Answer) ansIt.next();
			float weight = (current.getWeight());
			score = score +(((maxScore*weight)/current.getMax())*current.getLevel());
			
			
		}
		if(deal_breaker == false){return score;}
		else return (float)0;
	}
	
	void deal_breaker(){
		deal_breaker =true;
	}

}
