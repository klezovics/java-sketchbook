package com.klezovich.demo.mustache;

import com.samskivert.mustache.Mustache;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TokenReplacementTest {


    @Test
    public void test() {
        var tmpl = Mustache.compiler().compile("Hello {{planet}}");
        var context = new HashMap<String, String>();
        context.put("planet", "Earth");
        assertEquals("Hello Earth", tmpl.execute(context));
    }
}
