package es.molabs.kata.bowlinggame;

public class Frame
{
	private final static int MAX_PINS = 10;
	
	private Integer firstRoll;
	private Integer secondRoll;
	private Integer thirdRoll;
	
	public void roll(int pinsDown)
	{
		if (!hasFirstRoll())
		{
			firstRoll = pinsDown;
		}
		else if (!hasSecondRoll())
		{
			secondRoll = pinsDown;
		}
		else if (!hasThirdRoll())
		{
			thirdRoll = pinsDown;
		}
	}
	
	public boolean hasFirstRoll() 
	{
		return firstRoll != null;
	}
	
	public boolean hasSecondRoll()
	{
		return secondRoll != null;
	}
	
	public boolean hasThirdRoll()
	{
		return thirdRoll != null;
	}

	public boolean isSpare()
	{
		return 
			!isStrike() && 
			firstRoll != null && 
			secondRoll != null && 
			firstRoll + secondRoll == MAX_PINS;
	}

	public boolean isStrike()
	{
		return firstRoll != null && firstRoll == MAX_PINS;
	}
}