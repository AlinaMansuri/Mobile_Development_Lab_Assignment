package com.example.calculatorapp;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorHelper {
    public String calculateResult(String expression) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            Object result = engine.eval(expression);
            return result.toString();
        } catch (ScriptException | NullPointerException e) {
            return "Error";
        }
    }
}
