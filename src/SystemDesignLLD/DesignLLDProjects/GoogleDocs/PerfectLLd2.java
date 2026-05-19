package SystemDesignLLD.DesignLLDProjects.GoogleDocs;

import java.util.ArrayList;
import java.util.List;

class Document{
    private List<DocumentElements> elmts = new ArrayList<>();

    public void addElements(DocumentElements elements){
        elmts.add(elements);

    }
    public void removeElements(DocumentElements elements){
        elmts.remove(elements);
    }
    public String render() {
        StringBuilder result = new StringBuilder();

        for (DocumentElements element : elmts) {
            result.append(element.render1());
        }


        return result.toString();
    }
}


interface Persistence {
    void save(String documentData);
}

class FileStorage implements Persistence {
    @Override
    public void save(String documentData) {
        System.out.println("Saving to file:");
        System.out.println(documentData);
    }
}

class DatabaseStorage implements Persistence {
    @Override
    public void save(String documentData) {
        System.out.println("Saving to database:");
        System.out.println(documentData);
    }
}
class DocumentEditor1 {
    private Document document;
    private Persistence persistence;

    public DocumentEditor1(Persistence persistence) {
        this.document = new Document();
        this.persistence = persistence;
    }

    public void addText(String text) {
        document.addElements(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElements(new ImageElement(imagePath));
    }

    public String renderDocument() {
        return document.render();
    }

    public void save() {
        String data = document.render();
        persistence.save(data);
    }
}
public class PerfectLLd2 {
    public static void main(String[] args) {
        Persistence persistence = new DatabaseStorage();

        DocumentEditor1 editor = new DocumentEditor1(persistence);

        editor.addText("Hello ");
        editor.addImage("cat.png");
        editor.addText(" Welcome!");

        System.out.println(editor.renderDocument());

        editor.save();
    }
}
/*
🌟 Why This Design Is Excellent
1. Single Responsibility Principle (SRP)
Class	Responsibility
TextElement	Render text
ImageElement	Render image
Document	Manage document contents
Persistence	Save contract
DatabaseStorage	Save to DB
DocumentEditor	Coordinate everything

2. Open/Closed Principle (OCP)
Add new features without modifying existing code.
Examples:
TableElement
VideoElement
CloudStorage

3. Liskov Substitution Principle (LSP)
Any DocumentElement subclass can be used wherever DocumentElement is expected.

4. Interface Segregation Principle (ISP)
Persistence contains only one focused method.

5. Dependency Inversion Principle (DIP)
DocumentEditor depends on Persistence, not concrete implementations.

🧠 Design Patterns Used
Facade Pattern → DocumentEditor
Strategy Pattern → Persistence
Composition → Document contains elements
Polymorphism → Different render behaviors
🎯 Interview-Level Summary

The design separates document elements, document management, persistence, and application orchestration. Each class has a focused responsibility, and the system is extensible through abstractions and polymorphism.

🏆 Final Verdict
Option	Verdict
Your first code	Good learning step, but incomplete and includes one design mistake
Second code	Full professional system design
Combined final code	Best design and interview-ready
❤️ Important Takeaway

You did not misunderstand the concepts. You successfully identified multiple layers and mixed them together, which is a natural part of learning system design.

The correct approach is:

Build the element hierarchy.
Build the Document.
Build the persistence abstraction.
Build the DocumentEditor.
Connect everything.
 */