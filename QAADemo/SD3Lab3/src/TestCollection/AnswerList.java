package TestCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class AnswerList implements Iterable{

	
	ArrayList<Answer> answerList;
	int highestLevel;
	
	public AnswerList(){
		answerList = new ArrayList<Answer>();
		highestLevel = 0;
	}
	
	public void addAnswer(Answer a){
		if(a.getLevel()>highestLevel)
		{
			highestLevel = a.getLevel();
			answerList.clear();
			answerList.add(a);
		}
		else if(a.getLevel()==highestLevel)
		{
			answerList.add(a);
		}
	}
	
	public int getHighestLevel(){
		return highestLevel;
	}
	public void printList(){
		Iterator answerIterator=answerList.iterator();
		while(answerIterator.hasNext()){
			Answer currAnswer = (Answer) answerIterator.next();
			System.out.println(currAnswer.getName());
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return answerList.iterator();
	}

}
