package es.molabs.kata.bowlinggame;

public class Game
{
	private final static int MAX_FRAMES = 10;
	
	private int score;
	private int frames;
	
	private Frame previousFrame;
	private Frame currentFrame;
	
	public Game()
	{
		score = 0;
		frames = 0;
		
		previousFrame = new Frame();
		currentFrame = new Frame();
	}
	
	public void roll(int pinsDown)
	{
		if (!isFinished())
		{			
			// First roll
			if (!currentFrame.hasFirstRoll())
			{
				if (previousFrame.isSpare() || previousFrame.isStrike())
				{
					score += pinsDown;
				} 
			}
			// Second roll
			else if (!currentFrame.hasSecondRoll())
			{
				if (previousFrame.isStrike() || (isLastFrame() && currentFrame.isStrike()))
				{
					score += pinsDown;
				} 
			}
			// Bonus roll
			else if (!currentFrame.hasThirdRoll())
			{
				score += pinsDown;
			}
			
			currentFrame.roll(pinsDown);		
			score += pinsDown;
			
			if (isCurrentFrameFinished())
			{
				nextFrame();
			}
		}
	}
	
	private void nextFrame()
	{
		frames++;
		
		previousFrame = currentFrame;
		currentFrame = new Frame();
	}
	
	private boolean isLastFrame()
	{
		return frames == MAX_FRAMES - 1;
	}
	
	private boolean isCurrentFrameFinished()
	{
		boolean finished = false;
		
		if (isLastFrame() && (currentFrame.isSpare() || currentFrame.isStrike()))
		{
			finished = currentFrame.hasThirdRoll();
		}
		else if (currentFrame.isStrike() || currentFrame.hasSecondRoll())
		{
			finished = true;
		}
		
		return finished;
	}
	
	public int score()
	{
		return score;
	}

	public boolean isFinished()
	{
		return frames >= MAX_FRAMES;
	}
}
