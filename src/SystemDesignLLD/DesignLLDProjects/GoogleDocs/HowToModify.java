package SystemDesignLLD.DesignLLDProjects.GoogleDocs;

public class HowToModify {
}
/*
🎯 Goal of This Step

Instead of storing everything as plain String, we will represent each element as an object.

Old Design
List<String> elements;
New Design
List<DocumentElement> elements;

Now every element knows how to render itself.

🧠 Real-World Analogy

Think of a document as a box containing different objects:

📄 Text object
🖼️ Image object
📊 Table object
🎥 Video object

Each object knows how to display itself.

The document does not need to ask:

“Are you a text? Are you an image?”

It simply says:

“Please render yourself.”

This is polymorphism.

🏗️ Step 2: Create the Abstraction
abstract class DocumentElement {
    public abstract String render();
}
🔍 Meaning
DocumentElement is a parent class that defines a common contract:
Every document element must implement render().
This means all child classes are guaranteed to provide this method.
 */