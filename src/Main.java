import java.awt.Frame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        GLProfile glp = GLProfile.getDefault();
	        GLCapabilities caps = new GLCapabilities(glp);
	        GLCanvas canvas = new GLCanvas(caps);
	        canvas.addGLEventListener(new Render3D());
	        
	        FPSAnimator Anime = new FPSAnimator(canvas,30);
	        Anime.start();      
	       
	        Frame frame = new Frame("AWT Window Test");
	        frame.setSize(600, 600);
	        frame.add(canvas);
	        frame.setVisible(true);
	        
	        frame.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });      
	}

}