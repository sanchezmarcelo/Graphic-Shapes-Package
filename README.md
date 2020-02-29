# Graphic-Shapes-Package
Prompt:
Your boss wants software that is capable of the following tasks as well. See full details in the Tasks section below.
There is a third-party vendor whose software you must use in the application. (JAR file provided) The vendor software allows you to do the following things:
1. Set foreground colors
2. Set background colors
3. Show/hide the drawing - for backward compatibility, the default is that the drawing is visible
See the javadoc for details. To use many of these new features, you must extend the SimpleDrawing class from your third-party vendor and override the relevant methods. SimpleDrawing implements both ComponentListener and MouseListener and adds itself as the listeners for the appropriate events. If you extend SimpleDrawing, you will get the listeners for free. The new event handling methods are piggy-backed onto (wrap) the corresponding methods in the javax.swing package. You can get further information on how to use them there.

Tasks
1. Draw upward and downward pointing triangles. Triangles may have any shape you like.
2. Draw circles.
3. Draw parallelograms. Parallelograms may have any shape you like.
4. Draw diamonds. Diamonds may have any shape you like.
5. Draw arrows.
6. Draw dotted and dashed lines.
7. The user should be able to specify elements outside of the current dimensions of the drawing window. Your application should make these visible when the window is resized to include any elements whose coordinates are inside the resized window. This includes showing partial elements that overlap the edges of the window.
