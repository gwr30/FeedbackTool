package TestLibrary;

import java.util.ArrayList;
import java.util.Iterator;

public class AnswerCandidates implements Iterable {



	
	ArrayList<Method_Test_Results> answerList;
	float highestRank;
	
	public AnswerCandidates(){
		answerList = new ArrayList<Method_Test_Results>();
		highestRank = 0;
	}
	
	public void addResult(Method_Test_Results mtr){
		if(mtr.getRanking()>highestRank)
		{
			highestRank = mtr.getRanking();
			answerList.clear();
			answerList.add(mtr);
		}
		else if(mtr.getRanking()==highestRank)
		{
			answerList.add(mtr);
		}
	}
	
	public float getHighestRank(){
		return highestRank;
	}
	public void printList(){
		Iterator answerIterator=answerList.iterator();
		while(answerIterator.hasNext()){
			Answer currAnswer = (Answer) answerIterator.next();
			System.out.println(currAnswer.getName());
		}
	}
	
	/*public String returnList(){
		String ansList = "";
		Iterator answerIterator=answerList.iterator();
		while(answerIterator.hasNext()){
			Answer currAnswer = (Answer) answerIterator.next();
			ansList = ansList +"\n"+(currAnswer.getName());
		}
		
		return ansList;
	}*/

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return answerList.iterator();
	}

}