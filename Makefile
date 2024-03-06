# makefile for toktik
# Nathan Wells
# 13 April 2023
JAVAC=/usr/bin/javac
JAVA = /usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Post.class User.class Node.class BinarySearchTree.class TokTik.class
		
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run:
	$(JAVA) -cp bin TokTik
