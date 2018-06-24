package es.molabs.kata.bowlinggame;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameShould
{
	private Game game;
	
	@Test
	public void have_10_frames_and_two_rolls_per_frame()
	{
		for (int i=0; i < 10; i++)
		{
			game.roll(1);
			game.roll(1);
		}
		
		Assert.assertThat(game.isFinished(), Is.is(true));
		Assert.assertThat(game.score(), Is.is(20));
		
		game.roll(5);
		Assert.assertThat(game.score(), Is.is(20));
	}
	
	@Test
	public void score_the_pins_knocked_down_when_no_bonuses()
	{
		game.roll(2);
		game.roll(3);
		
		Assert.assertThat(game.score(), Is.is(5));
	}
	
	@Test
	public void double_next_roll_when_spare_bonus()
	{
		// Frame 1
		game.roll(7);
		game.roll(3);
		
		// Frame 2
		game.roll(5);
		
		Assert.assertThat(game.score(), Is.is(20));
	}
	
	@Test
	public void double_next_two_rolls_when_strike_bonus()
	{
		// Frame 1
		game.roll(10);
		
		// Frame 2
		game.roll(2);
		game.roll(3);
		
		Assert.assertThat(game.score(), Is.is(20));
	}
	
	@Test
	public void allow_three_rolls_when_spare_on_last_frame()
	{
		for (int i = 0; i < 9; i++)
		{
			game.roll(0);
			game.roll(0);
		}
		
		game.roll(7);
		game.roll(3);
		
		Assert.assertThat(game.isFinished(), Is.is(false));
		
		game.roll(1);
		
		Assert.assertThat(game.score(), Is.is(12));
	}
	
	@Test
	public void allow_three_rolls_when_strike_on_last_frame()
	{
		for (int i = 0; i < 9; i++)
		{
			game.roll(0);
			game.roll(0);
		}
		
		game.roll(10);
		
		Assert.assertThat(game.isFinished(), Is.is(false));
		
		game.roll(1);
		game.roll(1);
		
		Assert.assertThat(game.score(), Is.is(14));
	}
	
	@Before
	public void setUp()
	{
		game = new Game();
	}
}
