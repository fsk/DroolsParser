package org.codexist;

import org.drools.compiler.builder.conf.DecisionTableConfigurationImpl;
import org.drools.drl.extensions.DecisionTableFactory;
import org.drools.io.FileSystemResource;
import org.kie.internal.builder.DecisionTableConfiguration;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        FileSystemResource xlsFile = new FileSystemResource(getFile("drools/rules/rule1/rule1.xlsx"));

        DecisionTableConfiguration decisionTableConfiguration = new DecisionTableConfigurationImpl();

        String generatedDrl = "";

        generatedDrl = DecisionTableFactory.loadFromResource(xlsFile, decisionTableConfiguration);

        System.out.println(generatedDrl);

    }

    private static File getFile(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(Objects.requireNonNull(resource).getFile());
    }
}