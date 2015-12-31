import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Render3D implements GLEventListener{	
	ArrayList<Cube> CubeList = new ArrayList<Cube>();
	  
	Cube C1 = new Cube(0.0f,0.0f,0.0f,0.0f,-2f,0.0f,0.1f);	  
	Cube C2 = new Cube(0.0f,0.4f,0.0f, 2f, 0f, 0f,0.1f);	  
	Cube C3 = new Cube(0.0f,0.8f,0.0f, 0.0f, 0.0f,-2f,0.1f);
	  
	public void update(){	
		 C1.update();
		 C2.update();
		 C3.update();
	}
	
	public void render(GLAutoDrawable dr){	
		CubeList.add(C1);
		CubeList.add(C2);
		CubeList.add(C3);
		for(Cube leCube: CubeList){
			leCube.render(dr);		
		}    		
	}

	@Override
	public void display(GLAutoDrawable dr) {
		// TODO Auto-generated method stub
		GL2 gl = dr.getGL().getGL2();	
		gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
		update();
		render(dr);
	}

	@Override
	public void init(GLAutoDrawable dr) {
		// TODO Auto-generated method stub
		GL2 gl = dr.getGL().getGL2();
		
		gl.glShadeModel(gl.GL_SMOOTH);
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glClearDepthf(1.0f);
		
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glDepthFunc(gl.GL_LEQUAL);
		gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
				
		gl.glEnable(gl.GL_DEPTH_TEST);
		gl.glEnable(gl.GL_TEXTURE_2D);
		
		gl.glMatrixMode(gl.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		C1.init(dr);
		C2.init(dr);
		C3.init(dr);	
	}
}
