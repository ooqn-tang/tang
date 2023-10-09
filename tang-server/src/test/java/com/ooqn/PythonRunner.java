package com.ooqn;

import java.io.IOException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

public class PythonRunner {
    public static void main(String[] args) throws IOException {
        try (Context context =  Context.newBuilder("python").option("python.CAPI", "true").build()) {
            Source pythonScript = Source.newBuilder("python", "print('Hello, GraalVM!')", "script.py").build();
            context.eval(pythonScript);
        }
    }
}
