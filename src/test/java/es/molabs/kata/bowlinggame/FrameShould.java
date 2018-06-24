package es.molabs.kata.bowlinggame;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FrameShould
{
	private Frame frame;
	
	@Test
	public void be_spare_if_all_pins_knocked_down_in_two_rolls()
	{
		frame.roll(5);
		frame.roll(5);		
		Assert.assertThat(frame.isSpare(), Is.is(true));
		
		frame = new Frame();
		frame.roll(10);
		Assert.assertThat(frame.isSpare(), Is.is(false));		
	}
	
	@Test
	public void be_strike_if_all_pins_knocked_down_in_one_roll()
	{
		frame.roll(10);		
		Assert.assertThat(frame.isStrike(), Is.is(true));
	}
	
	@Before
	public void setUp()
	{
		frame = new Frame();
	}
}
