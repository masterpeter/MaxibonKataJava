package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Angelo Mastropietro on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

    private static final String DEVELOPER_NAME = "Angelo";
    private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperProperties.class);

    @Property
    public void theNumberOfMaxibonsShouldBeGreaterThanZero(int numberOfMaxibons) {
        LOGGER.debug(String.valueOf(numberOfMaxibons));
        Developer developer = new Developer(DEVELOPER_NAME, numberOfMaxibons);
        LOGGER.debug(developer.toString());
        assertTrue(developer.getNumberOfMaxibonsToGrab() >= 0);
    }

    @Test
    public void theNumberOfMaxibonsIsCorrectlyAssignedToDevelopers() throws Exception {
        assertEquals(3, Karumies.PEDRO.getNumberOfMaxibonsToGrab());
        assertEquals(1, Karumies.ALBERTO.getNumberOfMaxibonsToGrab());
        assertEquals(0, Karumies.DAVIDE.getNumberOfMaxibonsToGrab());
        assertEquals(2, Karumies.SERGIO.getNumberOfMaxibonsToGrab());
        assertEquals(1, Karumies.JORGE.getNumberOfMaxibonsToGrab());
    }
}
