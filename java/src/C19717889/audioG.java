package C19717889;

import processing.core.PApplet;

public class audioG {
    AlansVisual myVisual;

    public audioG(AlansVisual myVisual)
    {
        this.myVisual = myVisual;
    }

    float colour = 0;

    public void render()
    {
        
        myVisual.colorMode(PApplet.HSB);
        float dist;
        float[] steps = myVisual.getSmoothedBands();
        float dgap = myVisual.width/steps.length; 
        colour = colour + 203/(steps.length*20f);
        if (colour > 255) {
            colour = 0;
        } 
        for(int i = 0 ; i < steps.length ; i ++)
        {
            dist = PApplet.map(i, 0, steps.length, 0, myVisual.width);
            myVisual.stroke(PApplet.map(myVisual.getAmplitude(), 0, 1, 0, 255), 255, 255);
            myVisual.strokeWeight(5.0f);
            myVisual.fill(colour, 203, 203);
            myVisual.rect(dist, myVisual.height/2, dgap * 0.5f,-steps[i]);
        }
    }
}
