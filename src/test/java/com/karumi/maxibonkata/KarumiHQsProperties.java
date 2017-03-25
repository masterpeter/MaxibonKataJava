package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by Angelo Mastropietro on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {

    private KarumiHQs karumiHQs;

    @Before
    public void setUp() throws Exception {
        karumiHQs = new KarumiHQs(mock(Chat.class));
    }

    @Property
    public void whenMaxibonsTakenSingleDevThanTwoMaxLeft(@From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void whenMaxibonsTakenMultiDevsThanTwoMaxLeft(List<@From(DevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }
}