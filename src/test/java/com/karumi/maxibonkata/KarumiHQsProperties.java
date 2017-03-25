package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Angelo Mastropietro on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {

    @Property
    public void whenMaxibonsTakenSingleDev_twoMaxLeft(@From(DevelopersGenerator.class) Developer developer) {
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developer);
        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void whenMaxibonsTakenMultiDevs_twoMaxLeft(List<@From(DevelopersGenerator.class) Developer> developers) {
        KarumiHQs karumiHQs = new KarumiHQs();
        karumiHQs.openFridge(developers);
        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }
}