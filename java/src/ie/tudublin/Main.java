package ie.tudublin;

//import example.CubeVisual;
//import example.MyVisual;
//import example.RotatingAudioBands;
import C19717889.AlansVisual;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new AlansVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}