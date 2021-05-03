package C19717889;

import ie.tudublin.Visual;

public class fractals extends Visual {

    public void settings() {
        size(1000, 1000, P3D);
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    void drawCircle(int x, int y, float radius) {
        background(0);
        stroke(255);
        strokeWeight(2);
        line(x, y, width/2, height/2);
        ellipse(x, y, radius, radius);
        if(radius > 2) {
          radius *= 0.75f;
      //The drawCircle() function is calling itself recursively.
          drawCircle(x, y, radius);
        }
      }
    
}
