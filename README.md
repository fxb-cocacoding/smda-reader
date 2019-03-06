# smda-reader
JAVA library (with maven support) for parsing SMDA disassembly reports

### What does it do?
You can use this project to parse SMDA disassembly reports (https://github.com/danielplohmann/smda).
Those disassembly reports are processed as SMDA objects. It saves you the time to write a json parser for the complex structure, for example gson (Google JSON JAVA library) cannot simply interpret the function graph.

PLUS: This projects can generate Ngrams for you from the instructions in the smda reports. It reads all instructions that follow each other into a fixed sized Ngram and skips code caves (but it does not continue, it breaks at code caves and starts new Ngrams, since you usually do not want to build a code cave over a uncertain amount of e.g. padding bytes).

### What dependencies does it use?
It uses gson. The rest is basically standard stuff. See the pom.xml file to see the details.

### How to use it:
You can easily integrate this repository into your codebase using maven:
```
git clone https://github.com/fxb-cocacoding/smda-reader.git
cd smda-reader
mvn package
mvn install:install-file -Dfile=target/smda-reader-0.0.1-SNAPSHOT.jar -DpomFile=pom.xml
```
Then add the project to your maven repository (the `<dependencies>`-section of your pom.xml) using the following statement:
```
    <!-- smda-reader -->
    <dependency>
      <groupId>com.cocacoding</groupId>
      <artifactId>smda-reader</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
```
  
But you can use the generated jar-files also without maven, just add them to your JAVA project. The provided pom.xml file builds you a jar-file containing only the project and one with all dependencies (similar to a statically linked program). This makes it even easier for your to proceed.
