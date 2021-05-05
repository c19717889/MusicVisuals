package C19717889;

import ie.tudublin.Visual;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
//import processing.core.PApplet;

public class AlansVisual extends Visual {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples
    float cx;
    float cy;
    float y = 200;
    float lerpedY = y;
    int which = 0;
    float theta;

    float[] lerpedBuffer;

    public void settings() {
        size(1000, 1000, P3D);
        cx = width / 2;
        cy = height / 2; 
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    

    public void setup() {
        minim = new Minim(this);
        //ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("heroplanet.mp3", width);
        ap.play();
        ab = ap.mix; // Connect the buffer to the mp3 file
        //ab = ai.mix; 
        colorMode(HSB);
        lerpedBuffer = new float[width];

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '9') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
        if (keyCode == UP)
        {
            twoCubes = ! twoCubes;
        }
    }

    

    float lerpedAverage = 0;
    private float angle = 0;

    private boolean twoCubes = false;

    void branch(float h) {
        // Each branch will be 2/3rds the size of the previous one
        h *= 0.66;
        
        // All recursive functions must have an exit condition!!!!
        // Here, ours is when the length of the branch is 2 pixels or less
        if (h > 2) {
          pushMatrix();    // Save the current state of transformation (i.e. where are we now)
          rotate(theta);   // Rotate by theta
          line(0, 0, 0, -h);  // Draw the branch
          translate(0, -h); // Move to the end of the branch
          branch(h);       // Ok, now call myself to draw two new branches!!
          popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state
          
          // Repeat the same thing, only branch off to the "left" this time!
          pushMatrix();
          rotate(-theta);
          line(0, 0, 0, -h);
          translate(0, -h);
          branch(h);
          popMatrix();
        }
    }


        
    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 1.1f);


        
        switch (which) {
            case 0: {
                background(0);
                frameRate(60);
                strokeWeight(1);
                stroke(255);
                // Let's pick an angle 0 to 90 degrees based on the mouse position
                float a = (mouseX / (float) width) * 360f;
                // Convert it to radians
                theta = radians(a);
                // Start the tree from the bottom of the screen
                // Center tree

                int numCircs = (int)(mouseX / 15.0f);
                float cgap = 255 / (float) numCircs;
                for(int i = 0 ; i < numCircs ; i ++)
                {
                    strokeWeight(3);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(cx, cy, w, w);
                    translate(0,90);
                    
                }

                for(int i = 0 ; i < numCircs ; i ++)
                {
                    strokeWeight(3);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(100, 50, w, w);
                    translate(0,90);
                    
                }

                for(int i = 0 ; i < numCircs ; i ++)
                {
                    strokeWeight(3);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(900, -200, w, w);
                    translate(0,90);
                    
                }


                
                
                translate(width/2,height);
                // Draw a line 180 pixels
                line(0,0,0,-180);
                // Move to the end of that line
                translate(0,-180);
                // Start the recursive branching!
                branch(120);

                // Right hand tree                      
                translate(400,0);
                line(0 ,200,0,-180);
                translate(0,-180);
                branch(170);

                // Left hand tree
                translate(-800,180);
                line(0 ,200,0,-180);
                translate(0,-180);
                branch(170);


                


            break;
            
            }
            case 1: {
                background(0);
                frameRate(100);
                strokeWeight(3);
                //stroke(255);
                // Let's pick an angle 0 to 90 degrees based on the mouse position
                float a = (mouseX / (float) width) * 360f;
                // Convert it to radians
                theta = radians(a);
                // Start the tree from the bottom of the screen
                // Center tree
                    translate(width/2,height);
                    // Draw a line 180 pixels
                    line(0,0,0,-180);
                    // Move to the end of that line
                    translate(0,-180);
                    // Start the recursive branching!
                    branch(120);

                    // Right hand tree
                    translate(400,0);
                    line(0 ,200,0,-180);
                    translate(0,-180);
                    branch(170);

                    // Left hand tree
                    translate(-800,180);
                    line(0 ,200,0,-180);
                    translate(0,-180);
                    branch(170);

                    break;
            }
            case 2: {
                background(0);
                frameRate(60);
                
                stroke(255);
                // Let's pick an angle 0 to 90 degrees based on the mouse position
                float a = (mouseX / (float) width) * 360f;
                // Convert it to radians
                theta = radians(a);
                // Start the tree from the bottom of the screen
                // Center tree

                int numCircs = (int)(mouseX / 15.0f);
                float cgap = 255 / (float) numCircs;
                //Center ellipse
                for(int i = 0 ; i < numCircs ; i ++)
                {
                    strokeWeight(2);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(cx, halfHeight + cy, w *2, w * 2);
                   
                    
                }

                //Left ellipse
                for(int i = 0 ; i < numCircs ; i ++)
                {
                    strokeWeight(1);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(30, 30, w * 1.5f, w *1.5f);
                    translate(0,0);
                    
                }

                //Right ellipse
                for(int i = 0 ; i < numCircs; i ++)
                {
                    strokeWeight(1);
                    fill(i * cgap, 20, 10);
                    float w = i * cgap;
                    ellipse(width - 30, 30, w *1.5f, w *1.5f);
                    translate(0,0);
                    
                }


                
                strokeWeight(3);
                translate(width/2,height);
                // Draw a line 180 pixels
                line(0,0,0,-180);
                // Move to the end of that line
                translate(0,-180);
                // Start the recursive branching!
                branch(120);

                // Right hand tree                      
                translate(400,0);
                line(0 ,200,0,-180);
                translate(0,-180);
                branch(170);

                // Left hand tree
                translate(-800,180);
                line(0 ,200,0,-180);
                translate(0,-180);
                branch(170);


            break;
            
            }

            
            case 3:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                  
                        strokeWeight(1);
                        triangle(halfHeight, halfHeight, i * lerpedBuffer[i], halfHeight * 2, halfHeight * lerpedBuffer[i], i);
                        triangle(halfHeight, halfHeight * 2, i - lerpedBuffer[i], halfHeight * 2, halfHeight/ lerpedBuffer[i], i);
                        //fill(i * cgap, 20, 10);
                        //float w = i * 4;
                        //ellipse(i, halfHeight - lerpedBuffer[i], halfHeight + lerpedBuffer[i], i);
                        //translate(0,0);
                    
                
                    //line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);
                }        
                break;
            }   
            case 4:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);        
                    rect(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                }        
                break;
            }
            case 5:
            {
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);        
                    line(0, i, lerpedBuffer[i] * halfHeight * 4, i);
                    line(width, i, width - (lerpedBuffer[i] * halfHeight * 4), i);
                    line(i, 0, i, lerpedBuffer[i] * halfHeight * 4);
                    line(i, height, i, height - (lerpedBuffer[i] * halfHeight * 4));
                }        
                break;
            }
            case 6:
            {
                float c = map(average, 0, 1, 0, 255);
                stroke(c, 255, 255);        
                strokeWeight(2);
                noFill();
                // See the difference lerping makes? It smooths out the jitteryness of average, so the visual looks smoother
                //ellipse(width / 4, 100, 50 + average * 500, 50 + average * 500);
                ellipse(width / 2, height / 2, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500)); 
                /*stroke(255);
                strokeWeight(2);
                
                line(x, y, width/2, height/2);*/
                float x = 20;
                float radius = 200;
                ellipse(x, y, radius, radius);
                if(radius > 2) {
                radius *= 0.75f; 
                }   
                
                
                break;
            }

            case 7:
            {
                float c = map(average, 0, 1, 0, 255);
                stroke(c, 0, 255);        
                strokeWeight(5);
                noFill();
                rectMode(CENTER);
                float size = 50 + (lerpedAverage * 500);
                //rect(width / 2, height / 2, size, size);
                line((width / 2), height / 4, (width / 2) - 200, (height - 300) * size);
                line(width / 2, height / 4, (width / 2) + 200, height - 300);
                line((width / 2) - 200, height - 300, (width / 2) + 200, height - 300);
                
                break;
            }
            case 8:
            {
                float r = 1f;
                int numPoints = 3;
                float thetaInc = TWO_PI / (float) numPoints;
                strokeWeight(2);                
                float lastX = width / 2, lastY = height / 2;
                for(int i = 0 ; i < 1000 ; i ++)
                {
                    float c = map(i, 0, 300, 0, 255) % 255.0f;
                    stroke(c, 255, 255, 100);
                    float theta = i * (thetaInc + lerpedAverage * 5);
                    float x = width / 2 + sin(theta) * r;
                    float y = height / 2 - cos(theta) * r;
                    r += 0.5f + lerpedAverage;
                    line(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
                // ??
                break;
            }
            case 9:
            {
                lights();
                strokeWeight(2);
                float c = map(lerpedAverage, 0, 1, 0, 255);
                stroke(c, 255, 255);
                noFill();
                //fill(100, 255, 255);
                angle += 0.01f;
                float s = 100 + (100 * lerpedAverage * 10);
                
                if (! twoCubes)
                {
                    translate(width / 2, height / 2, 0);
                    rotateY(angle);
                    rotateX(angle);
                    box(s);
                }
                else
                {
                    pushMatrix();
                    translate(width / 4, height / 2, 0);
                    rotateY(angle);
                    rotateX(angle);
                    box(s);
                    popMatrix();

                    pushMatrix();
                    translate(width * 0.75f, height / 2, 0);
                    rotateY(angle);
                    rotateX(angle);
                    box(s);
                    popMatrix();
                }
            }

            
        }       
    }
}
