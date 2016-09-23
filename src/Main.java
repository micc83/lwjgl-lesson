
import static org.lwjgl.glfw.GLFW.*; // Base

// OpenGL
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;
import org.w3c.dom.Text;

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

        // After capabilities create texture
        Texture tex = new Texture("./res/texture.png");

        float x = 0;
        float y = 0;

        // Allows the window to stay open
        while (!glfwWindowShouldClose(win)) {

            // Process all pending events
            glfwPollEvents();

            if (glfwGetKey(win, GLFW_KEY_ESCAPE) == GL_TRUE) {
                glfwSetWindowShouldClose(win, true);
            }

            if (glfwGetKey(win, GLFW_KEY_A) == GL_TRUE) {
                x += 0.001f;
            }

            if (glfwGetMouseButton(win, GLFW_MOUSE_BUTTON_1) == GL_TRUE) {
                y += 0.001f;
            }

            // Clear the context, set every pixel to black
            glClear(GL_COLOR_BUFFER_BIT);

            tex.bind();

            // Let's draw a quad
            glBegin(GL_QUADS);


            glTexCoord2f(1, 1);
            glVertex2f(-0.5f + x, 0.5f + y);

            glTexCoord2f(0, 1);
            glVertex2f(0.5f + x, 0.5f + y);

            glTexCoord2f(0, 0);
            glVertex2f(0.5f + x, -0.5f + y);
            glVertex2f(-0.5f + x, -0.5f + y);

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
