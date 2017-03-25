package com.karumi.maxibonkata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Angelo Mastropietro on 25/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQsProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(KarumiHQsProperties.class);

    private KarumiHQs karumiHQs;
    private Chat mockChat;

    @Before
    public void setUp() throws Exception {
        mockChat = mock(Chat.class);
        karumiHQs = new KarumiHQs(mockChat);
    }

    @Property
    public void whenMaxibonsTakenSingleDevThanTwoMaxLeft(@From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);

        LOGGER.info(String.valueOf(karumiHQs.getMaxibonsLeft()));

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void whenMaxibonsTakenMultiDevsThanTwoMaxLeft(List<@From(KarumiesGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);

        LOGGER.info(String.valueOf(karumiHQs.getMaxibonsLeft()));

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void whenMaxibonsAreFinishedThanSendMessage(@From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);

        verify(mockChat).sendMessage(anyString());
    }
}