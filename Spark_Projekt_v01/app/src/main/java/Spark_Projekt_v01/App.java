/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Spark_Projekt_v01;

import spark.Spark;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Spark.get("/welcome", (req, res) -> {
            return "Hallo DevOps - By Ahmad";
        });
    }
}
