package SystemDesignLLD.DesignLLDProjects.GoogleDocs;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

abstract class DocumentElements{

    public abstract String render1();
}
class TextElement extends DocumentElements{
    private String text;//2
    public TextElement(String  text){
        this.text = text;
    }
    @Override
    public String render1() {
        return text;
    }
    /*
    🧠 Explanation
Stores text internally and returns it when rendered.//1
Example:
TextElement t = new TextElement("Hello");
System.out.println(t.render()); // Hello
     */
}
class ImageElement extends DocumentElements{
    private String imgPath;///3
    public ImageElement(String imgPath){
        this.imgPath = imgPath;
    }
    @Override
    public String render1() {
        return  "[Image: " + imgPath + "]";
    }
    /*
    🧠 Explanation

Stores image path and renders a placeholder representation.
Example:
ImageElement img = new ImageElement("cat.png");
System.out.println(img.render());
// [Image: cat.png]
     */
}
/*
🎉 What We Achieved

Each class is responsible for its own rendering.

TextElement renders text.
ImageElement renders images.

No more checking file extensions.
 */

public class PerfectLLDCodeGoogleDocs {
    public static void main(String[] args) {//4
        DocumentElements obj1 = new TextElement("Hello World");
        DocumentElements obj2 = new ImageElement("cow.png");

        System.out.println( obj1.render1());
        System.out.println( obj2.render1());

        /*
        Same method call, different behavior.
That is polymorphism.

📈 OCP Advantage
Want to add a table?
class TableElement extends DocumentElement {
    @Override
    public String render() {
        return "[Table]";
    }
}

No existing code needs to change.
This follows the Open/Closed Principle.
📌 Key Learning
Put behavior inside the object that owns the data.
Text data → TextElement
Image data → ImageElem
Each object manages itself.
🧠 Interview Statement
You can confidently say:
“I introduced a DocumentElement abstraction and used polymorphism so that each element is responsible for rendering itself.
 This removes conditional logic and makes the design extensible.”
         */
    }
}
//steps after the above classes are done.
/*
Excellent! Now you're thinking exactly like a software architect.

So far, we created:

DocumentElement → abstraction
TextElement → concrete implementation
ImageElement → concrete implementation

Now we need three more major components:

Document → stores and manages document data
Persistence → saves document data (file, database, cloud, etc.)
DocumentEditor → façade that coordinates the whole application

This matches your lecture notes in .
 */

/*
✅ Short Answer
Both codes are valid, but they serve different purposes.
Code 1: DocumentElement, TextElement, ImageElement

This is only the element hierarchy.

It solves:

Abstraction
Polymorphism
Open/Closed Principle
Code 2: Document, Persistence, DocumentEditor

This is the complete system design.

It uses:

The element hierarchy from Code 1
Document management
Persistence
Facade orchestration
🏆 Which One Is the Better Overall Design?

✅ Code 2 is the full professional design.

Code 1 is only one part of Code 2.

🧠 Why You Got Confused

You mixed:

Element abstraction layer
Document management layer
Persistence layer
Application façade layer

That is completely normal.

🏗️ Final Professional Architecture
Client (Main)
      ↓
DocumentEditor
   ├── Document
   │      └── List<DocumentElement>
   │              ├── TextElement
   │              └── ImageElement
   │
   └── Persistence
          ├── FileStorage
          └── DatabaseStorage

          🧠 Class Responsibilities Summary
Class	Responsibility
DocumentElement	Common abstraction for all elements
TextElement	Renders text
ImageElement	Renders images
Document	Manages document contents
Persistence	Saving contract
FileStorage	Saves to file
DatabaseStorage	Saves to database
DocumentEditor	Coordinates the application
Main	Client
🔥 SOLID Principles Applied
SRP

Each class has one responsibility.

OCP

Add new elements or storage types by extending classes.

LSP

All subclasses can replace their parent abstractions.

ISP

Persistence contains only one focused method.

DIP

DocumentEditor depends on Persistence, not concrete classes.

🧠 Interview Explanation

You can say:

“I separated document management from persistence and introduced a façade (DocumentEditor) that coordinates the workflow. High-level modules depend on abstractions, making the design scalable and easy to extend.”

🎯 Most Important Insight

DocumentEditor does not do the work itself. It delegates work to specialized classes.

This is the heart of professional software design.

🚀 What You Learned
Composition (Document contains DocumentElements)
Polymorphism (render() behavior differs per element)
Dependency Injection (Persistence passed into constructor)
Delegation
Facade Pattern
SOLID Principles
🔜 Possible Future Extensions

Without modifying existing code, you can add:

TableElement
VideoElement
CloudStorage
PDFExporter
VersionHistory

That is exactly what good design enables.
 */