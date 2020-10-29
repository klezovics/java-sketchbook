package com.klezovich.demo.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OuterInnerMockTest {

    @Spy
    Inner spyInner;
    
    @InjectMocks
    Outer outer;
    
    static class Outer {
        private final Inner inner;

        Outer(Inner inner) {this.inner = inner;}
        
        String f() { return inner.f(); }
    }
    
    static class Inner {
        String f() {
            return "f";
        }
        
        String g() {
            return "g";
        }
    }
    
    @Test
    public void testMocksInit() {
        assertNotNull(spyInner);
        assertNotNull(outer);
    }

    @Test
    public void testSpyUsesRealMethod() {
        assertEquals("f", outer.f());
    }

    @Test
    public void testSpyCanFakeMethod() {
        when(spyInner.f()).thenReturn("fake");
        assertEquals("fake",outer.f());
    }
}
