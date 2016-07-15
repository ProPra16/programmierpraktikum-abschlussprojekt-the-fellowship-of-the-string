// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>

package FileHandling;

public class Babysteps {
	private boolean baby;
	private long limit;
	
	public Babysteps(boolean baby,long limit){
		this.baby=baby;
		if(baby) this.limit=limit;
		else{
			limit=0;
		}
	}
	public boolean value(){
		return this.baby;
	}
	
	public long limit(){
		return this.limit;
	}
}
