package SystemDesignLLD.DesignLLDProjects.GoogleDocs;

import java.util.ArrayList;
import java.util.List;

class DocumentEditor{
    private List<String> elm = new ArrayList<>();
    public void addText(String txt){
        elm.add(txt);
    }
    public void addImage(String imgPath){
        elm.add(imgPath);
    }
    public String render() {
        StringBuilder output = new StringBuilder();

        for (String element : elm) {
            if (element.endsWith(".png") || element.endsWith(".jpg")) {
                output.append("[Image: ").append(element).append("]");
            } else {
                output.append(element);
            }
        }

        return output.toString();
    }
    public void save(){
        String data = render();
        System.out.println("save to file:"+ data);
    }
}
public class solidUnfollow {

}
/*
🧠 Real-World Analogy

Imagine you hire one employee to do everything:

Write document content
Render document
Detect image files
Save to file
Save to database in future
Export to PDF
Print

That one employee becomes overloaded.

That is exactly what our DocumentEditor class is doing.

📦 Class Overview
class DocumentEditor {
    private List<String> elements = new ArrayList<>();
    ...
}

The class stores all document elements in a list of strings.

Example contents of elements:

[
  "Hello World",
  "photo.png",
  "Welcome to Java"
]
🔍 Problem 1: Everything Is Stored as String

Both text and image paths are stored as plain strings.

elements.add("Hello World"); // Text
elements.add("photo.png");   // Image
Why is this bad?

The program cannot clearly distinguish between:

Text
Images
Tables
Videos
New lines
Tabs

It guesses based on filename extensions.

🔍 Problem 2: addText()
public void addText(String text) {
    elements.add(text);
}

This method adds text into the list.

Example:

editor.addText("Hello");

List becomes:

["Hello"]
🔍 Problem 3: addImage()
public void addImage(String imagePath) {
    elements.add(imagePath);
}

Example:

editor.addImage("cat.png");

List becomes:

["Hello", "cat.png"]

Still, both are just strings.

🔍 Problem 4: render()
if (element.endsWith(".png") || element.endsWith(".jpg"))

The system checks whether a string ends with .png or .jpg.

If yes → treat it as image.

Otherwise → treat it as text.

Example Rendering

Input:

editor.addText("Hello ");
editor.addImage("cat.png");

Output:

Hello [Image: cat.png]
🚨 Why This Is Dangerous

Suppose user writes:

editor.addText("myphoto.png is a file name");

The system mistakenly thinks this is an image.

That is a design flaw.

🔍 Problem 5: save()
public void save() {
    String data = render();
    System.out.println("Saving to file: " + data);
}

Responsibilities of this method:

Calls render()
Prepares data
Saves to file

Saving logic is tightly coupled to DocumentEditor.

❌ Violations of SOLID Principles
SRP — Single Responsibility Principle

DocumentEditor is responsible for:

Storing elements
Adding text
Adding images
Rendering
Detecting types
Saving

Too many reasons to change.

OCP — Open/Closed Principle

Adding a new element like Table requires modifying render().

if (element.endsWith(".png")) ...
else if (element.endsWith(".mp4")) ...
else if ...

The class keeps changing.

DIP — Dependency Inversion Principle

DocumentEditor directly saves to file instead of depending on an abstraction like Storage.

📉 Consequences of This Design

As features grow, the class becomes:

Huge
Hard to test
Hard to maintain
Bug-prone
Difficult to extend

This is often called a God Class.

🏢 Industry Perspective

Professional software teams avoid this kind of design because:

Many developers work simultaneously.
Changes in one feature should not break others.
New functionality should be added with minimal modification.
📌 Key Lesson

If one class has too many responsibilities, the design will eventually become difficult to maintain.

🧠 Interview Insight

In a Low-Level Design interview, you should:

Start with a simple design.
Identify its problems.
Refactor into smaller, focused classes.
Use abstractions and interfaces.

This demonstrates strong engineering thinking.
 */

/*
another example
class GoogleDoc {
    private String title;
    private String content = "";

    public GoogleDoc(String title) {
        this.title = title;
    }

    public void addText(String text) {
        content += text;
    }

    public void saveToDatabase() {
        System.out.println("Saving to MySQL database...");
    }

    public void exportToPDF() {
        System.out.println("Exporting to PDF...");
    }

    public void exportToWord() {
        System.out.println("Exporting to Word...");
    }

    public void exportToText() {
        System.out.println("Exporting to Text...");
    }

    public void sendEmail() {
        System.out.println("Sending document via email...");
    }

    public void printDocument() {
        System.out.println("Printing document...");
    }

    public void trackVersionHistory() {
        System.out.println("Tracking versions...");
    }

    public void collaborate() {
        System.out.println("Handling collaboration...");
    }
}
 */