# LWJGL3 Lesson

## IntelliJ IDEA Configuration:

* Download `lwjgl.zip` from [here](https://www.lwjgl.org/) and uncompress it
* Create a new project on IntelliJ IDEA using JDK 8 (if not already installed get it from [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)), the path should be: `/Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk`
* Open the **Project Structure** screen, in libraries add a new item:
    * Select JAVA
    * Pick the `lwjgl/jar/lwjgl.jar` file and add it
    * A new **lwjgl** library is created
    * Within the same library add the following files/folders:
        * `lwjgl/src.zip`
        * `lwjgl/doc/` (as JavaDoc)
        * `lwjgl/native/`
* In the Run Configuration add this to VM options: `-XstartOnFirstThread`