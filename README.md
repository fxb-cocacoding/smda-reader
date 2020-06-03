# smda-reader

JAVA library (with maven support) for parsing SMDA disassembly reports.

Version 0.4.x is supposed to work with YARA-Signator >= 0.4 and with smda reports in version 1.2.15.

### SMDA Version

This software has been tested to work with [smda](https://github.com/danielplohmann/smda) disassembly report format 1.2.15.
You can get the latest smda version via pip.

### Unit Tests

The Unit Tests are developed against SMDA reports for format 1.2.15. This is only a safety measure as long as you operate on smda disassembly reports in format 1.2.15. It is possible that new versions break the format and therefore might not be directly supported (although we keep smda-reader up-to-date against future smda releases).

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
mvn install:install-file -Dfile=target/smda-reader-0.4.0-SNAPSHOT.jar -DpomFile=pom.xml
```
Then add the project to your maven repository (the `<dependencies>`-section of your pom.xml) using the following statement:
```
    <!-- smda-reader -->
    <dependency>
      <groupId>com.cocacoding</groupId>
      <artifactId>smda-reader</artifactId>
      <version>0.4.0-SNAPSHOT</version>
    </dependency>
```
  
But you can use the generated jar-files also without maven, just add them to your JAVA project. The provided pom.xml file builds you a jar-file containing only the project and one with all dependencies (similar to a statically linked program). This makes it even easier for your to proceed.
