package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotClass
{
	public static void main(String[] args) throws IOException, InterruptedException, AWTException 
	{
		Runtime.getRuntime().exec("notepad");	
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_Q);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_P);
		
	}
}
