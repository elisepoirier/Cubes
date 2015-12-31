import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;

public class Cube{
	
	private float x, y, z;
	private float tx, ty, tz;
	private float l;
	public float vitesseX=0;
	public float vitesseY=0;
	public float vitesseZ=0;

	public Cube(float x, float y, float z, float tx, float ty, float tz, float l) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		this.l= l;
	}

	public void update(){		
		vitesseX+=tx;
		vitesseY+=ty;
		vitesseZ+=tz;
	}
	
	public void init(GLAutoDrawable dr){
		GL2 gl = dr.getGL().getGL2();		
	}
	
	
	public void render(GLAutoDrawable dr){		
		GL2 gl = dr.getGL().getGL2();
		GLU glu = GLU.createGLU(gl);	
		
		gl.glBindTexture(gl.GL_TEXTURE_2D, iTexture);
	
		gl.glPushMatrix();	
		
		gl.glRotatef(vitesseX, 1f, 0f, 0f);
		gl.glRotatef(vitesseY, 0f, 1f, 0f);
		gl.glRotatef(vitesseZ, 0f, 0f, 1f);		
		
		gl.glBegin(gl.GL_QUADS);

		
		
		//avant 
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l); // -0.1 -0.1 -0.1
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z-l);	//  0.1 -0.1 -0.1
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z-l);	//  0.1  0.1 -0.1
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l); // -0.1  0.1 -0.1
        
        //arriere   
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z+l);
        
        //gauche     
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x-l,y+l,z-l);
        
        //droite      
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x+l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);
        
        //bas        
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y-l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y-l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y-l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y-l,z-l);
        
        //haut       
        gl.glTexCoord2d(0, 0); gl.glVertex3f(x-l,y+l,z-l);
        gl.glTexCoord2d(1, 0); gl.glVertex3f(x-l,y+l,z+l);
        gl.glTexCoord2d(1, 1); gl.glVertex3f(x+l,y+l,z+l);
        gl.glTexCoord2d(0, 1); gl.glVertex3f(x+l,y+l,z-l);	     

		gl.glEnd(); 
		
		gl.glPopMatrix();	
	}	
}
