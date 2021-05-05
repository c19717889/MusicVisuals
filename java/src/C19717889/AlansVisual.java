package C19717889;

import ie.tudublin.*;

public class AlansVisual extends Visual {

    public int selection = 1;
    audioA audio1;
    audioB audio2;
    audioC audio3;
    audioD audio4;
    audioE audio5;
    audioF audio6;
    audioG audio7;
    audioH audio8;
  
    public void settings()
    {
        size(1000, 700);
    }

    public void setup()
    {
        startMinim();
        loadAudio("JavaProject.mp3");
        colorMode(HSB);
        getAudioPlayer().play();
        audio1 = new audioA(this);
        audio2 = new audioB(this);
        audio3 = new audioC(this);
        audio4 = new audioD(this);
        audio5 = new audioE(this);
        audio6 = new audioF(this);
        audio7 = new audioG(this);
        audio8 = new audioH(this);
    }

    public void keyPressed()
    {
        switch(key) {
            case ' ':
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
              break;
            case '1':
                selection = 1;
            break;
            case '2':
              selection = 2;
              break;
            case '3':
              selection = 3;
            break;
            case '4':
              selection = 4;
            break;
            case '5':
              selection = 5;
            break;
            case '6':
              selection = 6;
            break;
            case '7':
              selection = 7;
            break;
            case '8':
              selection = 8;
            break;
            default:
              println("Please select between 1 - 9!");
        }
    }


    public void draw()
    {
        background(0);
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();

        switch(selection) {
            case 1:
                audio7.render();
            break;
            case 2:
                audio8.render();
                
            break;
            case 3:
                audio1.render();
            break;
            case 4:
                audio3.render();
            break;
            case 5:
                audio4.render();
            break;
            case 6:
                audio5.render();
            break;
            case 7:
                audio6.render();
                
            break;
            case 8:
                audio2.render();
            break;
            default:
              println("We've got space and time!");
        }
    }
}