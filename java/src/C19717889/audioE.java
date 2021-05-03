package C19717889;

import processing.core.PApplet;

public class audioE {

    AlansVisual myVisual;

    public audioE(AlansVisual myVisual)
    {
        this.myVisual = myVisual;
    }

    float colour = 0;

    public void render()
    {
        myVisual.colorMode(PApplet.HSB);
        float[] steps = myVisual.getSmoothedBands();
        float dgap = myVisual.width/steps.length; 
        colour = colour + 203/(steps.length*20f);
        if (colour > 255) {
            colour = 0;
        } 
        for(int i = 0 ; i < steps.length ; i ++)
        {
            myVisual.stroke(PApplet.map(myVisual.getAmplitude(), 0, 1, 0, 255), 255, 255);
            myVisual.strokeWeight(4.0f);
            myVisual.fill(colour, 203, 203);
            myVisual.ellipse(myVisual.width/2, myVisual.height/2, dgap * 2.5f ,steps[i]);
            myVisual.ellipse(myVisual.width/4, myVisual.height/2, dgap * 1.5f ,100 -steps[i]);
            myVisual.ellipse(myVisual.width - 250, myVisual.height/2, dgap * 1.5f ,100 -steps[i]);
            myVisual.ellipse(myVisual.width/11, myVisual.height/2, dgap * 1.0f ,100 -steps[i]);
            myVisual.ellipse(myVisual.width - 95, myVisual.height/2, dgap * 1.0f ,100 -steps[i]);
        }
    }
    
}
