
import static org.lwjgl.glfw.GLFW.*; // Base

// OpenGL
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

public class Main {

    /**
     * Main Constructor
     */
    public Main() {

        // Init the framework
        if (!glfwInit()) {
            System.err.println("GLFW failed to initialize...");
            System.exit(1);
        }

        // Create the window
        long win = glfwCreateWindow(640, 480, "Window", 0, 0);

        // Show the window
        glfwShowWindow(win);

        // I need a context
        glfwMakeContextCurrent(win);

        // Create the context wit openGL
        GL.createCapabilities();

        // Allows the window to stay open
        while (!glfwWindowShouldClose(win)) {

            // Process all pending events
            glfwPollEvents();

            // Clear the context, set every pixel to black
            glClear(GL_COLOR_BUFFER_BIT);

            // Let's draw a quad
            glBegin(GL_QUADS);

            glColor4f(1,0,0,0);
            glVertex2f(-0.5f, 0.5f);

            glColor4f(0,1,0,0);
            glVertex2f(0.5f, 0.5f);

            glColor4f(0,0,1,0);
            glVertex2f(0.5f, -0.5f);

            glColor4f(1,1,1,0);
            glVertex2f(-0.5f, -0.5f);

            glEnd();

            // Swap the buffer, enabled to draw in the back
            // and eventually show swapping the two layers
            glfwSwapBuffers(win);
        }

        // Clear the memory
        glfwTerminate();
    }

    /**
     * Static Constructor
     *
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }

}
